package com.project.team3.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.team3.dao.UserDAO;
import com.project.team3.service.UserService;
import com.project.team3.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@RestController
public class LoginRestController {

	@Autowired
	UserDAO dao;
	
	@Autowired
	UserService service;
	
	// abId를 전달받아서 해당 방명록을 json data로 리턴함
	@RequestMapping(value = "loginaction.do", produces = "application/json", method= RequestMethod.POST)
	public @ResponseBody User login(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session) throws Exception {
		User user = dao.tryLogin(id,pw);
		session.setAttribute("userId",user);
		return user;
	}
	
	
	
	@RequestMapping("/idCheck.do")
	  public String checkId(String id) throws Exception {
		  //String status = dao.checkId(id);
		String status = service.isIdAvailable(id);  
		return status;
	  }
	
	@RequestMapping("/updateUser.do" )
	  public int updateUser(@RequestParam("userId") String userId
			  ,@RequestParam("userPw") String userPw
			  ,@RequestParam("userEmail") String userEmail
			  ,@RequestParam("userNickname") String userNickname
			  ,@RequestParam("userName") String userName
			  ,@RequestParam("userAddress") String userAddress
			  ,@RequestParam("userBirth") String userBirth) throws Exception {
			User user = new User(userId, userPw, userName, userNickname, userEmail, userBirth, userAddress);
			return dao.updateUser(user);
	  }
	
	@RequestMapping("/deleteUser.do" )
	  public int deleteUser(HttpSession session) throws Exception {
		User user = (User)session.getAttribute("userId");
			return dao.deleteUser(user.userId);
	  }
	
	@RequestMapping("/findactionId.do")
	   public String findId(@RequestParam("name") String name, 
	                        @RequestParam("email") String email, 
	                        @RequestParam("birth") String birth) { 
	        
	       // DAO를 통해 아이디 찾기
	       String userId = dao.findId(name, email, birth);
	       
	       // 아이디가 있으면 반환하고, 없으면 메시지 반환
	       if (userId != null) {
	           return userId;  // 찾은 아이디를 반환
	       } else {
	           return "해당 정보로 등록된 아이디가 없습니다.";  // 아이디를 찾지 못한 경우 메시지 반환
	       }
	   }

	    
	    @RequestMapping("/findactionPassword.do")
	    public String findPassword(@RequestParam("id") String id, 
	                               @RequestParam("email") String email) { 
	         
	        // DAO를 통해 비밀번호 찾기
	        String userPassword = dao.findPassword(id, email);
	        
	        // 비밀번호가 있으면 반환하고, 없으면 메시지 반환
	        if (userPassword != null) {
	            return userPassword;  // 비밀번호 반환
	        } else {
	            return "해당 정보로 등록된 비밀번호가 없습니다.";  // 비밀번호가 없을 경우 메시지 반환
	        }
	    }

}
