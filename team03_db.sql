create schema if not exists team03;
use team03;

# 유저
create table user (
	user_id varchar(50) primary key,
    user_pw varchar(50) not null,
    user_name varchar(50) not null,
    user_nickname varchar(50),
    user_email varchar(50),
    user_birth varchar(30),
    user_address varchar(30),
    user_manager int default 0
 ); 
 select*from user;
insert into user (user_id,user_pw,user_name,user_nickname,user_email, user_birth, user_address,user_manager) values("123","123","최용혁","최용혁","123@naver.com","2000-02-29","서울시 강서구",1);
insert into user (user_id,user_pw,user_name,user_nickname,user_email, user_birth, user_address,user_manager) values("이규원","1","이규원","이규원","123@naver.com","2002-05-29","서울시 강서구",1);
insert into user (user_id,user_pw,user_name,user_nickname,user_email, user_birth, user_address,user_manager) values("이돈진","2","이돈진","이돈진","123@naver.com","1998-02-29","서울시 강서구",1);
insert into user (user_id,user_pw,user_name,user_nickname,user_email, user_birth, user_address,user_manager) values("은희수","3","은희수","은희수","123@naver.com","2001-08-29","서울시 강서구",1);
insert into user (user_id,user_pw,user_name,user_nickname,user_email, user_birth, user_address,user_manager) values("코딩왕이규태","1","이규태","코딩왕이규태","123@naver.com","2024-09-10","서울시 강남",1);
insert into user (user_id,user_pw,user_name,user_nickname,user_email, user_birth, user_address,user_manager) values("대홍재","1","김홍재","대홍재","123@naver.com","2024-09-10","서울시 강남",1);

# 공지사항
CREATE TABLE board (
    board_id INT AUTO_INCREMENT PRIMARY KEY,
    board_title VARCHAR(100) NOT NULL,
    board_content VARCHAR(500),
    board_writer VARCHAR(50),
    board_registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (board_writer) REFERENCES user(user_id) ON DELETE CASCADE
);
 
insert into board (board_title,board_content,board_writer) values("평생교육진흥원 미화원 채용공고","평생교육진흥원 공고 제2024-44호 청사 및 시설 내·외부 청소, 환경정비 업무를 수행할 직원을 다음과 같이 공개모집합니다.","123");
insert into board (board_title,board_content,board_writer) values("2024 서울 마라톤 개최 안내","서울시는 대중교통 요금 인상을 결정하였습니다. 2024년 5월 1일부터 적용됩니다. 자세한 사항은 서울시 홈페이지를 참조해 주세요.","123");
insert into board (board_title,board_content,board_writer) values("한강공원 환경 정화 활동","서울시는 2024년 4월 10일부터 20일까지 시민 안전 점검을 실시합니다. 점검을 원하시는 분들은 사전 신청해 주세요.","123");
insert into board (board_title,board_content,board_writer) values("서울시 자원봉사자 모집","서울시는 다양한 자원봉사자를 모집합니다. 관심 있는 분들은 서울시 자원봉사센터로 문의해 주세요.","123"); 
insert into board (board_title,board_content,board_writer) values("군 의무복무 기간만큼 “기후동행카드 청년할인 연령”도 상향된다!","앞으로 국방의 의무를 다한 청년들은 의무 복무한 기간만큼 서울시 기후동행카드 청년할인 혜택을 연장하여 받을 수 있게 된다.","123"); 
insert into board (board_title,board_content,board_writer) values("제2기 서울 자치경찰위원회 비전발표 및 정책토론회 개최 안내","제2기 자치경찰위원회의 정책방향을 담은 비전발표회가 9월 9월 서울시청에서 열립니다. 이번에 공개될 정책방향은 시민의견, 자치경찰위원 의견, 서울의 치안환경, 1기 추진사업 등을 종합적으로 고려했습니다.","123"); 
insert into board (board_title,board_content,board_writer) values("2024 서울 자치경찰 숏폼 영상 공모전 개최","공모전명 : 서울 자치경찰 숏폼 영상 공모전으로  공모주제는 <시민을 편안하게 서울을 안전하게>를 주제로 서울 자치경찰의 활동을 쉽고 재미있게 60초 이내 짧은 영상으로 표현","123"); 
insert into board (board_title,board_content,board_writer) values("서울시, 추석 성수식품 불법행위 특별단속 실시"," 서울시 민생사법경찰국은 9월 2일부터 9월 13일까지 전통시장, 온라인 쇼핑몰 등을 대상으로 추석 성수식품의 원산지 표시 위반행위 및 보관기준 위반 등에 대한 특별단속에 나선다.","123"); 
insert into board (board_title,board_content,board_writer) values("매장 내 다회용 컵 이용 지원사업 참여자 모집","서울시에서 일회용 컵 사용을 줄이고 플라스틱 폐기물을 절감하기 위해 '매장 내 다회용 컵 지원사업' 참여 매장을 모집하오니 많은 참여 바랍니다.","123"); 
insert into board (board_title,board_content,board_writer) values("서울공예박물관 특별기획전 《공예로 짓는 집》","서울공예박물관은 다양한 장르와의 실험을 통해 공예의 새로운 역할과 가능성을 모색하는 특별기획전 《공예로 짓는 집》을 개최합니다.","123"); 

