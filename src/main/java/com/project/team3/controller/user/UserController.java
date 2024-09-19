package com.project.team3.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.team3.dao.UserDAO;
import com.project.team3.service.UserService;
import com.project.team3.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserDAO dao;
	
	@Autowired
	UserService service;
	
	  @RequestMapping("/login.do")
	  public String login(HttpServletRequest req) throws Exception {
		  
		  return "login/login";
	  }

	  
	  @RequestMapping("/regForm.do")
	  public String regForm(HttpServletRequest req) throws Exception {
		  
		  return "login/regForm";
	  }
	  
	  
	  @RequestMapping("/regformaction.do")
	  public String insertReg(HttpServletRequest req,@RequestParam("id") String id
			  ,@RequestParam("pw") String pw
			  ,@RequestParam("email") String email
			  ,@RequestParam("name") String name
			  ,@RequestParam("nickname") String nickname
			  ,@RequestParam("birth") String birth
			  ,@RequestParam("address") String address) throws Exception {
		  User user = new User(id, pw, name, nickname, email, birth, address);
		  dao.createUser(user);
		  return "redirect:/main.do";
		  
	  }
	  
	  @RequestMapping("/logout.do")
	  public String logout(HttpSession session) throws Exception {
		  session.invalidate();
		  return "redirect:/main.do";
	  }
	  
	  @RequestMapping("/mypage.do")
	  public String getMypageForm(HttpServletRequest req, HttpSession session) throws Exception {
	      User user = (User) session.getAttribute("userId");  // 세션에서 userId 가져오기
	      if (user == null) {
	          return "redirect:/login.do";  // 세션에 userId가 없으면 로그인 페이지로 리다이렉트
	      }
	      
	      User loginUserId = service.getUserById(user.userId);  // userId로 사용자 정보 조회
	      req.setAttribute("user", loginUserId);
	      return "login/mypage";
	  }
	  
	  @RequestMapping("/findId.do")
	  public String getFindIdForm() throws Exception {
		  return "login/findid";
	  }
	  
	  @RequestMapping("/findPw.do")
	  public String getFindPwForm() throws Exception {
		  return "login/findpw";
	  }
}
