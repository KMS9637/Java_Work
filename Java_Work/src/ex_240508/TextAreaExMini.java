package ex_240508;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaExMini extends JFrame {
	
	private JTextArea ta = new JTextArea(7, 20);
	
	// 인스턴스 멤버로 선언만하고, 아래에서 할당했음. 
	// 각 메서드 안에서도 이용이 가능해요, -> 이 클래스 내부에 전역처럼 이용됨. 
	JTextField nameField;
	JTextField emailField;
	JTextField passwordField;
	JTextField idField;
	
	JButton joinBtn;
	JButton clearBtn;
	JButton updateBtn;
	JButton deleteBtn;
	
	// 행과 열을 테이블 형식으로 배치 관리자. 
	GridBagLayout gb;
	// Constraints , 제약 조건, 행, 열의 위치, 크기, 여백, 가득채우기 등. 옵션을 지정 가능. 
	GridBagConstraints gbc;

	public TextAreaExMini() {
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
//		c.setLayout(new FlowLayout());
		// GridBagLayout, 인스턴스 생성. 
		gb = new GridBagLayout();
		// 패널에 붙이기 
		setLayout(gb);
		// GridBagConstraints, 옵션을 추가하는 도구. 
		gbc = new GridBagConstraints();
		
		// 가로, 세로의 빈공간을 가득 채우겠다. 
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

//		c.setLayout(new GridLayout(4, 2));

		JLabel name = new JLabel("이름 ");
		nameField = new JTextField(20);
		// gbAdd : 메서드 (배치할 요소(버튼,라벨),x(열), y(행), w(가로폭),h(세로높이))
		gbAdd(name, 0, 0, 1, 1);
		gbAdd(nameField, 1, 0, 3, 1);

		JLabel email = new JLabel("이메일 ");
		emailField = new JTextField(20);
		gbAdd(email, 0, 1, 1, 1);
		gbAdd(emailField, 1, 1, 3, 1);
//
		JLabel password = new JLabel("패스워드 ");
		passwordField = new JTextField(20);
		gbAdd(password, 0, 2, 1, 1);
		gbAdd(passwordField, 1, 2, 3, 1);
//		
		JLabel id = new JLabel("아이디 ");
		idField = new JTextField(20);
		gbAdd(id, 0, 3, 1, 1);
		gbAdd(idField, 1, 3, 3, 1);
		
		joinBtn = new JButton("회원가입");
		gbAdd(joinBtn, 0, 4, 4, 1);
		
		clearBtn = new JButton("조회");
		gbAdd(clearBtn, 0, 5, 4, 1);
		
		updateBtn = new JButton("수정");
		gbAdd(updateBtn, 0, 6, 4, 1);
				
		deleteBtn = new JButton("삭제");
		gbAdd(deleteBtn, 0, 7, 4, 1);
		
		JLabel resultLabel = new JLabel("결과뷰");
		gbAdd(resultLabel, 0, 8, 4, 1);
		
		JScrollPane resultJScrollPane = new JScrollPane(ta);
		gbAdd(resultJScrollPane, 0, 9, 4, 1);
		
		// 이벤트 처리기. 방식, 익명클래스로 이용.
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == joinBtn) {
					String name = nameField.getText();
					String email = emailField.getText();
					String password = passwordField.getText();
					String id = idField.getText();
					//1차 라벨에 붙이기
//					resultLabel.setText("이름: " + name + ", 이메일 : " + email + ", 패스워드 : " + password + ", 패스워드 확인 : " + passwordConfirm);
					//2차 텍스트 area 에 붙이기
//					StringBuffer sb = new StringBuffer();
					String result = "이름: " + name + ", 이메일 : " + email + ", 패스워드 : " + password; 
//					sb.append(result);
//					ta.append(result);
					insertMember(name, email, password);
					resultLabel.setText("회원가입 완료");
				} 			
			}
		});
		
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == clearBtn) {
					selectMember();
				}
			
			}
		});
		
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == updateBtn) {
					String name = nameField.getText();
					String email = emailField.getText();
					String password = passwordField.getText();
					String id = idField.getText();
					//1차 라벨에 붙이기
//					resultLabel.setText("이름: " + name + ", 이메일 : " + email + ", 패스워드 : " + password + ", 패스워드 확인 : " + passwordConfirm);
					//2차 텍스트 area 에 붙이기
//					StringBuffer sb = new StringBuffer();
//					String result = "이름: " + name + ", 이메일 : " + email + ", 패스워드 : " + password + ", 패스워드 확인 : " + passwordConfirm; 
//					sb.append(result);
//					ta.append(result);
					updateMember(name, email, password, id);
					resultLabel.setText("수정완료");
				} 			
			}
		});
		
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == deleteBtn) {
					//String name = nameField.getText();
					//String email = emailField.getText();
					//String password = passwordField.getText();
					String id = idField.getText();
					//1차 라벨에 붙이기
//					resultLabel.setText("이름: " + name + ", 이메일 : " + email + ", 패스워드 : " + password + ", 패스워드 확인 : " + passwordConfirm);
					//2차 텍스트 area 에 붙이기
//					StringBuffer sb = new StringBuffer();
//					String result = "이름: " + name + ", 이메일 : " + email + ", 패스워드 : " + password + ", 패스워드 확인 : " + passwordConfirm; 
//					sb.append(result);
//					ta.append(result);
					deleteMember(id);
					resultLabel.setText("삭제완료");
				} 			
			}
		});
		
		setSize(400, 500);
