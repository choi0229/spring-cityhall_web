package com.project.team3.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChatbotService {

    private final String PYTHON_SERVER_URL = "http://172.168.10.38:5000/api/chatbot"; // Python 서버 URL

    public String getIntentFromPython(String userInput) {
        RestTemplate restTemplate = new RestTemplate();
        
        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // 요청 바디 설정
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("message", userInput);

        // 요청 보내기
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Map> response = restTemplate.exchange(PYTHON_SERVER_URL, HttpMethod.POST, requestEntity, Map.class);

        // Python 서버에서 받은 응답에서 인텐트 추출
        Map<String, Object> responseBody = response.getBody();
        if (responseBody != null && responseBody.containsKey("intent")) {
            return responseBody.get("intent").toString();
        }
        return null;
    }
}
