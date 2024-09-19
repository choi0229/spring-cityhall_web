package com.project.team3.controller.travel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.team3.dao.TravelDAO;
import com.project.team3.vo.Comment;
import com.project.team3.vo.Course;
import com.project.team3.vo.User;

import jakarta.servlet.http.HttpSession;

@RestController
public class TravelRestController {
	
	@Autowired
	TravelDAO dao;

    @GetMapping(value = "/travel.do", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resource> getSeoulMap() {
        // GeoJSON 파일을 불러옴
        Resource resource = new ClassPathResource("static/map/seoulmap.geojson");

        // 파일이 존재하고 읽을 수 있는지 확인
        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"seoulmap.geojson\"")
                .body(resource);
        } else {
            // 파일이 없으면 404 반환
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @GetMapping(value = "/courselist.do")
    public List<Course> getCourseListByAttractionId(@RequestParam("id") int id) {
        return dao.getCourseListByAttractionId(id); // DAO에서 데이터를 받아와 반환
    }
    
    @GetMapping(value = "/comment.do")
    public List<Comment> getCommentListById(@RequestParam("courseId") int id) {
        return dao.getCommentListById(id); // DAO에서 데이터를 받아와 반환
    }

    @GetMapping(value = "/commentAdd.do")
    public int createComment(@RequestParam("courseId") int courseId,@RequestParam("rating") double rating, String details, HttpSession session) {
    	User user = (User)session.getAttribute("userId");
    	Comment comment = new Comment(details, user.userId, courseId, rating);
        return dao.createComment(comment); // DAO에서 데이터를 받아와 반환
    }
    
    @GetMapping(value = "/updateComment.do")
    public int updateComment(@RequestParam("commentId") int commentId, String details) {
    	Comment comment = new Comment(details, commentId);
        return dao.updateComment(comment); // DAO에서 데이터를 받아와 반환
    }
    
    @GetMapping(value = "/deleteComment.do")
    public int deleteComment(@RequestParam("commentId") int commentId) {
        return dao.deleteComment(commentId); // DAO에서 데이터를 받아와 반환
    } 
    
}
