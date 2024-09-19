package com.project.team3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.team3.service.UserService;
import com.project.team3.vo.User;


@Repository
public class UserDAO {

	@Autowired
	SqlSession session;
	
	
	// 로그인
	public User tryLogin(String userId, String userPw) throws Exception {
		User user = new User(userId, userPw);
		return session.selectOne("tryLogin", user);
					
	}
	
	// 회원가입
	public int regUser(User user) throws Exception {
		return session.insert("regUser",user);
		
	}

	// 아이디 중복확인
	public String checkId(String id) {
		return session.selectOne("checkId",id);
	}
	
	public User getUserById(String id) {
		return session.selectOne("getUserById",id);
	}

	public int createUser(User user) {
		return session.insert("createUser",user);
		
	}
	
	public int updateUser(User user) {
		return session.update("updateUser",user);
		
	}
	
	public int deleteUser(String id) {
		return session.delete("deleteUser",id);
		
	}
	
	public String findId(String name, String email, String birth) {
	       Map<String, Object> params = new HashMap<>();
	       params.put("name", name);
	       params.put("email", email);
	       params.put("birth", birth);  

	       return session.selectOne("findId", params); 
	}

	public String findPassword(String id, String email) {
	       Map<String, Object> params = new HashMap<>();
	       params.put("id", id);
	       params.put("email", email);

	       return session.selectOne("findPassword", params); 
	}



}
