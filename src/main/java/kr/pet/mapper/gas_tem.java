package kr.pet.mapper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.pet.web.petCageController;


public class gas_tem extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    String cg_serial = request.getParameter("cg_serial");
	    String ppm = request.getParameter("ppm");
	    String isgas = request.getParameter("isgas");
	    String tem = request.getParameter("tem");
	    String hum = request.getParameter("hum");
	    String angle = "";
	    String motor = petCageController.control;
	    String feed = petCageController.feed;
	    
	    System.out.println("cg_serial: " + cg_serial);
	    System.out.println("ppm: " + ppm);
	    System.out.println("isgas : " + isgas);
	    System.out.println("Temperature : " + tem+ "ºC");
	    System.out.println("Humidity : "+hum+ "%");
		
	    CageInfoVO dto = new CageInfoVO(cg_serial, ppm, tem, hum, angle, motor, isgas);
	    dataDAO dao = new dataDAO();
	   
	    
	    dao.dbconn();
		dao.insertData(dto);
		dao.dbclose();
	    
	      System.out.println(motor);
	      
	      if(motor.equals("ON") && feed.equals("ON")) {
	    	  out.print("{\"SELECT\":\"ON\",\"FEED\":\"ON\"}"); //메모장 복붙시 "앞에 자동으로 \넣어줌
	    	  petCageController.feed = "OFF";
	      }else if(motor.equals("ON") && feed.equals("OFF")) {
	    	  out.print("{\"SELECT\":\"ON\",\"FEED\":\"OFF\"}"); //메모장 복붙시 "앞에 자동으로 \넣어줌
	      }else if(motor.equals("OFF") && feed.equals("ON")) {
	    	  out.print("{\"SELECT\":\"OFF\",\"FEED\":\"ON\"}"); //메모장 복붙시 "앞에 자동으로 \넣어줌
	    	  petCageController.feed = "OFF";
	      }else if(motor.equals("OFF") && feed.equals("OFF")) {
	    	  out.print("{\"SELECT\":\"OFF\",\"FEED\":\"OFF\"}"); //메모장 복붙시 "앞에 자동으로 \넣어줌
	      }
			
	      
	      System.out.println(feed);
	      
	    
		
		
	}

}
