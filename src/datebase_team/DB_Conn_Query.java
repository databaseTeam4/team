package datebase_team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DB_Conn_Query {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    String url = "jdbc:oracle:thin:@localhost:1521:XE"; String id = "dog"; String password = "1234";

////드라이브 적재
    public DB_Conn_Query() {
    	try { Class.forName("oracle.jdbc.driver.OracleDriver");
    		System.out.println("드라이버 적재 성공");   		
    	} catch(ClassNotFoundException e) {System.out.println("No Driver");}
    }
    
/////DB 연결 
    private void DB_Connect() {
        try {
            conn = DriverManager.getConnection(url, id, password);
            System.out.println("DB 연결 성공");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    //유기견 테이블 목록 출력 
    private void shelt_dog() throws SQLException {
		String sql = "select * from 유기견";
    	try {
    		DB_Connect();

    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		ResultSet rs = pstmt.executeQuery();

    		while(rs.next()) {
    			System.out.println(rs.getInt("유기견번호")+"\t"+rs.getString("유기견이름")+"\t"+rs.getString("유기견품종")+"\t"
    				+ rs.getString("성별") + "\t"+ rs.getString("나이") + "\t"+ rs.getString("몸무게") + "\t"
    				+ rs.getString("구조일자") + "\t"+ rs.getString("발견장소") + "\t"+ rs.getString("보호등록번호") + "\t"
    				+ rs.getString("보호기관번호") + "\t" + "\n");	
    		}
    		rs.close(); pstmt.close();
    	}catch(SQLException e) {e.printStackTrace();
    	}finally {conn.close();}
    }
    
    
    
    //신고 기록 테이블 목록 출력 (select)
    private void missing() throws SQLException {
		String sql = "select * from 신고기록";
    	try {
    		DB_Connect();

    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		ResultSet rs = pstmt.executeQuery();

    		while(rs.next()) {
    			System.out.println(rs.getString("동물등록번호")+"\t"+rs.getString("반려견이름")+"\t"+rs.getString("반려견품종")+"\t"
    				+ rs.getString("성별") + "\t"+ rs.getString("특이사항") + "\t"+ rs.getString("실종장소") + "\t"
    				+ rs.getString("실종된시간") + "\t"+ rs.getString("실종된날짜") + "\t"+ rs.getString("회원아이디") + "\n");	
    		}
    		rs.close(); pstmt.close();	  		
    	}catch(SQLException e) {e.printStackTrace();
    	}finally {  conn.close();}
    }
    
    //입양 신청 목록 출력 (select)
    private void adopt() throws SQLException {
		String sql = "select * from 입양신청";
    	try {
    		DB_Connect();

    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		ResultSet rs = pstmt.executeQuery();

    		while(rs.next()) {
    			System.out.println(rs.getString("입양신청번호")+"\t"+rs.getDate("입양신청일자")+"\t"+rs.getString("입양유기견이름")+"\t"
    				+ rs.getString("입양유기견품종") + "\t"+ rs.getString("입양유기견성별") + "\t"+ rs.getString("보호기관번호") + "\t"
    				+ rs.getString("회원아이디") + "\n");	
    		}
    		rs.close(); pstmt.close();    	  		
    	}catch(SQLException e) {e.printStackTrace();
    	}finally { conn.close();}
    }
    
    
    public static void main(String arg[]) throws SQLException{
    	DB_Conn_Query dbconquery = new DB_Conn_Query();
    	dbconquery.shelt_dog();
    	dbconquery.missing();
    	dbconquery.adopt();
    }
}