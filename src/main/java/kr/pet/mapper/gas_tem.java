package kr.pet.mapper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class gas_tem extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    String ppm = request.getParameter("ppm");
	    String a = request.getParameter("a");
	    String tem = request.getParameter("tem");
	    String hum = request.getParameter("hum");
	    
	    System.out.println("ppm: " + ppm);
	    System.out.println("a : " + a);
	    System.out.println("Temperature : " + tem+ "ºC");
	    System.out.println("Humidity : "+hum+ "%");

	    out.print(ppm);
	    out.print(a);
	    out.print(tem);
	    out.print(hum);
		
		
		
	}

}
