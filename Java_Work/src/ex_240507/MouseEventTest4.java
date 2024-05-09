package ex_240507;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEventTest4 extends JFrame {
    public ArrayList<LabelClickListener> labelClickListener; // ArrayList를 public으로 변경

    public MouseEventTest4(JLabel jaJLabel, JLabel jaJLabel2, JLabel jaJLabel3) {
        labelClickListener = new ArrayList<>();

        setTitle("Mouse 이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        // 각 라벨에 대한 이벤트 처리기 생성
        MouseListener listener1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int x = event.getX();
                int y = event.getY();
                jaJLabel.setLocation(x, y);
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        };
        MouseListener listener2 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int x = event.getX();
                int y = event.getY();
                jaJLabel2.setLocation(x + 50, y + 50);
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        };
        MouseListener listener3 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int x = event.getX();
                int y = event.getY();
                jaJLabel3.setLocation(x + 100, y + 100);
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        };

        // labelClickListener에 라벨과 이벤트 처리기 추가
        labelClickListener.add(new LabelClickListener(jaJLabel, listener1));
        labelClickListener.add(new LabelClickListener(jaJLabel2, listener2));
        labelClickListener.add(new LabelClickListener(jaJLabel3, listener3));

        // 컨테이너에 마우스 이벤트 처리기 추가
        c.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent event) {
                ArrayList<LabelClickListener> copyListeners = new ArrayList<>(labelClickListener); // 리스트 복사
                for (LabelClickListener listener : copyListeners) { // 복사한 리스트를 순회
                    JLabel label = listener.getLabel();
                    MouseListener mouseListener = listener.getListener();
                    if (label.getBounds().contains(event.getPoint())) {
                        mouseListener.mouseClicked(event);
                    }
                }
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });

        c.setLayout(null);
        jaJLabel.setSize(50, 20);
        jaJLabel.setLocation(30, 30);
        c.add(jaJLabel);
        jaJLabel2.setSize(50, 20);
        jaJLabel2.setLocation(80, 80);
        c.add(jaJLabel2);
        jaJLabel3.setSize(50, 20);
        jaJLabel3.setLocation(100, 100);
        c.add(jaJLabel3);

        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        JLabel la = new JLabel("Hello");
        JLabel la2 = new JLabel("Menu");
        JLabel la3 = new JLabel("Menu2");
        MouseEventTest4 mouseEventTest = new MouseEventTest4(la, la2, la3);
    }

    private class LabelClickListener {
        private JLabel label;
        private MouseListener listener;

        public LabelClickListener(JLabel label, MouseListener listener) {
            this.label = label;
            this.listener = listener;
        }

        public JLabel getLabel() {
            return label;
        }

        public MouseListener getListener() {
            return listener;
        }
    }
}
