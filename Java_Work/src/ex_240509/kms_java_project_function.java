package ex_240509;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class kms_java_project_function extends JFrame {
    private JButton playButton, pauseButton, stopButton, prevButton, nextButton;
    private JLabel nowPlayingLabel;
    private JList<File> fileList;
    private DefaultListModel<File> listModel;
    private AdvancedPlayer player;
    private File[] musicFiles;
    private int currentSongIndex = 0;

    public kms_java_project_function() {
        setTitle("Music Player");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Controls Panel
        JPanel controlsPanel = new JPanel(new FlowLayout());

        playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                play();
            }
        });
        controlsPanel.add(playButton);

        // Add Music Button
        JButton addMusicButton = new JButton("Add Music");
        addMusicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectFiles(); // 파일 선택 메서드 호출
            }
        });
        controlsPanel.add(addMusicButton);

        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pause();
            }
        });
        controlsPanel.add(pauseButton);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });
        controlsPanel.add(stopButton);

        prevButton = new JButton("Previous");
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                previous();
            }
        });
        controlsPanel.add(prevButton);

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                next();
            }
        });
        controlsPanel.add(nextButton);

        // Now Playing Label
        nowPlayingLabel = new JLabel("Now Playing: ");

        // File List
        listModel = new DefaultListModel<>();
        fileList = new JList<>(listModel);
        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fileList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                currentSongIndex = fileList.getSelectedIndex();
            }
        });

        // Add components to the content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(controlsPanel, BorderLayout.NORTH);
        contentPane.add(nowPlayingLabel, BorderLayout.CENTER);
        contentPane.add(new JScrollPane(fileList), BorderLayout.WEST);
    }

    // 사용자에게 파일을 선택하도록 하는 메서드
    private void selectFiles() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true); // 다중 선택 가능하도록 설정

        int result = fileChooser.showOpenDialog(this); // 파일 선택 대화상자를 엽니다.
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles(); // 선택한 파일들을 가져옵니다.

            // 가져온 파일들을 리스트에 추가합니다.
            for (File file : selectedFiles) {
                listModel.addElement(file);
            }
        }
    }

    // 재생 메서드
    private void play() {
        try {
            if (player != null) {
                player.close();
            }
            player = new AdvancedPlayer(new FileInputStream(listModel.getElementAt(currentSongIndex)));
            new Thread() {
                public void run() {
                    try {
                        player.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            nowPlayingLabel.setText("Now Playing: " + listModel.getElementAt(currentSongIndex).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 일시 정지 메서드
    private void pause() {
        if (player != null) {
            player.close();
        }
    }

    // 정지 메서드
    private void stop() {
        if (player != null) {
            player.close();
            nowPlayingLabel.setText("Now Playing: ");
        }
    }

    // 이전 곡 재생 메서드
    private void previous() {
        if (currentSongIndex > 0) {
            currentSongIndex--;
            play();
        }
    }

    // 다음 곡 재생 메서드
    private void next() {
        if (currentSongIndex < listModel.size() - 1) {
            currentSongIndex++;
            play();
        }
    }
}
