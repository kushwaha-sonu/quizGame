package org.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame {

    String name;
    String email;

    public StartFrame(String name, String email) {
        this.name = name;
        this.email = email;
        initializeUi();
    }

    public void initializeUi() {
        JFrame startFrame = new JFrame("StartFrame");
        startFrame.setSize(1100, 600);
        startFrame.setLocationRelativeTo(null);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon registerIcon = new ImageIcon("resources/result.png");
        startFrame.setIconImage(registerIcon.getImage());
        startFrame.setResizable(false);
        startFrame.setLayout(null);


        JLabel labelName = new JLabel();
        labelName.setText("Welcome " + name);
        labelName.setBounds(450, -10, 500, 100);
        labelName.setFont(new Font("Times New Roman", Font.BOLD, 40));
        labelName.setForeground(Color.BLUE);
        labelName.setVerticalTextPosition(JLabel.CENTER);
        labelName.setHorizontalTextPosition(JLabel.CENTER);

        JLabel emailLabel = new JLabel(email);
        emailLabel.setBounds(425, 50, 700, 100);
        emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        emailLabel.setForeground(Color.BLUE);
        emailLabel.setVerticalTextPosition(JLabel.CENTER);
        emailLabel.setHorizontalTextPosition(JLabel.CENTER);


        Font labelFont = new Font("Arial", Font.BOLD, 20);
        Object[] queLevel = {"<--- Select Level --->", "Easy", "Medium", "Hard"};

        JComboBox<Object> jComboBox = new JComboBox<>(queLevel);
        jComboBox.setBounds(450, 200, 250, 50);
        jComboBox.setFont(labelFont);


        class CenteredTextComboBoxRenderer extends DefaultListCellRenderer {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                return label;
            }
        }
        jComboBox.setRenderer(new CenteredTextComboBoxRenderer());


        JButton button = new JButton("Play Quiz");
        button.setBounds(470, 300, 200, 50);
        button.setFont(labelFont);
        button.setFocusable(false);
        button.setBorder(null);
        button.setBackground(Color.BLUE);
        button.setForeground(Color.white);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String level = jComboBox.getSelectedItem().toString();
//                System.out.println(level);
                if (level.equals("<--- Select Level --->")) {
                    JOptionPane.showMessageDialog(startFrame, "Please select the level");
                }else {
                    startFrame.dispose();
                    new QuestionListFrame(level);
                }
            }
        });


        startFrame.add(jComboBox);
        startFrame.add(button);
        startFrame.add(labelName);
        startFrame.add(emailLabel);


        startFrame.setVisible(true);


    }
}
