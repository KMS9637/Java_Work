package ex_240509;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberSelectDAO {
    public String selectMember() {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String userid = "scott";
        String passwd = "tiger";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            String query = "SELECT id,name,email FROM member_kms";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                
                String name = rs.getString("name");
                String email = rs.getString("email");
                
                result.append("이메일: ").append(email).append(", 닉네임: ").append(name).append("\n");
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

        return result.toString();
    }
}
