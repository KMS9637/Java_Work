package ex_240508;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class MyItemListener_lv2 implements ItemListener {
    private int sum = 0; // 가격의 합
    private JCheckBox[] menu; // 메뉴 체크박스 배열
    private JLabel sumLabel; // 합계 표시 레이블

    // 생성자 추가
    public MyItemListener_lv2(JCheckBox[] menu, JLabel sumLabel) {
        this.menu = menu;
        this.sumLabel = sumLabel;
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            for (int i = 0; i < menu.length; i++) {
                if (e.getItem() == menu[i]) {
                    sum += (i + 1) * 100; // 각 메뉴별 가격 계산
                    break;
                }
            }
        } else {
            for (int i = 0; i < menu.length; i++) {
                if (e.getItem() == menu[i]) {
                    sum -= (i + 1) * 100; // 각 메뉴별 가격 계산
                    break;
                }
            }
        }
        sumLabel.setText("현재 " + sum + "원 입니다.");
    }
}
