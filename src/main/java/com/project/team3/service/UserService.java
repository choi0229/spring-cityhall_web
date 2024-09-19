package com.project.team3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.team3.dao.UserDAO;
import com.project.team3.vo.User;


@Service
public class UserService {

    @Autowired
    UserDAO dao;

    public User getUserById(String userId) {
        return dao.getUserById(userId);  // DAO를 통해 사용자 정보 조회
    }
    
    // ID 중복 체크
    public String isIdAvailable(String userId) {
    	String existingId = dao.checkId(userId);
    	
    	if(userId.equals(existingId)) {
    		return "0";
    	}else {
    		return "1";
    	}
        
    }
}