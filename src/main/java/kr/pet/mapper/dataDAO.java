package kr.pet.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dataDAO {
	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	int cnt = 0;
	
	
	// DB연결 메소드
		public void dbconn() {
			try {
				
				Class.forName("com.mysql.jdbc.Driver");

				String url = "jdbc:mysql://project-db-stu.ddns.net:3307/pet";
				String dbid = "pet";
				String dbpw = "1234";
				conn = DriverManager.getConnection(url, dbid, dbpw);
				System.out.println("db연결 성공");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("db연결 실패");
			}
		}
		
	// DB연결 해제 메소드
		public void dbclose() {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
				System.out.println("db해제 성공");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("db해제 실패");
			}
		}
	
	// DB 데이터 삽입 메소드
		public void insertData(CageInfoVO vo) {
			
			String sql = "INSERT INTO tbl_cageinfo\n"
					+ "    (cg_serial,\n"
					+ "    cg_gas, \n"
					+ "    cg_temp, \n"
					+ "    cg_hum, \n"
					+ "    cg_angle, \n"
					+ "    cg_motor, \n"
					+ "    cg_time) \n"
					+ "VALUES\n"
					+ "    (?,\n"
					+ "		?, \n"
					+ "		?, \n"
					+ "		?, \n"
					+ "		1, \n"
					+ "    ?, \n"
					+ "    sysdate()) \n";

			
			try {
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, vo.getCg_serial());
				psmt.setString(2, vo.getCg_gas());
				psmt.setString(3, vo.getCg_temp());
				psmt.setString(4, vo.getCg_hum());
				psmt.setString(5, vo.getCg_motor());

				
				psmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
}
