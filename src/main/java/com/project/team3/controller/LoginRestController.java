package com.project.team3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.team3.dao.UserDAO;
import com.project.team3.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@RestController
public class LoginRestController {

	@Autowired
	UserDAO dao;
	
	// abId를 전달받아서 해당 방명록을 json data로 리턴함
	@RequestMapping(value = "loginaction.do", produces = "application/json", method= RequestMethod.POST)
	public @ResponseBody User login(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session) throws Exception {
		User user = dao.tryLogin(id,pw);
		session.setAttribute("userId",user);
		return user;
	}
	
	
	
	@RequestMapping("/idCheck.do")
	  public String checkId(String id) throws Exception {
		  String status = dao.checkId(id);
	
		  return status;
	  }
}
