package org.main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ResultFrame {
    private int result;

//    public int getResult() {
//        return result;
//    }
//
//    public void setResult(int result) {
//        this.result = result;
//    }
//
//    private  int result;

    public  ResultFrame(int result) {

        this.result = result;
        initializeUi();
    }

    public void initializeUi( ) {
        JFrame resultFrame=new JFrame("ResultFrame");
        resultFrame.setSize(1100,600);
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon registerIcon=new ImageIcon("resources/result.png");
        resultFrame.setIconImage(registerIcon.getImage());
        resultFrame.setResizable(false);
        resultFrame.setLayout(null);



        JLabel label=new JLabel();

        int res=result+1;

        if (result==0){
            label.setText("Score :"+String.valueOf(result));
        }else
        {
            label.setText("Score :"+String.valueOf(res));
        }

        label.setBounds(450,-10,200,100);
        label.setFont(new Font("Times New Roman",Font.BOLD,40));
        label.setForeground(Color.BLUE);

        JLabel rLabel=new JLabel();
        rLabel.setBounds(450,30,700,400);

        if(res==10)
        {
            ImageIcon resultIcon=new ImageIcon("resources/excellent.png");
            rLabel.setIcon(resultIcon);
        }
        else if(res>=7)
        {
            ImageIcon resultIcon=new ImageIcon("resources/good.png");
            rLabel.setIcon(resultIcon);
        }
        else if(res>=5)
        {
            ImageIcon resultIcon=new ImageIcon("resources/average.png");
            rLabel.setIcon(resultIcon);
        }
        else
        {
            ImageIcon resultIcon=new ImageIcon("resources/poor.png");
            rLabel.setIcon(resultIcon);
        }

        Font labelFont = new Font("Arial", Font.BOLD, 20);
        JButton button=new JButton("Play Again");
        button.setBounds(435,400,200,50);
        button.setFont(labelFont);
        button.setFocusable(false);
        button.setBorder(null);
        button.setBackground(Color.BLUE);
        button.setForeground(Color.white);

        button.addActionListener(e -> {

            resultFrame.dispose();
            new Login();

        });






        resultFrame.add(button);
        resultFrame.add(label);
        resultFrame.add(rLabel);


        resultFrame.setVisible(true);


    }
}
