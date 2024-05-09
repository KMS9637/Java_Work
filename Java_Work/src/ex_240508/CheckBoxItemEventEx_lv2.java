package ex_240508;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxItemEventEx_lv2 extends JFrame {
    private JCheckBox[] menu = new JCheckBox[5];
    private String[] names = {"국밥", "라면", "칼국수", "밀면", "짬뽕"};
    private JLabel sumLabel;

    public CheckBoxItemEventEx_lv2() {
        setTitle("체크박스와 ItemEvent 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(new JLabel("국밥 100원, 라면 200원, 칼국수 300원, 밀면 400원, 짬뽕 500원"));
        MyItemListener listener = new MyItemListener(sumLabel); // sumLabel을 MyItemListener 생성자에 전달

        for (int i = 0; i < menu.length; i++) {
            menu[i] = new JCheckBox(names[i]);
            menu[i].setBorderPainted(true);
            c.add(menu[i]);
            menu[i].addItemListener(listener);
        }

        sumLabel = new JLabel("현재 0 원 입니다.");
        c.add(sumLabel);
        setSize(250, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBoxItemEventEx_lv1();
    }
}

// 외부 클래스로 MyItemListener 정의
class MyItemListener implements ItemListener {
    private int sum = 0; // 가격의 합
    private JLabel sumLabel; // 합계 표시 레이블

    // 생성자 추가
    public MyItemListener(JLabel sumLabel) {
        this.sumLabel = sumLabel;
    }

    public void itemStateChanged(ItemEvent e) {
        JCheckBox checkBox = (JCheckBox) e.getItem();
        int price = getPrice(checkBox.getText()); // 체크박스에 해당하는 가격 가져오기

        if (e.getStateChange() == ItemEvent.SELECTED) {
            sum += price; // 가격 추가
        } else {
            sum -= price; // 가격 제거
        }

        sumLabel.setText("현재 " + sum + "원 입니다."); // 합계 업데이트
    }

    // 메뉴명에 따른 가격 반환 메서드
    private int getPrice(String menuName) {
        switch (menuName) {
            case "국밥":
                return 100;
            case "라면":
                return 200;
            case "칼국수":
                return 300;
            case "밀면":
                return 400;
            case "짬뽕":
                return 500;
            default:
                return 0;
        }
    }
}
