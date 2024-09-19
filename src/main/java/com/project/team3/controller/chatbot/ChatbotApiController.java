package com.project.team3.controller.chatbot;

import com.project.team3.service.ChatbotService;
import com.project.team3.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotApiController {

    private final ChatbotService chatbotService;
    private final WeatherService weatherService;

    @Autowired
    public ChatbotApiController(ChatbotService chatbotService, WeatherService weatherService) {
        this.chatbotService = chatbotService;
        this.weatherService = weatherService;

        // 여기에서 API 키를 설정합니다.
        weatherService.setApiKey("fb6a9ffe035b84e20682d68686fbd185");  // 실제 API
    }

    @PostMapping
    public Map<String, String> getChatbotResponse(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        String userInput = request.get("message");

        try {
            // 1. Python 서버로부터 인텐트 가져오기
            String intent = chatbotService.getIntentFromPython(userInput);

            // 2. 인텐트에 따라 답변을 설정
            String answer;
            switch (intent) {
                case "weather_info":
                    answer = weatherService.getWeatherData("Seoul");
                    break;
                case "business_hours":
                    answer = "서울시 공공기관의 일반 업무 시간은 월요일부터 금요일까지, 오전 9시부터 오후 6시까지입니다.";
                    break;
                case "cultural_event_info":
                    answer = "서울시는 다양한 문화 행사를 제공합니다. 자세한 일정은 서울시 공식 문화행사 홈페이지에서 확인 가능합니다.";
                    break;
                case "hello_info":
                    answer = "안녕하세요? 서울시 챗봇입니다. 무엇을 도와드릴까요?";
                    break;
                case "report_issue":
                    answer = "불편 사항은 120 다산콜센터 또는 서울시 신고마당을 통해 접수 가능합니다. 빠르게 처리해드리겠습니다.";
                    break;
                case "city_hall_info":
                    answer = "서울시청은 서울특별시 중구 세종대로 110에 위치해 있습니다. 전화는 02-120으로 연락 가능합니다.";
                    break;
                case "transport_info":
                    answer = "서울의 대중교통은 지하철, 버스, 택시로 이루어져 있으며, 서울시 교통정보센터에서 실시간 정보를 확인하실 수 있습니다.";
                    break;
                case "waste_management_info":
                    answer = "서울시의 쓰레기 배출 및 재활용 규정은 서울시 청소행정 페이지에서 확인하실 수 있습니다. 배출 시간과 방법을 준수해 주세요.";
                    break;
                case "park_info":
                    answer = "서울에는 서울숲, 올림픽공원, 한강공원 등 여러 공원이 있으며, 각 공원의 이용 정보는 서울시 공원관리센터에서 확인 가능합니다.";
                    break;
                case "covid_info":
                    answer = "서울시의 코로나19 방역지침과 백신 접종 정보는 서울시 코로나19 페이지에서 제공됩니다.";
                    break;
                case "ev_charging_info":
                    answer = "서울시 전기차 충전소 위치는 서울시 환경국에서 제공하는 정보를 확인하시거나 서울시 전기차 충전소 지도 앱을 사용하시면 편리합니다.";
                    break;
                case "library_info":
                    answer = "서울시 내 도서관 정보는 서울시 도서관 포털을 통해 확인할 수 있으며, 각 도서관의 운영 시간과 대출 방법을 확인하실 수 있습니다.";
                    break;
                case "hospital_info":
                    answer = "서울시 내 주요 병원 정보는 서울시 보건소 홈페이지에서 제공되며, 응급실 이용 정보도 포함됩니다.";
                    break;
                case "tourist_info":
                    answer = "서울의 주요 관광 명소로는 경복궁, 남산타워, 인사동 등이 있습니다. 관광 안내는 서울시 관광 포털에서 확인하세요.";
                    break;
                case "food_info":
                    answer = "서울에서 유명한 맛집으로는 광장시장, 명동칼국수, 북촌 한옥마을 인근의 전통 음식점 등이 있습니다.";
                    break;
                case "pharmacy_info":
                    answer = "서울시 약국의 위치 정보는 서울시 보건소 또는 약국 정보 웹사이트에서 확인 가능합니다.";
                    break;
                case "public_transport_card_info":
                    answer = "서울시 대중교통 카드는 지하철과 버스 모두에서 사용할 수 있으며, 충전은 편의점이나 지하철역에서 가능합니다.";
                    break;
                case "embassy_info":
                    answer = "서울 내의 대사관 정보는 각 국가의 대사관 웹사이트에서 확인 가능하며, 긴급 상황 시 대사관에 연락할 수 있습니다.";
                    break;
                case "tax_info":
                    answer = "서울시의 세금 납부 관련 정보는 서울시 세무과에서 제공하며, 온라인 납부 시스템도 이용 가능합니다.";
                    break;
                case "parking_info":
                    answer = "서울시의 공영 주차장 정보는 서울시 주차관리센터 웹사이트에서 제공되며, 요금 및 주차 가능 시간도 확인하실 수 있습니다.";
                    break;
                case "government_service_info":
                    answer = "서울시의 복지 서비스 정보는 서울시 복지정책과 웹사이트에서 확인 가능하며, 관련 지원 제도를 상세히 안내합니다.";
                    break;
                case "public_facility_info":
                    answer = "서울시 내 공공시설(체육관, 도서관 등)의 이용료와 운영 시간 정보는 서울시 공공시설 안내 페이지에서 확인 가능합니다.";
                    break;
                case "government_office_info":
                    answer = "서울시 내 각 구청의 위치와 연락처는 서울시 행정정보센터에서 확인 가능하며, 민원 서비스도 제공됩니다.";
                    break;
                case "education_info":
                    answer = "서울시 내 학교 및 교육 관련 정보는 서울시 교육청 웹사이트에서 확인 가능합니다.";
                    break;
                case "social_welfare_info":
                    answer = "서울시 내 사회복지관의 정보는 각 구청의 복지 서비스 페이지에서 확인할 수 있으며, 다양한 복지 프로그램이 운영됩니다.";
                    break;
                case "famous_spot_info":
                    answer = "서울의 유명 관광지로는 북촌 한옥마을, 덕수궁, 창덕궁 등이 있으며, 각 장소는 서울시 관광 포털에서 자세히 안내됩니다.";
                    break;
                case "entertainment_info":
                    answer = "서울시의 유흥 시설 정보는 각 지역의 가이드북이나 유흥업소 관리 페이지에서 확인 가능합니다.";
                    break;
                case "market_info":
                    answer = "서울의 재래시장으로는 남대문시장, 동대문시장 등이 있으며, 다양한 전통 물건을 구입하실 수 있습니다.";
                    break;
                case "city_hall_services":
                    answer = "서울시청에서는 다양한 행정 서비스를 제공합니다. 민원 접수, 공공 서비스 등은 서울시 홈페이지에서 확인 가능합니다.";
                    break;
                case "theater_info":
                    answer = "서울의 주요 공연장 정보는 세종문화회관, 예술의전당 등의 홈페이지에서 확인 가능하며, 공연 일정도 포함됩니다.";
                    break;
                case "bike_rental_info":
                    answer = "서울시의 자전거 대여 서비스인 따릉이는 서울 전역에 배치되어 있으며, 따릉이 앱을 통해 대여 및 반납이 가능합니다.";
                    break;
                case "car_rental_info":
                    answer = "서울시 내 렌터카 서비스 정보는 서울시 렌터카 협회 웹사이트에서 확인 가능합니다.";
                    break;
                case "taxi_info":
                    answer = "서울시의 택시 요금 및 이용 정보는 서울시 교통국 웹사이트에서 제공되며, 대리운전 서비스도 이용 가능합니다.";
                    break;
                case "fire_department_info":
                    answer = "서울시 소방서의 연락처는 119이며, 긴급 상황 시 이용하실 수 있습니다.";
                    break;
                case "police_info":
                    answer = "서울시 경찰서의 긴급 연락처는 112이며, 범죄 신고와 긴급 상황에 대응합니다.";
                    break;
                case "port_info":
                    answer = "서울의 주요 항구 정보는 서울시 해양수산국에서 제공되며, 관련 운항 일정도 확인 가능합니다.";
                    break;
                case "airport_info":
                    answer = "서울시에는 김포공항과 인천공항이 있으며, 각 공항의 정보는 공식 웹사이트에서 확인 가능합니다.";
                    break;
                case "hotel_info":
                    answer = "서울시의 호텔 및 숙박 시설 정보는 서울시 관광 포털에서 제공되며, 예약 시스템도 함께 이용하실 수 있습니다.";
                    break;
                case "date_time_info":
                    answer = "현재 시간과 날짜는 기기 설정을 참고해 주세요.";
                    break;
                case "holiday_info":
                    answer = "서울시의 연휴 및 휴가 일정은 서울시 달력 페이지에서 확인할 수 있습니다.";
                    break;
                case "news_info":
                    answer = "서울시의 최신 뉴스는 서울시 공식 뉴스 포털에서 확인 가능합니다.";
                    break;
                case "shopping_mall_info":
                    answer = "서울의 대형 쇼핑몰로는 코엑스, 롯데월드몰 등이 있으며, 각 쇼핑몰의 정보는 해당 웹사이트에서 확인 가능합니다.";
                    break;
                case "bank_info":
                    answer = "서울시의 은행 위치 및 운영 시간 정보는 각 은행의 홈페이지에서 확인 가능합니다.";
                    break;
                case "legal_service_info":
                    answer = "서울시의 법률 서비스는 서울시 법률 지원 센터에서 제공하며, 무료 상담 서비스도 이용할 수 있습니다.";
                    break;
                case "insurance_info":
                    answer = "서울시의 보험 가입 관련 정보는 보험사 및 서울시 재무관리과에서 제공됩니다.";
                    break;
                case "internet_info":
                    answer = "서울시의 무료 와이파이 서비스는 공공장소에서 제공되며, 서울시 인터넷 정보 페이지에서 상세 위치를 확인할 수 있습니다.";
                    break;
                case "religion_info":
                    answer = "서울시 내의 주요 종교 시설로는 교회, 사찰, 성당 등이 있으며, 각 시설의 위치 정보는 해당 종교 단체의 웹사이트에서 확인 가능합니다.";
                    break;
                case "help_info":
                    answer = "서울시 챗봇 도움말입니다. 이용에 불편이 있으면 문의해 주세요.";
                    break;
                default:
                    answer = "죄송합니다. 원하시는 답변을 찾지 못했어요.";
                    break;
            }

            response.put("answer", answer);
        } catch (Exception e) {
            response.put("answer", "요청을 처리하는 중 오류가 발생했습니다. 다시 시도해 주세요.");
            e.printStackTrace();
        }

        return response;
    }
}
