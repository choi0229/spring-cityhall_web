package com.project.team3.controller.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.team3.dao.FacilityDAO;
import com.project.team3.vo.Facility;
import com.project.team3.vo.User;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ReservationController {

	@Autowired
	FacilityDAO dao;
	
	@RequestMapping("/rsv.do")
	public String reservation(HttpServletRequest req, HttpSession session, Model model) {
		User user= (User)session.getAttribute("userId");
		req.setAttribute("user", user.userId);
		Dotenv dotenv = Dotenv.configure()
    		    .filename("kakaoApiKey.env") // 파일명 명시
    		    .directory("C:/lx/spring/workspace/team03") // .env 파일이 위치한 디렉토리
    		    .load();

    		String kakaoApiKey = dotenv.get("KAKAO_API_KEY");
         // 모델에 kakaoApiKey를 추가해서 Thymeleaf로 전달
         model.addAttribute("kakaoApiKey", kakaoApiKey);
		return "rsv/reservation";
	}
	
}
