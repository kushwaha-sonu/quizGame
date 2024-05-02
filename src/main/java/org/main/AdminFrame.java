package org.main;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminFrame {

    public static final JFrame adminFrame = new JFrame("Admin");

    public AdminFrame(){
        initializeUi();
    }

    public void initializeUi(){
        adminFrame.setSize(1100,600);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon registerIcon=new ImageIcon("resources/adminImage.png");
        adminFrame.setIconImage(registerIcon.getImage());
        adminFrame.getContentPane().setBackground(Color.darkGray);
        adminFrame.setResizable(false);
        adminFrame.setLayout(null);

//         left panel
//------------------------------------------------------------------------------------------------------------
        JPanel leftPanel=new JPanel();
        ImageIcon img1=new ImageIcon("resources/adminImage.png");
        leftPanel.setBounds(0,0,570,600);
        leftPanel.setLayout(null);




        JLabel label=new JLabel();
        label.setBounds(0,0,570,600);
        label.setIcon(img1);
        leftPanel.add(label);
        label.setLayout(new BorderLayout());
        label.setBorder(new EmptyBorder(0,30,30,30));
        label.setBackground(Color.lightGray);
        label.setOpaque(true);






//-------------------right panel -----------------------------------------------------------------------------
        Font tittle = new Font(null, Font.BOLD, 48);
        Font labelFont = new Font("Arial", Font.BOLD, 20);
        Font textField=new Font(null,Font.PLAIN,20);

        JPanel rightPanel=new JPanel();
        rightPanel.setBounds(570,0,530,600);
        rightPanel.setLayout(null);

        rightPanel.setBackground(Color.lightGray);

        JLabel register=new JLabel("Admin");
        rightPanel.add(register);
        register.setForeground(Color.BLACK);
        register.setBounds(150,5,530,70);
        register.setFont(tittle);
//        register.setVerticalTextPosition(JLabel.CENTER);
//        register.setVerticalAlignment(JLabel.CENTER);


        JSeparator jSeparator=new JSeparator();
        jSeparator.setBounds(0,75,530,1);
        jSeparator.setForeground(Color.CYAN);
        jSeparator.setBackground(null);
        rightPanel.add(jSeparator);


//      Name

        JLabel jLabel = new JLabel("Create A Quiz");
        rightPanel.add(jLabel);
        jLabel.setBounds(170,150,530,30);
        jLabel.setFont(labelFont);



        String [] category=new String[]{"<---Select Label Of Quiz--->","Easy","Medium","Hard"};

        JComboBox<String> jComboBox=new JComboBox<>(category);
        jComboBox.setBounds(100,200,300,50);
        rightPanel.add(jComboBox);
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




        adminFrame.add(leftPanel);
        adminFrame.add(rightPanel);
        adminFrame.setVisible(true);
    }

}
