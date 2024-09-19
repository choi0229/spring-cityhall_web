package com.project.team3.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {

    private String apiKey;  // API 키를 저장할 변수
    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public WeatherService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    // API 키를 설정하는 메서드
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;  // 전달된 API 키로 설정
    }

    public String getWeatherData(String city) {
        if (this.apiKey == null || this.apiKey.isEmpty()) {
            return "API 키가 설정되지 않았습니다. 먼저 API 키를 설정하세요.";
        }

        try {
            String units = "metric";  // 섭씨 온도를 위한 단위 설정

            // API 요청 URL 구성
            URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                    .queryParam("q", city)
                    .queryParam("appid", apiKey)
                    .queryParam("units", units)
                    .encode(StandardCharsets.UTF_8)
                    .build()
                    .toUri();

            System.out.println("API 요청 URL: " + uri);

            // GET 요청으로 API 호출
            String response = restTemplate.getForObject(uri, String.class);

            System.out.println("API 응답: " + response);
            
            return parseWeatherResponse(response);  // 응답을 파싱하여 반환

        } catch (HttpClientErrorException e) {
            int statusCode = e.getStatusCode().value();
            switch (statusCode) {
                case 401:
                    return "API 키가 올바르지 않습니다. API 키를 확인하세요.";
                case 404:
                    return "도시 이름이 올바르지 않거나, 해당 도시의 날씨 정보를 찾을 수 없습니다.";
                default:
                    return "날씨 정보를 가져오는 중 문제가 발생했습니다. (오류 코드: " + statusCode + ")";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "날씨 정보를 가져오는 중 오류가 발생했습니다.";
        }
    }

    private String parseWeatherResponse(String jsonResponse) {
        try {
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode mainNode = rootNode.path("main");
            JsonNode weatherNode = rootNode.path("weather").get(0);

            String temperature = mainNode.path("temp").asText() + "°C";
            String description = weatherNode.path("description").asText();
            
            // 날씨 설명을 한국어로 번역
            String translatedDescription = translateDescriptionToKorean(description);

            return "현재 서울의 날씨는 " + translatedDescription + "이며, 기온은 " + temperature + "입니다.";

        } catch (Exception e) {
            e.printStackTrace();
            return "날씨 정보를 처리하는 중 오류가 발생했습니다.";
        }
    }

    private String translateDescriptionToKorean(String description) {
        // 영어-한국어 번역 맵
        Map<String, String> translationMap = new HashMap<>();
        translationMap.put("clear sky", "맑은 하늘");
        translationMap.put("few clouds", "약간의 구름");
        translationMap.put("scattered clouds", "흩어진 구름");
        translationMap.put("broken clouds", "구름이 많이 끼어 있음");
        translationMap.put("shower rain", "소나기");
        translationMap.put("rain", "비");
        translationMap.put("thunderstorm", "천둥번개");
        translationMap.put("snow", "눈");
        translationMap.put("mist", "안개");
        translationMap.put("overcast clouds", "온 하늘에 구름이 낀 상태");        
        // 필요에 따라 더 많은 번역 추가

        // 해당 설명에 대한 번역이 있으면 반환, 없으면 원본 설명 반환
        return translationMap.getOrDefault(description.toLowerCase(), description);
    }
}
