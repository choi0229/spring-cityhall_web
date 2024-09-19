package com.project.team3.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.project.team3.dao.BoardDAO;
import com.project.team3.vo.Board;
import com.project.team3.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.List;

@Controller
public class BoardController {

   @Autowired
   private BoardDAO boardDAO; // DAO 주입

   @RequestMapping(value = { "/board.do" })
   public String board(HttpServletRequest req, @RequestParam(value = "page", defaultValue = "1") int page,HttpSession session) {
      int totalBoardCount = boardDAO.getTotalBoardCount();
      
       // 현재 페이지에 해당하는 게시글 가져오기
       List<Board> boards = boardDAO.getBoardList(page);
       int pageSize = 7; // 한 페이지에 표시할 게시글 수
       int totalPages = (int) Math.ceil((double) totalBoardCount / pageSize);
       User user = (User)session.getAttribute("userId");
       req.setAttribute("user", user);
       req.setAttribute("boards", boards);
       req.setAttribute("totalBoardCount", totalBoardCount);
       req.setAttribute("currentPage", page);
       req.setAttribute("totalPages", totalPages); 
       req.setAttribute("pageSize", boardDAO.getPageSize()); 

       return "board/board";
   }

   @RequestMapping(value = { "/boardcontent.do" })
   public String board_content(HttpServletRequest req, int id, HttpSession session) {
      // DB에서 공지사항 데이터를 가져와서 모델에 추가
      Board board = boardDAO.getBoard(id);
      req.setAttribute("board", board);
      User user = (User)session.getAttribute("userId");
      req.setAttribute("user",user);
      return "board/boardcontent";
   }

   @RequestMapping("/boardadd.do")
   public String registerBoard(HttpServletRequest req, HttpSession session, String boardTitle, String boardContent) {
      User user = (User) session.getAttribute("userId");
      Board board = new Board(boardTitle, user.userId, boardContent);
      boardDAO.setAddBoard(board);
      return "redirect:/board.do";
   }

   @RequestMapping("/boardaddform.do")
   public String addBoard(HttpServletRequest req) {

      return "board/boardadd";
   }


   



}
