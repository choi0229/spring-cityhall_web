package com.project.team3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.team3.dao.TravelDAO;
import com.project.team3.vo.Travel;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TravelController {
	
	@Autowired
	TravelDAO dao;
	
    @GetMapping("/travelMap.do")
    public String showTravelPage(HttpServletRequest req) {
    	List<Travel> travelList = dao.getTravelList();
    	req.setAttribute("travelList", travelList);
        return "/travelMap"; 
    }

}
