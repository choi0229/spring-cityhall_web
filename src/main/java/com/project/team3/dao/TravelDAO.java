package com.project.team3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.team3.vo.Comment;
import com.project.team3.vo.Course;
import com.project.team3.vo.Travel;

@Repository
public class TravelDAO {
	
	@Autowired
	SqlSession session;
	
	public List<Travel> getTravelList() {
		// spot 인 부분만 지도에 표시 1: 스팟, 0: 스팟아님
		int spot = 1;
		return session.selectList("getTravelList",spot);
	}
	
	public List<Course> getCourseListByAttractionId(int id) {
		return session.selectList("getCourseListByAttractionId", id);
	}
	
	public List<Comment> getCommentListById(int id) {
		return session.selectList("getCommentListById",id);
	}
	
	public int createComment(Comment comment) {
		return session.insert("createComment",comment);
	}

	public int updateComment(Comment comment) {
		return session.update("updateComment",comment);
	}
	
	public int deleteComment(int commentId) {
		return session.delete("deleteComment",commentId);
	}
}
