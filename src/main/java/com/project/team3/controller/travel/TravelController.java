package com.project.team3.controller.travel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.team3.dao.TravelDAO;
import com.project.team3.vo.Travel;
import com.project.team3.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TravelController {
	
	@Autowired
	TravelDAO dao;
	
    @GetMapping("/travelMap.do")
    public String showTravelPage(HttpServletRequest req, HttpSession session) {
    	List<Travel> travelList = dao.getTravelList();
    	User user = (User)session.getAttribute("userId");
    	req.setAttribute("user",user.userId);
    	req.setAttribute("travelList", travelList);
        return "/travelMap"; 
    }

}
