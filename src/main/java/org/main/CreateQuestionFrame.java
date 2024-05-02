package org.main;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CreateQuestionFrame {

    public static final JFrame questionFrame = new JFrame("Register");
    public static final JLabel LABEL_1 = new JLabel("Enter Question:");

    public CreateQuestionFrame(){
        initializeUi();
    }

    public void initializeUi(){
        JFrame questionFrame= new JFrame("Create Question");
        questionFrame.setSize(1100,700);
        questionFrame.setLocationRelativeTo(null);
        questionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon registerIcon=new ImageIcon("resources/question.png");
        questionFrame.setIconImage(registerIcon.getImage());
//        questionFrame.getContentPane().setBackground(Color.darkGray);
        questionFrame.setResizable(false);
        questionFrame.setLayout(new GridLayout(1,1));


        Font labelFont=new Font(null,Font.BOLD,20);
        Font textFont=new Font(null,Font.BOLD,18);

        JPanel jPanel=new JPanel();
        jPanel.setBackground(Color.gray);
        jPanel.setLayout(null);

        JLabel label=new JLabel("Create Question");
        label.setFont(new Font(null,Font.BOLD,48));
        label.setBounds(380,10,400,50);
        jPanel.add(label);

        Object [] queLevel={"<--- Select Level --->","Easy","Medium","Hard"};

        JComboBox<Object>jComboBox=new JComboBox<>(queLevel);
        jComboBox.setBounds(50,200,250,50);
        jComboBox.setFont(labelFont);
        jPanel.add(jComboBox);


        class CenteredTextComboBoxRenderer extends DefaultListCellRenderer {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                return label;
            }
        }
        jComboBox.setRenderer(new CenteredTextComboBoxRenderer());


        JLabel label1=new JLabel("Enter Question:");
        label1.setBounds(380,80,200,30);
        label1.setFont(labelFont);
        jPanel.add(label1);

        JTextField questionTextField=new JTextField();
        questionTextField.setBounds(380,110,450,40);
        questionTextField.setFont(textFont);
        jPanel.add(questionTextField);
        questionTextField.setBorder(null);

        JLabel option1Label= new JLabel("Option1:");

        option1Label.setBounds(380,150,200,30);
        option1Label.setFont(labelFont);
        jPanel.add(option1Label);

        JTextField option1TextField=new JTextField();
        option1TextField.setBounds(380,180,450,40);
        option1TextField.setFont(textFont);
        jPanel.add(option1TextField);
        option1TextField.setBorder(null);

        JLabel option2Label=new JLabel("Option2:");
        option2Label.setBounds(380,220,200,30);
        option2Label.setFont(labelFont);
        jPanel.add(option2Label);

        JTextField option2TextField=new JTextField();
        option2TextField.setBounds(380,250,450,40);
        option2TextField.setFont(textFont);
        jPanel.add(option2TextField);
        option2TextField.setBorder(null);

        JLabel option3Label=new JLabel("Option3:");
        option3Label.setBounds(380,290,200,30);
        option3Label.setFont(labelFont);
        jPanel.add(option3Label);

        JTextField option3TextField=new JTextField();
        option3TextField.setBounds(380,320,450,40);
        option3TextField.setFont(textFont);
        jPanel.add(option3TextField);
        option3TextField.setBorder(null);

        JLabel option4Label=new JLabel("Option4:");
        option4Label.setBounds(380,360,200,30);
        option4Label.setFont(labelFont);
        jPanel.add(option4Label);

        JTextField option4TextField=new JTextField();
        option4TextField.setBounds(380,390,450,40);
        option4TextField.setFont(textFont);
        jPanel.add(option4TextField);
        option4TextField.setBorder(null);

        JLabel answerLabel=new JLabel("AnswerKey:");
        answerLabel.setBounds(380,430,200,30);
        answerLabel.setFont(labelFont);
        jPanel.add(answerLabel);

        JTextField answerTextField=new JTextField();
        answerTextField.setBounds(380,460,450,40);
        answerTextField.setFont(textFont);
        jPanel.add(answerTextField);
        answerTextField.setBorder(null);

        JButton submit=new JButton("Save");
        submit.setBounds(430,540,150,50);
        submit.setFont(labelFont);
        jPanel.add(submit);
        submit.setFocusable(false);
        submit.setBorder(null);

        submit.addActionListener(e -> {
            String question=questionTextField.getText();
            String option1=option1TextField.getText();
            String option2=option2TextField.getText();
            String option3=option3TextField.getText();
            String option4=option4TextField.getText();
            String answerKey=answerTextField.getText();

            String level=(String)jComboBox.getSelectedItem();
            System.out.println(level);

            Question q=new Question();
            if (question.isEmpty()){
                JOptionPane.showMessageDialog(questionFrame, "Question cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (option1.isEmpty() ||option2.isEmpty() ||option3.isEmpty() ||option4.isEmpty() ||answerKey.isEmpty()) {
                JOptionPane.showMessageDialog(questionFrame, "Option cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (Objects.equals(level,"<--- Select Level --->")) {
                JOptionPane.showMessageDialog(questionFrame, "Select Level Of Question!", "Error", JOptionPane.ERROR_MESSAGE);
            } else{
                if (Objects.equals(level,"Easy")){
                   q.addEasyQuestionToDatabase(question,option1,option2,option3,option4,answerKey);
                } else if (Objects.equals(level,"Medium")) {
                   q.addMediumQuestionToDatabase(question,option1,option2,option3,option4,answerKey);
                }else if (Objects.equals(level,"Hard")){
                   q.addHardQuestionToDatabase(question,option1,option2,option3,option4,answerKey);
                }
                JOptionPane.showMessageDialog(questionFrame, "Question Created successfully !", "Success", JOptionPane.INFORMATION_MESSAGE);
                questionTextField.setText("");
                option1TextField.setText("");
                option2TextField.setText("");
                option3TextField.setText("");
                option4TextField.setText("");
                answerTextField.setText("");
            }


        });


        JButton exit=new JButton("Exit");
        exit.setBounds(620,540,150,50);
        exit.setFont(labelFont);
        jPanel.add(exit);
        exit.setFocusable(false);
        exit.setBorder(null);

        exit.addActionListener(e -> {
            new Login();
            questionFrame.dispose();
        });



        questionFrame.add(jPanel);
        questionFrame.setVisible(true);

    }
}