# 공공시설
CREATE TABLE facility (
    facility_id INT AUTO_INCREMENT PRIMARY KEY,
    facility_name VARCHAR(50),
    facility_type VARCHAR(50),
    lon DOUBLE,
    lat DOUBLE,
    img varchar(100),
    details varchar(100)
);

insert into facility(facility_name, facility_type, lon, lat,img, details) values('장충체육관','체육시설',127.00683,37.55818,'jangchung.jpg','찾아오는길 : 서울특별시 중구 동호로 241 (장충동2가)');
insert into facility(facility_name, facility_type, lon, lat,img, details) values('잠실운동장','체육시설',127.07188,37.51215,'jamsil.jpg','찾아오는길 : 서울특별시 송파구 올림픽로 25 (잠실동 10');
insert into facility(facility_name, facility_type, lon, lat,img, details) values('중구회현체육센터','체육시설',126.98159,37.5560,'junggu.jpg','찾아오는길 : 중구 퇴계로 12길 78(회현동 1가 115)');
insert into facility(facility_name, facility_type, lon, lat,img, details) values('효창운동장','체육시설',126.96123,37.54347,'hyochang.jpg','찾아오는길 : 서울특별시 용산구 효창원로 177-15 (효창동)');
insert into facility(facility_name, facility_type, lon, lat,img, details) values('롤파크','체육시설',126.98139,37.57112,'lolpark.jpg','찾아오는길 : 서울특별시 종로구 종로 33 (청진동) 그랑서울 3층');
insert into facility(facility_name, facility_type, lon, lat,img, details) values('서울클럽','체육시설',127.00385,37.55327,'seoulclub.jpg', '찾아오는길 : 서울특별시 종로구 종로 33 (청진동) 그랑서울 3층');
insert into facility(facility_name, facility_type, lon, lat, img, details) values('서울광장','문화시설',126.9780,37.5665,'seoul_square.jpg','찾아오는길 : 서울특별시 중구 세종대로 110 앞(태평로1가)');
insert into facility(facility_name, facility_type, lon, lat,img, details) values('남산타워','문화시설',126.98820,37.55123,'namsan.jpg','찾아오는길 : 서울특별시 용산구 남산공원길 105');
insert into facility(facility_name, facility_type, lon, lat,img, details) values('국립현대미술관','문화시설',126.98005,37.57863,'arthall.jpg','찾아오는길 : 서울특별시 종로구 삼청로 30');
insert into facility(facility_name, facility_type, lon, lat,img, details) values('CKL스테이지','공연장',126.98166,37.56851,'clk.jpg','찾아오는길 : 서울 중구 청계천로 40 지하 1층 CKL스테이지');
insert into facility(facility_name, facility_type, lon, lat,img, details) values('국립극장','공연장',126.99955,37.55273,'theater.jpg','찾아오는길 : 서울특별시 종로구 돈화문로 13 (관수동)');

