package com.project.team3.controller.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.team3.dao.FacilityDAO;
import com.project.team3.vo.Facility;
import com.project.team3.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ReservationController {

	@Autowired
	FacilityDAO dao;
	
	@RequestMapping("/rsv.do")
	public String reservation(HttpServletRequest req, HttpSession session) {
		User user= (User)session.getAttribute("userId");
		req.setAttribute("user", user.userId);
		return "rsv/reservation";
	}
	
}
