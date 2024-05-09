package ex_240509;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBC_Ex_DAO {
	String driver = "oracle.jdbc.driver.OracleDriver"; // 12행 ~ 15행 데이터베이스 접속을 위한 4가지 정보를 String 변수에 저장.
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userid = "scott";
	String passwd = "tiger";

	public JDBC_Ex_DAO() {
		try {
			Class.forName(driver); // 드라이버를 로딩하는 초기화 작업을 생성자에서 구현한다.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<JDBC_Ex_DTO> select() {
		ArrayList<JDBC_Ex_DTO> list = new ArrayList<JDBC_Ex_DTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);
			// DriverManager 클래스의 getConnection() 메소드를
			// 이용해서 Connection 객체를 얻는다.
			String query = "SELECT deptno,dname,loc FROM dept";
			// 요청할 SQL 문을 String 변수에 저장한다.
			pstmt = con.prepareStatement(query);
			// SQL 문 전송에 필요한 PreparedStatement 객체를
			// Connection 객체의 preparedStatement(sql)메소드를 이용해서 얻는다.
			rs = pstmt.executeQuery();
			// SELECT 문을 요청하기 때문에 executeQuery() 메소드를 사용하며
			// 결과는 ResultSet 객체로 받는다.
			while (rs.next()) {
				JDBC_Ex_DTO dto = new JDBC_Ex_DTO();
				// 각각의 레코드 정보를 JDBC_Ex_DTO 클래스의 객체에 저장한다.
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				list.add(dto); // 저장된 JDBC_Ex_DTO 클래스의 객체를 누적시키기 위해서
				// ArrayList 객체 저장한다. while 문이 모두 실행된 후에는 dept 테이블의 모든 레코드가
				// ArrayList 의 객체에 모두 저장된다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}