package com.project.team3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.team3.dao.UserDAO;
import com.project.team3.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserDAO dao;
	
	  @RequestMapping("/login.do")
	  public String login(HttpServletRequest req) throws Exception {
		  
		  return "login/login";
	  }

	  
	  @RequestMapping("/regForm.do")
	  public String regForm(HttpServletRequest req) throws Exception {
		  
		  return "login/regForm";
	  }
	  
	  
	  @RequestMapping("/regformaction.do")
	  public String insertReg(HttpServletRequest req,@RequestParam("id") String id, String pw, String email, String name, String nickname, String birth, String address) throws Exception {
		  User user = new User(id, pw, name, nickname, email, birth, address);
		  dao.createUser(user);
		  return "main";
		  
	  }
	  
	  @RequestMapping("/logout.do")
	  public String logout(HttpSession session) throws Exception {
		  session.invalidate();
		  return "main";
	  }
}