//		setResizable(false);
		setVisible(true);
	}

	// 그리드백레이아웃에 붙이는 메소드
	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2, 2, 2, 2);
		add(c, gbc);
	}// gbAdd

	private void insertMember(String name, String email, String password) {
		String driver = "oracle.jdbc.driver.OracleDriver"; // 12행 ~ 15행 데이터베이스 접속을 위한 4가지 정보를 String 변수에 저장.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "scott";
		String passwd = "tiger";
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			// 명시된 드라이버 클래스를 메모리에 로딩한다.
			con = DriverManager.getConnection(url, userid, passwd);
			// DriverManager 클래스의 getConnection() 메소드를 이용해서
//			 Connection 객체를 얻는다. 
			String sql = "INSERT INTO member501(name,email,password)" + "VALUES(?,?,?)";
			// 요청할 SQL 문을 String 변수에 저장한다. 이때 저장할 데이터 대신에 '?'
			// 기호를 사용한다. 나중에 PreparedStatement 객체의 set()메소드를
			// 사용하여 값을 동적으로 설정한다.
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			// SQL 문 전송에 필요한 PreparedStatement 객체를
			// Connection 객체의 preparedStatement(sql)메소드를 이용해서 얻고 '?' 대신에
			// 설정할 값을 인덱스(1부터 시작) 를 사용하여 set() 메소드로 설정한다.
			int n = pstmt.executeUpdate();
			// INSERT 문을 요청하기 때문에 executeUpdate() 메소드를
			// 사용하며 결과는 int 형으로 저장한다.
			System.out.println(n + "개의 레코드가 저장");
			// 반환된 정수값을 출력하면 SQL 문을 실행한 뒤에 데이터베이스에 적용된
			// 레코드의 개수를 알수 있다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
				// 사용한 자원을 finally 문을 이용해서 반납한다.
				// 자원 반납은 사용했던 객체의 역순으로 하며 모두 공통적으로
				// close() 메소드를 사용한다.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	private void selectMember() {
		// 연결을 위한 준비물. 맨날 쓰는 것
				String driver = "oracle.jdbc.driver.OracleDriver"; // 12행 ~ 15행 데이터베이스 접속을 위한 4가지 정보를 String 변수에 저장.
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String userid = "scott";
				String passwd = "tiger";
				
				// 준비물. 연결 위한 도구들
				// 연결 및 
				Connection con = null;
				// sql 전달
				PreparedStatement pstmt = null;
				// 결과 테이블 받을 준비물
				ResultSet rs = null;
				
				try {
					// 해당 드라이버 경로의 class 파일을 불러오기.
					Class.forName(driver);
					// 명시된 드라이버 클래스를 메모리에 로딩한다.
					// 연결 위한 도구
					con = DriverManager.getConnection(url, userid, passwd);
					// DriverManager 클래스의 getConnection() 메소드를 이용해서
//					 Connection 객체를 얻는다.
					// db 서버에 뭘 할지 요청, DML(CRUD, create(insert),read(select),update,delete)
					String query = "SELECT id,name,email,password FROM member501";
					// 요청할 SQL 문을 String 변수에 저장한다.
					pstmt = con.prepareStatement(query);
					// SQL 문 전송에 필요한 PreparedStatement 객체를
					// Connection 객체의 preparedStatement(sql)메소드를 이용해서 얻는다.

					rs = pstmt.executeQuery();
					// SELECT 문을 요청하기 때문에 executeQuery()
//					 메소드를 사용하며 결과는 ResultSet 객체로 받는다.
					StringBuilder result = new StringBuilder();
					while (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String email = rs.getString("email");
						String password = rs.getString("password");
						System.out.println(name + " " + email + " " + password);
						result.append("아이디: ").append(id).append(", 이름: ").append(name).append(", 이메일: ").append(email).append(", 패스워드: ").append(password).append("\n");
					}
					ta.setText(result.toString());
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
	}
	private void updateMember(String name, String email, String password, String id) {
		String driver = "oracle.jdbc.driver.OracleDriver"; // 12행 ~ 15행 데이터베이스 접속을 위한 4가지 정보를 String 변수에 저장.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "scott";
		String passwd = "tiger";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			// 명시된 드라이버 클래스를 메모리에 로딩한다.
			con = DriverManager.getConnection(url, userid, passwd);
			// DriverManager 클래스의 getConnection() 메소드를 이용해서
//			 Connection 객체를 얻는다. 
			String sql = "UPDATE member501 SET name = ? , email = ?, password = ? WHERE id = ?";
			// 요청할 SQL 문을 String 변수에 저장한다. 이때 저장할 데이터 대신에 '?'
			// 기호를 사용한다. 나중에 PreparedStatement 객체의 set()메소드를
			// 사용하여 값을 동적으로 설정한다.
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setString(4, id);
			// SQL 문 전송에 필요한 PreparedStatement 객체를
			// Connection 객체의 preparedStatement(sql)메소드를 이용해서 얻고 '?' 대신에
			// 설정할 값을 인덱스(1부터 시작) 를 사용하여 set() 메소드로 설정한다.
			int n = pstmt.executeUpdate();
			// UPDATE 문을 요청하기 때문에 executeUpdate() 메소드를
			// 사용하며 결과는 int 형으로 저장한다.
			System.out.println(n + "개의 레코드가 수정");
			// 반환된 정수값을 출력하면 SQL 문을 실행한 뒤에 데이터베이스에 적용된
			// 레코드의 개수를 알수 있다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
				// 사용한 자원을 finally 문을 이용해서 반납한다.
				// 자원 반납은 사용했던 객체의 역순으로 하며 모두 공통적으로
				// close() 메소드를 사용한다.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void deleteMember(String id) {
		String driver = "oracle.jdbc.driver.OracleDriver"; // 12행 ~ 15행 데이터베이스 접속을 위한 4가지 정보를 String 변수에 저장.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "scott";
		String passwd = "tiger";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			// 명시된 드라이버 클래스를 메모리에 로딩한다.
			con = DriverManager.getConnection(url, userid, passwd);
			// DriverManager 클래스의 getConnection() 메소드를 이용해서
//			 Connection 객체를 얻는다. 
			String sql = "DELETE FROM member501 WHERE id = ?";
			// 요청할 SQL 문을 String 변수에 저장한다. 이때 저장할 데이터 대신에 '?'
			// 기호를 사용한다. 나중에 PreparedStatement 객체의 set()메소드를
			// 사용하여 값을 동적으로 설정한다.
			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1, name);
			//pstmt.setString(2, email);
			//pstmt.setString(3, password);
			pstmt.setString(1, id);
			// SQL 문 전송에 필요한 PreparedStatement 객체를
			// Connection 객체의 preparedStatement(sql)메소드를 이용해서 얻고 '?' 대신에
			// 설정할 값을 인덱스(1부터 시작) 를 사용하여 set() 메소드로 설정한다.
			int n = pstmt.executeUpdate();
			// UPDATE 문을 요청하기 때문에 executeUpdate() 메소드를
			// 사용하며 결과는 int 형으로 저장한다.
			System.out.println("삭제 완료");
			// 반환된 정수값을 출력하면 SQL 문을 실행한 뒤에 데이터베이스에 적용된
			// 레코드의 개수를 알수 있다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
				// 사용한 자원을 finally 문을 이용해서 반납한다.
				// 자원 반납은 사용했던 객체의 역순으로 하며 모두 공통적으로
				// close() 메소드를 사용한다.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new TextAreaExMini();
	}

}
