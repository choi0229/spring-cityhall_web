package com.project.team3.vo;

import java.util.Arrays;
import java.util.List;


public class Board {

   public Board(int boardId) {
      super();
      this.boardId = boardId;
   }

   public int boardId;
    private String boardRegistrationDate;
    private String boardTitle;
    private String boardWriter;
    private String boardContent;
   

    public Board(int boardId, String boardTitle, String boardContent) {
      super();
      this.boardId = boardId;
      this.boardTitle = boardTitle;
      this.boardContent = boardContent;
   }
    
    public Board(int boardId, String boardRegistrationDate, String boardTitle, String boardWriter,
         String boardContent) {
      super();
      this.boardId = boardId;
      this.boardRegistrationDate = boardRegistrationDate;
      this.boardTitle = boardTitle;
      this.boardWriter = boardWriter;
      this.boardContent = boardContent;
   }
    
    public Board(String boardTitle, String boardWriter, String boardContent) {
       
      this.boardTitle = boardTitle;
      this.boardWriter = boardWriter;
      this.boardContent = boardContent;
   }
    
    

   public int getBoardId() {
      return boardId;
   }

   public void setBoardId(int boardId) {
      this.boardId = boardId;
   }

   public Board() {
        super();
    }

    public String getBoardRegistrationDate() {
        return boardRegistrationDate;
    }

    public void setBoardRegistrationDate(String boardRegistrationDate) {
        this.boardRegistrationDate = boardRegistrationDate;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    @Override
   public String toString() {
      return "Board [boardId=" + boardId + ", boardRegistrationDate=" + boardRegistrationDate + ", boardTitle="
            + boardTitle + ", boardWriter=" + boardWriter + ", boardContent=" + boardContent + "]";
   }
}
