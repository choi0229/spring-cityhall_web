package com.project.team3.controller.traffic;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrafficController {

   @RequestMapping(value = {"/traffic.do"})
   public String traffic() {
      return "traffic/traffic_analysis";
   }
}