# 공공시설 예약
CREATE TABLE reservation (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    reservation_name VARCHAR(50),
    reservation_date VARCHAR(30),
    starthour VARCHAR(30),
    endhour VARCHAR(30),
    participants VARCHAR(30),
    facility_id INT,
    user_id VARCHAR(50),
    FOREIGN KEY (facility_id) REFERENCES facility(facility_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
);	

# 09-19
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('채육대회', '2024-09-19','10:00','12:00','유권수. 최준호', '123', 1);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('단합대회', '2024-09-19','13:00','14:00','유권수. 최준호', '123', 1);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('축구경기', '2024-09-19','12:00','13:00','이돈진. 최용혁', '123', 2);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('야구경기', '2024-09-19','14:00','15:00','이돈진. 최용혁', '123', 2);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('농구경기', '2024-09-19','17:00','18:00','이규태. 김홍재', '123', 3);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('수영경기', '2024-09-19','20:00','21:00','이규태. 김홍재', '123', 4);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('테니스경기', '2024-09-19','10:00','12:00','유권수. 최준호', '123', 5);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('배구경기', '2024-09-19','13:00','14:00','유권수. 최준호', '123', 6);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('도서관예약', '2024-09-19','12:00','13:00','이돈진. 최용혁', '123', 7);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('미술관예약', '2024-09-19','14:00','15:00','이돈진. 최용혁', '123', 8);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('박물관예약', '2024-09-19','17:00','18:00','이규태. 김홍재', '123', 9);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('뮤지컬공연', '2024-09-19','20:00','21:00','이규태. 김홍재', '123', 10);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('임영웅 콘서트', '2024-09-19','21:00','22:00','이규태. 김홍재', '123', 11);
# 09-20
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('탁구경기', '2024-09-20','12:00','14:00','이규태, 김홍재','123',1);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('테니스경기', '2024-09-20','15:00','16:00','이규태, 김홍재','123', 1);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('배구경기', '2024-09-20','20:00','21:00','이규태, 김홍재','123', 2);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('농구경기', '2024-09-20','10:00','12:00','이규태, 김홍재','123', 3);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('축구경기', '2024-09-20','16:00','18:00','이규태, 김홍재','123', 4);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('야구경기', '2024-09-20','13:00','15:00','유권수. 최준호', '123', 5);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('단합대회', '2024-09-20','11:00','13:00','유권수. 최준호', '123', 6);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('박물관예약', '2024-09-20','16:00','17:00','정재곤, 이희만', '123', 7);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('미술관예약', '2024-09-20','18:00','19:00','정재곤, 이희만', '123', 8);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('도서관예약', '2024-09-20','20:00','21:00','이규태. 김홍재', '123', 9);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('이찬원 콘서트', '2024-09-20','14:00','16:00','이규태. 김홍재', '123', 10);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('뮤지컬 공연', '2024-09-20','19:00','22:00','이규태. 김홍재', '123', 11);
# 09-21
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('워크숍', '2024-09-21','15:00','17:00','이규태, 김홍재','123', 1);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('체육대회', '2024-09-21','09:00','11:00','이규태, 김홍재','123', 1);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('단합대회', '2024-09-21','14:00','15:00','이규태, 김홍재','123', 2);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('야구경기', '2024-09-21','15:00','18:00','이규태, 김홍재','123', 2);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('축구경기', '2024-09-21','13:00','14:00','유권수, 최준호', '123', 3);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('배구경기', '2024-09-21','15:00','17:00','유권수. 최준호', '123', 4);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('탁구경기', '2024-09-21','12:00','13:00','유권수. 최준호', '123', 5);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('테니스경기', '2024-09-21','10:00','11:00','유권수. 최준호', '123', 6);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('미술관 예약', '2024-09-21','09:00','10:00','김세헌, 김세훈', '123', 7);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('박물관 예약', '2024-09-21','12:00','14:00','김세헌, 김세훈', '123', 8);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('도서관 예약', '2024-09-21','19:00','20:00','김세헌, 김세훈', '123', 9);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('뮤지컬 공연', '2024-09-21','21:00','22:00','김세헌, 김세훈', '123', 10);
insert into reservation (reservation_name, reservation_date, starthour, endhour, participants,user_id, facility_id) values('아이유 콘서트', '2024-09-21','17:00','18:00','김세헌, 김세훈', '123', 11);

 # 관광명소
 create table tourist_attraction (
	id int auto_increment primary key,
    name varchar(30),
    lat double,
    lon double,
    icon varchar(100),
    hotspot int
 );

insert into tourist_attraction (name, lat, lon, icon, hotspot) values('경복궁',37.579617,126.977041, '/image/gyeongbokgung.png',1);
insert into tourist_attraction (name, lat, lon, icon, hotspot) values('남산타워',37.551169,126.988227,'/image/namsantower.png',1);
insert into tourist_attraction (name, lat, lon, icon, hotspot) values('롯데월드',37.511121,127.098158,'/image/lotteworld.png',1);
insert into tourist_attraction (name, lat, lon, icon, hotspot) values('동대문 디자인 플라자(DDP)',37.566343,127.009100,'/image/ddp.png',1);
insert into tourist_attraction (name, lat, lon, icon, hotspot) values('홍대거리',37.556253,126.923615,'/image/hongdae.png',1);
insert into tourist_attraction (name, lat, lon, icon, hotspot) values('서울숲',37.544207,127.037437,'/image/seoulforest.png',1);
insert into tourist_attraction (name, lat, lon, icon, hotspot) values('63스퀘어',37.519299,126.940931,'/image/63square.png',1);
insert into tourist_attraction (name, lat, lon, icon, hotspot) values('서울랜드',37.436206,127.008915,'/image/seoulland.png',1);
insert into tourist_attraction (name, lat, lon, hotspot) values('북촌 한옥마을',37.581487,126.984915,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('경희궁',37.571249,126.968135,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('서촌',37.578672,126.973103,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('광화문',37.572405,126.976890,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('국립극장',37.552862,126.999812,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('남산 케이블카',37.556596,126.983971,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('남산골 한옥마을',37.559317,126.994475,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('해방촌 신흥시장',37.545291,126.985065,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('연남동 카페거리',37.566159,126.922917,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('망원시장',37.556442,126.910977,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('합정',37.549463,126.913977,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('상수',37.547877,126.922384,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('여의도 한강공원',37.528245,126.932728,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('국회박물관',37.531867,126.919062,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('노량진 수산시장',37.513283,126.941057,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('밤도깨비야시장',37.528346,126.932500,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('뚝섬 한강공원',37.531541,127.066223,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('성수동 카페거리',37.544720,127.055761,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('이태원',37.534872,126.994455,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('경리단길',37.538432,126.987546,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('청계천',37.569688,127.006860,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('광장시장',37.570039,126.999603,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('동대문역사문화공원',37.567955,127.010917,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('한양도성박물관',37.572848,127.008497,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('서울대공원',37.427524,127.017025,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('국립현대미술관',37.427909,126.991196,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('렛츠런파크',37.445289,127.012209,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('국립과천과학관',37.438134,127.005772,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('롯데타워',37.512464,127.102543,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('석촌호수',37.508133,127.101503,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('잠실야구장',37.512261,127.071883,0);
insert into tourist_attraction (name, lat, lon, hotspot) values('잠실한강공원',37.517606,127.086710,0);

# 여행코스
create table course (
	course_id int auto_increment primary key,
    course_name varchar(100),
    attraction_id1 int,
    attraction_id2 int,
    attraction_id3 int,
    foreign key (attraction_id1) references tourist_attraction(id),
    foreign key (attraction_id2) references tourist_attraction(id),
    foreign key (attraction_id3) references tourist_attraction(id)
);

insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('경희궁 -> 경복궁 -> 북촌 한옥마을',9,1,10);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('광화문 -> 경복궁 -> 서촌',12,1,11);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('남산 케이블카 -> 남산타워 -> 국립극장',14,2,13);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('해방촌 신흥시장 -> 남산타워 -> 남산골 한옥마을',16,2,15);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('홍대거리 -> 연남동 카페거리 -> 망원시장',5,17,18);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('홍대거리 -> 합정 -> 상수',5,19,20);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('63빌딩 -> 여의도 한강공원 -> 국회박물관',7,21,22);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('63빌딩 -> 노량진 수산시장 -> 밤도깨비야시장',7,23,24);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('뚝섬 한강공원 -> 성수동 카페거리 -> 서울숲',25,26,6);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('서울숲 -> 이태원 -> 경리단길',6,27,28);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('동대문 디자인 플라자 -> 청계천 -> 광장시장',4,29,30);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('동대문 디자인 플라자 -> 동대문역사문화공원 -> 한양도성박물관',4,31,32);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('서울랜드 -> 서울대공원 -> 국립현대미술관',8,33,34);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('렛츠런파크 -> 국립과천과학관 -> 서울랜드',35,36,8);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('롯데월드 -> 롯데타워 -> 석촌호수',3,37,38);
insert into course(course_name, attraction_id1, attraction_id2, attraction_id3) values('롯데월드 -> 잠실한강공원 -> 잠실야구장',3,40,39);

# 댓글
CREATE TABLE comments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    details VARCHAR(500),
    user_id VARCHAR(50),
    course_id INT,
    rating DOUBLE,
    now DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);

insert into comments(details, user_id, course_id, rating) values('크리스마스 맛이에요','코딩왕이규태',1,5);
insert into comments(details, user_id, course_id, rating) values('별로에요ㅠ','123',1,2);
insert into comments(details, user_id, course_id, rating) values('너무 예뻐요','123',1,4);
insert into comments(details, user_id, course_id, rating) values('좋아요ㅎ','123',2,5);
insert into comments(details, user_id, course_id, rating) values('멋져용','코딩왕이규태',2,5);
insert into comments(details, user_id, course_id, rating) values('강추입니다','123',3,5);
insert into comments(details, user_id, course_id, rating) values('다음에도 갈래요','코딩왕이규태',3,5);
insert into comments(details, user_id, course_id, rating) values('차가 너무 막혀요ㅠ','123',4,2);
insert into comments(details, user_id, course_id, rating) values('사람이 너무 많아요','코딩왕이규태',4,1);
insert into comments(details, user_id, course_id, rating) values('좋습니다','123',5,5);
insert into comments(details, user_id, course_id, rating) values('베리굿','코딩왕이규태',5,5);
insert into comments(details, user_id, course_id, rating) values('원따봉','123',6,5);
insert into comments(details, user_id, course_id, rating) values('투따봉드립니다','코딩왕이규태',6,5);
insert into comments(details, user_id, course_id, rating) values('좋다ㅋ','대홍재',7,5);
insert into comments(details, user_id, course_id, rating) values('짱짱','123',7,5);
insert into comments(details, user_id, course_id, rating) values('낫베드ㅋ','대홍재',8,3);
insert into comments(details, user_id, course_id, rating) values('코딩잘하고싶다','코딩왕이규태',8,5);
insert into comments(details, user_id, course_id, rating) values('여기가 한국의 뉴욕..?','코딩왕이규태',9,5);
insert into comments(details, user_id, course_id, rating) values('굿ㅋㅋ','대홍재',9,5);
insert into comments(details, user_id, course_id, rating) values('다음에도 올래요','123',10,5);
insert into comments(details, user_id, course_id, rating) values('좋음','대홍재',10,5);
insert into comments(details, user_id, course_id, rating) values('별로','대홍재',11,2);
insert into comments(details, user_id, course_id, rating) values('다리가 아파요','코딩왕이규태',11,3);
insert into comments(details, user_id, course_id, rating) values('원픽이에요!','123',12,5);
insert into comments(details, user_id, course_id, rating) values('너무 좋아여!','대홍재',12,5);
insert into comments(details, user_id, course_id, rating) values('나쁘지 않아요','대홍재',13,4);
insert into comments(details, user_id, course_id, rating) values('추천드려요','코딩왕이규태',13,3);
insert into comments(details, user_id, course_id, rating) values('여기 너무 힘들어요','123',14,2);
insert into comments(details, user_id, course_id, rating) values('너무 많이 걸어요','대홍재',14,3);
insert into comments(details, user_id, course_id, rating) values('운동가야되는데','코딩왕이규태',15,5);
insert into comments(details, user_id, course_id, rating) values('너무 좋다','123',15,5);
insert into comments(details, user_id, course_id, rating) values('에버랜드보다 좋아여','코딩왕이규태',16,5);
insert into comments(details, user_id, course_id, rating) values('사람 너무 많음','대홍재',16,3);

