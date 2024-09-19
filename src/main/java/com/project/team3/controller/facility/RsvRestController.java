package com.project.team3.controller.facility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.team3.dao.ReservationDAO;
import com.project.team3.vo.Reservation;
import com.project.team3.vo.User;

import jakarta.servlet.http.HttpSession;

@RestController
public class RsvRestController {

	@Autowired
	ReservationDAO dao;

	@RequestMapping(value = "/rsvList.do", produces = "application/json")
	public List<Reservation> getRsvList(@RequestParam("facilityId") int facilityId,@RequestParam("reservationDate") String reservationDate ) {
		List<Reservation> reservation = dao.getRsvList(facilityId,reservationDate);
		
		return reservation;
	}
	
	@RequestMapping(value = "/createRsv.do", produces = "application/json")
	public int createRsv(@RequestParam("reservationName") String reservationName
			,@RequestParam("reservationDate") String reservationDate
			,@RequestParam("startTime") String startHour
			,@RequestParam("endTime") String endHour
			,@RequestParam("participants") String participants
			,@RequestParam("facilityId") int facilityId
			,HttpSession session) {
		User user = (User)session.getAttribute("userId");
		// System.out.println(facilityId);
		Reservation reservation = new Reservation(reservationName,reservationDate,startHour,endHour,participants,facilityId, user.userId);
		return dao.createRsv(reservation);
	}
	
	
		// 예약 생성 전에 중복 확인
    @RequestMapping(value = "/checkOverlap.do", produces = "application/json")
    public Map<String, Boolean> checkOverlap(
            @RequestParam("reservationDate") String reservationDate,
            @RequestParam("startTime") String startHour,
            @RequestParam("endTime") String endHour,
            @RequestParam("facilityId") int facilityId) {

        Reservation reservation = new Reservation();
        reservation.setFacilityId(facilityId);
        reservation.setReservationDate(reservationDate);
        reservation.setStartHour(startHour);
        reservation.setEndHour(endHour);

        int overlapCount = dao.checkOverlap(reservation);

        Map<String, Boolean> response = new HashMap<>();
        response.put("isOverlap", overlapCount > 0); // 겹치는 시간이 있으면 true
        return response;
    }
    
    @RequestMapping(value = "/updateRsv.do", produces = "application/json")
	public int updateRsv(@RequestParam("reservationId") String reservationId
			,@RequestParam("reservationName") String reservationName
			,@RequestParam("reservationDate") String reservationDate
			,@RequestParam("startTime") String startHour
			,@RequestParam("endTime") String endHour
			,@RequestParam("participants") String participants
			,@RequestParam("facilityId") int facilityId
			,HttpSession session) {
    	System.out.println(reservationId+"실행");
		User user = (User)session.getAttribute("userId");
		Reservation reservation = new Reservation(reservationId,reservationName,reservationDate,startHour,endHour,participants,facilityId, user.userId);
		return dao.updateRsv(reservation);
	}
    
    @RequestMapping(value = "/deleteRsv.do", produces = "application/json")
	public int deleteRsv(@RequestParam("reservationId") String reservationId) {
    	
		return dao.deleteRsv(reservationId);
	}
    
    
}
