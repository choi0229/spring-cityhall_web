package com.project.team3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.team3.vo.Reservation;

@Repository
public class ReservationDAO {

	@Autowired
	SqlSession session;
	
	public List<Reservation> getRsvList(int facilityId, String reservationDate) {
		Reservation reservation = new Reservation(facilityId, reservationDate);
		
		return session.selectList("getRsvList",reservation);
	}
	
	public int createRsv(Reservation reservation) {
		return session.insert("createRsv", reservation);
	}
	
	 public int checkOverlap(Reservation reservation) {
	    return session.selectOne("checkOverlap", reservation);
	 }
	 
	 public int updateRsv(Reservation reservation) {
		 return session.update("updateRsv", reservation);
	 }
	 
	 public int deleteRsv(String reservationId) {
		 return session.delete("deleteRsv", reservationId);
	 }
}
