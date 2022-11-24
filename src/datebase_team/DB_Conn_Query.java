package datebase_team;

import java.sql.*;
import java.util.*;

import DTO.shelt_dog;
import doglist.DB_Conn_Query;
import DTO.missing;
import DTO.adopt;

import java.sql.Date;
import java.text.*;

public class DB_Conn_Query {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;

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
    
    
    //유기견 테이블 목록 출력 (select - preparedstatment)
    public ArrayList<shelt_dog> read_shelt_dog() {
		ArrayList<shelt_dog> arr = new ArrayList<shelt_dog>();
        System.out.println(arr);
        try {
        	DB_Connect();
        	String sql = "select * from 유기견";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                arr.add(new shelt_dog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                		rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10))); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
	}
    
    
    //신고 기록 테이블 목록 출력 (select - preparedstatment)
    public ArrayList<missing> read_missing() {
		ArrayList<missing> arr = new ArrayList<missing>();
        System.out.println(arr);
        try {
        	DB_Connect();
        	String sql = "select * from 신고기록";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                arr.add(new missing(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                		rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9))); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
	}
    
    
    
    
    
    ////////////////////////수정 중 실행 x
    //입양 신청 목록 출력 (select - statement + where 조)
    public static ArrayList<adopt> read_adopt() {
		ArrayList<adopt> arr = new ArrayList<adopt>();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("입양 신청 목록을 알고 싶은 달을 입력하시오 : ");
		String month = scan.nextLine();
        System.out.println(arr);
        try {
        	DB_Connect();
        	String sql = "select * from 입양신청 where 입양신청일자 =" + month;
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                arr.add(new adopt(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                		rs.getString(6), rs.getString(7))); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
	}
    
    
    

    
   
    ///////////////////////////////////////////////
    
    
    

    public ArrayList<adopt> read_adopt2() {
		//사용자로부터 값을 입력 받기위함

		ArrayList<adopt> arr = new ArrayList<adopt>();
		//db작업을 위해 필요한 것들
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		//미리 입력받기
    	Scanner scan = new Scanner(System.in);

		String month1 = scan.nextLine();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 00일");
		java.util.Date date = formatter.parse(month1);
		
		try {
	        try {
	        	
	        	String url = "jdbc:oracle:thin:@localhost:1521:XE"; String id = "dog"; String password = "1234";
	            conn = DriverManager.getConnection(url, id, password);
	            System.out.println("DB 연결 성공");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
        	String sql = "select * from 입양신청 where 입양신청일자=" + date;
            Statement stmt1 = conn.createStatement();
            rs = stmt1.executeQuery(sql);
            while (rs.next()) {
                arr.add(new adopt(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                		rs.getString(6), rs.getString(7))); 
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납 : 만들어진 순서의 역순으로 진행
			if(rs != null) try {rs.close();} catch (SQLException e2) {}
			if(stmt != null) try {stmt.close();} catch (SQLException e2) {}
			if(conn != null) try {conn.close();} catch (SQLException e2) {}
	  }
		return arr;
    }
    public static void main(String arg[]) throws SQLException, ParseException{
    	DB_Conn_Query dbconquery = new DB_Conn_Query();
    	DB_Conn_Query.read_adopt();
    }
}