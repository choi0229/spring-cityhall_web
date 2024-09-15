package com.project.team3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		String status = session.selectOne("checkId",id);
		String result ="9";
		System.out.println(status);
		// 사용가능한 아이디
		if(status==null) {
			result="1";
		}else {
			result="0";
		}
		return result;
		
	}

	public int createUser(User user) {
		return session.insert("createUser",user);
		
	}

//	// nickName을 가지고 User 객체를 리턴받는다.
//	public static User getUserByNickName(String nickName) throws Exception {
//		
//		Connection con = null;
//		
//		try {
//			con = DBUtil.getConnection();
//			Statement stmt = con.createStatement();
//			String sql = "select * from user where user_nickname = '" + nickName + "'";
//			ResultSet rs = stmt.executeQuery(sql);
//			User user = null;
//			if (rs.next()) {
//				String userId = rs.getString("user_id");
//				String userPw = rs.getString("user_pw");
//				String userName = rs.getString("user_name");
//				String userNickname = rs.getString("user_nickname");
//				String userEmail = rs.getString("user_email");
//				user = new User(userId, userPw, userName, userNickname, userEmail);
//			}
//			return user;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			if (con != null) {
//               try {
//                   con.close();
//               } catch (Exception e) {
//                   // 예외 처리
//                   e.printStackTrace();
//               }
//           }  
//		}
//
//	}

}
