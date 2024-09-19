package com.project.team3.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.team3.vo.Board;

@Repository
public class BoardDAO {

    @Autowired
       private SqlSession sqlSession; // MyBatis의 SqlSession 주입

       private static final int PAGE_SIZE = 7; // 페이지당 게시글 수
       

       public int getPageSize() {
           return PAGE_SIZE;
       }

       // 공지사항 목록을 DB에서 가져오는 메서드
       public List<Board> getBoardList(int page) {
           int offset = (page - 1) * PAGE_SIZE;
           
           Map<String, Integer> params = new HashMap<>();
           params.put("pageSize", PAGE_SIZE);
           params.put("offset", offset);
           
           return sqlSession.selectList("getBoardList", params);
       }

   public int getTotalBoardCount() {

      return sqlSession.selectOne("getTotalBoardCount");
   }

   public Board getBoard(int id) {
      return sqlSession.selectOne("getBoard", id);

   }

   public int setAddBoard(Board board) {
      return sqlSession.insert("setAddBoard", board);

   }

   public int updateBoard(Board board) {
      return sqlSession.update("updateBoard", board);

   }

   public int deleteBoard(int id) {
      return sqlSession.delete("deleteBoard", id);

   }
   
   public List<Board> getRecentBoards() {
	      return sqlSession.selectList("getRecentBoards");

	   }

}
