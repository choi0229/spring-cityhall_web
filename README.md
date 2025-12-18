# 🏫 OO시청 통합 행정 서비스 웹 페이지

> 서울시청을 모델로 한 공공 행정 · 관광 · 데이터 분석 통합 웹 서비스

---

## 📌 프로젝트 개요

**OO시청 페이지**는 서울시청을 대상으로  
공공시설 예약, 관광 정보 제공, 데이터 분석, 챗봇 서비스를 통합한  
**행정 포털형 웹 서비스**입니다.

- 체육관·시민회관 등 **공공시설 예약 및 관리 기능**
- 남산타워, DDP 등 **주요 관광지 및 관광 코스 안내**
- 교통사고 데이터 기반 **통계 분석 시각화**
- 챗봇을 통한 **서울시 주요 정보 질의 응답**
- 공지사항 관리 및 사용자 권한 기반 접근 제어

---

## 👥 팀 구성

| 이름 | 역할 |
|----|----|
| **최용혁 (팀장)** | 공공시설 예약 · 관광 지도 · 공지사항 |
| 이규원 | 교통사고 통계 분석 |
| 이돈진 | 챗봇 기능 |
| 은희수 | 메인 UI · 회원 기능 |

---

## 🛠️ 기술 스택

### Front-end
- HTML
- JSP

### Back-end
- Spring Boot

### Database
- MySQL

### Collaboration
- GitHub
- Notion

---

## 👨‍💻 담당 역할 (최용혁 · 팀장)

### UI 구현
- 공공시설 예약 페이지
- 서울시 관광 지도
- 공지사항 등록 / 수정 / 상세 페이지

### 핵심 기능 구현
- 공공시설 예약 등록 / 수정 / 삭제
- 지도 기반 관광지 조회 및 추천 코스 안내
- 공지사항 CRUD 기능
- 관리자 / 일반 사용자 권한 분리

---

## 📆 개발 기간 및 관리

- **개발 기간** : 2024.09.13 ~ 2024.09.20
- GitHub 이슈 및 Notion을 활용한 기능 단위 작업 관리

---

## 🏗️ 시스템 설계

### 기능 구성
![기능 구성](https://github.com/user-attachments/assets/be240688-ec83-4996-b6a7-73c063dcaa93)

### 아키텍처
![아키텍처](https://github.com/user-attachments/assets/20f085e8-0fb9-4aab-b0ec-ec685875be6d)

### DB 모델링 (ERD)
![ERD](https://github.com/user-attachments/assets/e2d07829-5357-46c1-94cf-5b1ce244d5b1)

---

## ⚙️ 주요 기술 적용 사항

- **Interceptor**
  - 사용자 정보가 필요한 페이지 접근 시 로그인 강제 처리
- **AOP**
  - 로그, 예외 처리, 트랜잭션 로깅 모듈화
- **Logger**
  - `application.properties` 기반 로그 레벨 관리로 오류 최소화
- **권한 기반 UI 제어**
  - 관리자 / 일반 사용자에 따른 버튼 및 기능 노출 분기

---

## 📸 주요 화면 및 기능

### 메인 화면
![main](https://github.com/user-attachments/assets/c6c38274-580a-45e5-9e28-18d31001d934)
- 서울시 홍보 영상 자동 재생
- 주요 서비스 바로가기 제공

---

### 공공시설 예약
![rsv1](https://github.com/user-attachments/assets/34982630-7503-4b08-8e2e-dabee22d1d5c)
- 지도 기반 공공시설 조회
- 날짜 / 시간별 예약 현황 확인
- 카테고리 필터링 기능 제공

---

### 공공시설 예약 등록
![rsvApply](https://github.com/user-attachments/assets/e0bfcfe6-df55-42b5-81ae-4a2afb77f95e)
- 과거 날짜 예약 제한
- 시간 단위 예약 처리
- 중복 예약 방지 예외 처리

---

### 공공시설 예약 수정 · 삭제
![rsvModify](https://github.com/user-attachments/assets/af6b83cd-f434-413d-a436-4623a39220f5)
![rsvRemove](https://github.com/user-attachments/assets/734bee62-4a4e-4683-871b-1ef494570a54)
- 예약 일정 변경 및 취소 기능 제공

---

### 서울시 관광 지도
![travel1](https://github.com/user-attachments/assets/5540d52a-13eb-4640-b672-cfb1a3555ed8)
- 관광지 정보 지도 시각화
- 추천 관광 코스 연계 제공

---

### 관광 코스 상세
![travel](https://github.com/user-attachments/assets/2499b902-825f-4570-b3a0-30550443781e)
- 코스별 평점 및 후기 조회
- 사용자 후기 등록 기능
- 평균 평점 별점 시각화

---

### 공지사항
![notice](https://github.com/user-attachments/assets/e8d550be-bb72-467b-8e07-2a6a9f58377b)
- 관리자 전용 등록 / 수정 / 삭제
- 일반 사용자 읽기 전용 접근

---

### 회원 관리
![signup](https://github.com/user-attachments/assets/6c225cb9-9993-4075-93cd-624feb418ec9)
![login](https://github.com/user-attachments/assets/dfa82a7e-d6f3-46f7-88dd-077657ad5e22)
![find](https://github.com/user-attachments/assets/821ead4f-9027-4dfb-9a76-88394dfa1f03)
- 회원가입 및 ID 중복 검사
- 로그인 / 아이디 · 비밀번호 찾기 기능

---

## 📝 프로젝트 회고 (Lesson Learned)

- **최용혁**
  - JSP script 영역에서 Thymeleaf 변수 호출 시 `[[${key}]]` 사용
  - `.env` 파일을 활용한 API Key 보안 처리 경험
- **이규원**
  - SQL 정렬 기반 페이지네이션 처리 방식 이해
- **이돈진**
  - GPT-Neo 기반 챗봇 서버 구축
  - Spring Boot 연동 및 OpenWeatherMap API 활용 경험
- **은희수**
  - `onmouseover / onmouseout` 이벤트를 활용한 UI 인터랙션 개선

---

## 🔗 저장소
👉 GitHub Repository 링크
