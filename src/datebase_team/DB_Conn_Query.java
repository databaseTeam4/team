package datebase_team;

import java.sql.*;
import java.util.*;

import DTO.shelt_dog;
import DTO.missing;
import DTO.adopt;

import java.sql.Date;
import java.text.*;

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
    
    
    


    //입양 신청 목록 출력 (select - statement + where 조건)
    // 1. 해당 말일 구하는 함수
    public Date lastday(String date) {
    	DB_Connect();
    	Statement stmt = null;
    	Date date1 = null;
    	try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("Select last_day('"+date+"') from dual"); //해당 월 막날 sql문 
            while(rs.next()){
            	date1 = rs.getDate(1);
            }
    	}catch (SQLException e) {
			e.printStackTrace();
    	}finally {
            try {
                stmt.close();
                conn.close();               
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
		return date1;
    }
    

    // 2.입양목록 출력
    public ArrayList<adopt> read_adopt() throws ParseException, SQLException {
		ArrayList<adopt> arr = new ArrayList<adopt>();
		Statement stmt2 = null;
		
		//사용자로부터 입력받기
    	Scanner scan = new Scanner(System.in);
		System.out.println("입양 신청 목록을 알고 싶은 년도와 달을 입력하시오(ex. 2020/10) : ");
		String date = scan.nextLine();

		date = date +"/01";  //2020/10/01 - 해당 년도, 달의 첫 날
        Date sql2 = lastday(date);  //해당 년도, 달의 막 날 
    
		try {
	        DB_Connect();
	        
	        //해당 한 달 내 입양신청 목록 sql문->Select * from 입양신청 where 입양신청일자 between TO_DATE('2022/11/01','YYYY/MM/DD') And TO_DATE('2022/11/30','YYYY/MM/DD');
        	String sql1 = "Select * from 입양신청 where 입양신청일자 between TO_DATE('"+date+"','YYYY/MM/DD') And TO_DATE('"+sql2+"','YYYY-MM-DD')";
            stmt2 = conn.createStatement();
            rs = stmt2.executeQuery(sql1);
            while (rs.next()) {
            	//출력 확인용 코드 
            	//System.out.print(rs.getString("입양신청번호")+"\t"+rs.getDate("입양신청일자")+ "\t"+rs.getString("입양유기견이름")+"\t"+rs.getString("입양유기견품종")+"\t"+
            			//rs.getString("입양유기견성별")+"\t"+rs.getString("보호기관번호")+"\t"+rs.getString("회원아이디")+"\n");
            	           	
                arr.add(new adopt(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                		rs.getString(6), rs.getString(7))); 
            }	

    		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            try {
                stmt2.close();
                conn.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return arr;
    }
}