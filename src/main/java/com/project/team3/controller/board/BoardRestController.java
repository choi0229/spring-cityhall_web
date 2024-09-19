package com.project.team3.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.team3.dao.BoardDAO;
import com.project.team3.vo.Board;
import com.project.team3.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.List;

@RestController
public class BoardRestController {

   @Autowired
   private BoardDAO boardDAO; // DAO 주입

   
      @RequestMapping(value = "/boardcontent/{boardId}", produces = "application/json")
      public int setById(@RequestParam("boardId") int boardId, @RequestParam("boardTitle") String boardTitle,  @RequestParam("boardContent") String boardContent) {
         
         Board board = new Board(boardId, boardTitle, boardContent);
         
         return boardDAO.updateBoard(board);
      } 
      
      @RequestMapping(value = "/boardcontentdel/{boardId}", produces = "application/json")
      public int delById(@PathVariable int boardId) {

         return boardDAO.deleteBoard(boardId);
      } 


}
