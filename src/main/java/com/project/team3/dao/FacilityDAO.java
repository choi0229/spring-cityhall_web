package com.project.team3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.team3.vo.Facility;

@Repository
public class FacilityDAO {
	
	@Autowired
	SqlSession session;

	public List<Facility> getFacilityList() {
		return session.selectList("getFacilityList");
	}
	
	public List<Facility> getFacilityListByType(String facilityType) {
		return session.selectList("getFacilityListByType",facilityType);
	}
}
