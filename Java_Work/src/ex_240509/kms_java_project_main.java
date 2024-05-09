package ex_240509;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class kms_java_project_main extends JFrame {

	JTextField emailField;
	JTextField passwordField;

	JButton joinBtn;
	JButton signupBtn;

	GridBagLayout gb;

	GridBagConstraints gbc;

	public kms_java_project_main() {
		setTitle("Main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		gb = new GridBagLayout();

		setLayout(gb);

		gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		JLabel emaillabel = new JLabel("이메일");
		emaillabel.setHorizontalAlignment(SwingConstants.CENTER);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		emaillabel.setBorder(border);
		emailField = new JTextField(20);

		gbAdd(emaillabel, 0, 0, 1, 1);
		gbAdd(emailField, 1, 0, 3, 1);

		JLabel passwordlabel = new JLabel("비밀번호");
		passwordlabel.setHorizontalAlignment(SwingConstants.CENTER);
		Border border2 = BorderFactory.createLineBorder(Color.BLACK, 2);
		passwordlabel.setBorder(border2);
		passwordField = new JTextField(20);

		gbAdd(passwordlabel, 0, 1, 1, 1);
		gbAdd(passwordField, 1, 1, 3, 1);

		joinBtn = new JButton("로그인");
		gbAdd(joinBtn, 0, 2, 4, 1);

		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 회원가입 버튼을 클릭했을 때 새로운 회원가입 창을 생성하여 보이도록 설정
				kms_java_project_afterlogin afterloginFrame = new kms_java_project_afterlogin();
				afterloginFrame.setVisible(true);
			}
		});
		
		signupBtn = new JButton("회원가입");
		gbAdd(signupBtn, 0, 3, 4, 1);

		signupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 회원가입 버튼을 클릭했을 때 새로운 회원가입 창을 생성하여 보이도록 설정
				kms_java_project_signUp signUpFrame = new kms_java_project_signUp();
				signUpFrame.setVisible(true);
			}
		});

		setSize(400, 500);
//		setResizable(false);
		setVisible(true);
	}

	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2, 2, 2, 2);
		add(c, gbc);
	}// gbAdd

	 private boolean login(String email, String password) {
	        String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 여기에 사용 중인 Oracle 서버의 호스트 및 포트를 지정해야 합니다.
	        String userid = "scott"; // 여기에 Oracle 데이터베이스 사용자 계정을 입력하세요.
	        String passwd = "tiger"; // 여기에 Oracle 데이터베이스 사용자 계정의 암호를 입력하세요.

	        Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        try {
	            Class.forName(driver);
	            con = DriverManager.getConnection(url, userid, passwd);
	            String query = "SELECT * FROM member_kms WHERE email=? AND password=?";
	            pstmt = con.prepareStatement(query);
	            pstmt.setString(1, email);
	            pstmt.setString(2, password);
	            rs = pstmt.executeQuery();

	            return rs.next(); // 결과가 존재하면 로그인 성공
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (pstmt != null) pstmt.close();
	                if (con != null) con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new kms_java_project_main();
            }
        });
    }
}