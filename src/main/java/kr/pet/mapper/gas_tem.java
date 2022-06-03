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
	    String a = request.getParameter("a");
	    String tem = request.getParameter("tem");
	    String hum = request.getParameter("hum");
	    String angle = "";
	    
	    System.out.println("cg_serial: " + cg_serial);
	    System.out.println("ppm: " + ppm);
	    System.out.println("a : " + a);
	    System.out.println("Temperature : " + tem+ "ºC");
	    System.out.println("Humidity : "+hum+ "%");
		
	    CageInfoVO dto = new CageInfoVO(cg_serial, ppm, tem, hum, angle);
	    dataDAO dao = new dataDAO();
	   
	    
	    dao.dbconn();
		dao.insertData(dto);
		dao.dbclose();
	    
		String select = petCageController.control;
	      System.out.println(select);
	      if(select.equals("ON")) {
				out.print("{\"SELECT\":\"ON\"}"); //메모장 복붙시 "앞에 자동으로 \넣어줌
				
			}else if(select.equals("OFF")) {
				out.print("{\"SELECT\":\"OFF\"}");
			}
	    
		
		
	}

}
