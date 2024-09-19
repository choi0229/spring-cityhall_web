package com.project.team3.controller.facility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.team3.dao.FacilityDAO;
import com.project.team3.vo.Facility;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class FacilityRestController {

	@Autowired
	FacilityDAO dao;
	
	@RequestMapping(value = "/facilities.do", produces = "application/json")
	public List<Facility> getfacilities(HttpServletRequest req,@RequestParam("facilityType") String type) {
		List<Facility> facility = new ArrayList<Facility>();
		if(!type.equals("all")) {
			facility = dao.getFacilityListByType(type);
		}else {
			facility = dao.getFacilityList();
		}
		return facility;
	}
}
