package com.project.team3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.team3.dao.BoardDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	@Autowired
	BoardDAO dao;
	
	@RequestMapping(value = {"/","/main.do"})
	public String main(HttpServletRequest req) {
		req.setAttribute("boards",dao.getRecentBoards());
		return "main";
	}
	
}
