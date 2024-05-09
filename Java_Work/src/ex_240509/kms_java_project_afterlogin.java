package ex_240509;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class kms_java_project_afterlogin extends JFrame {
    JTextArea musicPreferenceTextArea;
    JButton functionBtn;
    JTextArea userInfoTextArea; // 새로운 텍스트 영역 추가
    
    public kms_java_project_afterlogin() {
        setTitle("afterLogin");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS)); // BoxLayout으로 변경

        JPanel userProfilePanel = new JPanel();
        userProfilePanel.setLayout(new BoxLayout(userProfilePanel, BoxLayout.Y_AXIS)); // BoxLayout으로 변경
        c.add(userProfilePanel);
        
        // 사용자 정보를 표시할 새로운 텍스트 영역 생성 및 userProfilePanel에 추가
        userInfoTextArea = new JTextArea(7, 15);
        userInfoTextArea.setEditable(false);
        userProfilePanel.add(userInfoTextArea);
        userInfoTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // 테두리 추가
        // 사용자 정보를 받아와서 텍스트 영역에 출력
        String userInfo = getUserInfo(); // 사용자 정보를 가져오는 메서드
        userInfoTextArea.setText(userInfo);
                
        JButton functionBtn = new JButton("플레이어로 이동");
        functionBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 플레이어로 이동 버튼 클릭 시 기능 페이지를 보여주는 창으로 이동
                kms_java_project_function functionFrame = new kms_java_project_function();
                functionFrame.setVisible(true);
            }
        });
        userProfilePanel.add(functionBtn);
        userProfilePanel.add(Box.createRigidArea(new Dimension(0, 10))); // 공간 추가
        
        musicPreferenceTextArea = new JTextArea(7, 15);
        musicPreferenceTextArea.setEditable(false);
        // userProfilePanel에 사용자 정보 텍스트 영역 추가
        userProfilePanel.add(musicPreferenceTextArea);
        musicPreferenceTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // 사용자 정보를 받아와서 텍스트 영역에 출력
        String userfavInfo = getUserfavInfo(); // 사용자 정보를 가져오는 메서드
        musicPreferenceTextArea.setText(userfavInfo);
      
              
        setSize(400, 500);
        setVisible(true);
    }

    // 실제로는 데이터베이스나 다른 저장소에서 사용자 정보를 가져와야 합니다.
    private String getUserInfo() {
        return "사용자 정보 출력"; // 여기서는 간단히 사용자 정보를 문자열로 반환합니다.
    }
    private String getUserfavInfo() {
        return "사용자 취향 출력"; // 여기서는 간단히 사용자 정보를 문자열로 반환합니다.
    }
}
