package org.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class QuestionListFrame {

    private JLabel sN;
    private JLabel ques;

    private JRadioButton op1R;
    private JRadioButton op2R;
    private JRadioButton op3R;
    private JRadioButton op4R;

    private ButtonGroup buttonGroup;

    public Question qu = new Question();
    public ArrayList<Question> allQuestion = new ArrayList<>();


    String category;
    int quesNo = 1;


    public QuestionListFrame(String category) {
        this.category = category;

//        System.out.println("category->" + category);
        initializeUi();
        setCategory();
        setQuestionList(index);
    }

    public void initializeUi() {
        JFrame questionListFrame = new JFrame("QuestionListFrame");
        questionListFrame.setSize(1100, 600);
        questionListFrame.setLocationRelativeTo(null);
        questionListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon registerIcon = new ImageIcon("resources/question.png");
        questionListFrame.setIconImage(registerIcon.getImage());
//        questionFrame.getContentPane().setBackground(Color.darkGray);
        questionListFrame.setResizable(false);
        questionListFrame.setLayout(null);


        Font labelFont = new Font(null, Font.BOLD, 20);
        Font textFont = new Font(null, Font.BOLD, 18);


        ImageIcon img = new ImageIcon("resources/quiz.jpg");
        Image image = img.getImage();

        Image resizedImage = image.getScaledInstance(1100, 300, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);


        JPanel jPanelTop = new JPanel();
        jPanelTop.setBounds(0, 0, 1100, 290);
        jPanelTop.setLayout(null);
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(0, 0, 1100, 290);
        imageLabel.setIcon(resizedIcon);
        jPanelTop.add(imageLabel);


        JPanel jPanelBottom = new JPanel();
        jPanelBottom.setBounds(0, 290, 1100, 310);
        jPanelBottom.setBackground(Color.pink);
        jPanelBottom.setLayout(null);

        sN = new JLabel();
        sN.setBounds(50, 20, 50, 50);
        jPanelBottom.add(sN);
        sN.setFont(labelFont);

        ques = new JLabel();
        ques.setBounds(80, 20, 850, 50);
        jPanelBottom.add(ques);
        ques.setFont(labelFont);


        op1R = new JRadioButton();
        op1R.setBounds(50, 60, 850, 40);
        op1R.setFont(textFont);
        jPanelBottom.add(op1R);
        op1R.setBackground(null);
        op1R.setBorder(null);


        op2R = new JRadioButton();
        op2R.setBounds(50, 90, 850, 40);
        op2R.setFont(textFont);
        jPanelBottom.add(op2R);
        op2R.setBackground(null);
        op2R.setBorder(null);


        op3R = new JRadioButton();
        op3R.setBounds(50, 120, 850, 40);
        op3R.setFont(textFont);
        jPanelBottom.add(op3R);
        op3R.setBackground(null);
        op3R.setBorder(null);


        op4R = new JRadioButton();
        op4R.setBounds(50, 150, 850, 40);
        op4R.setFont(textFont);
        jPanelBottom.add(op4R);
        op4R.setBackground(null);
        op4R.setBorder(null);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(op1R);
        buttonGroup.add(op2R);
        buttonGroup.add(op3R);
        buttonGroup.add(op4R);
        JButton submit = new JButton("Submit");
        submit.setFont(labelFont);
        submit.setBounds(920, 85, 100, 40);
        jPanelBottom.add(submit);
        submit.setFocusable(false);

        submit.addActionListener(e -> {
            questionListFrame.dispose();
            new ResultFrame(myScore);
//             JOptionPane.showMessageDialog(questionListFrame,"your score is"+myScore,"Score",JOptionPane.INFORMATION_MESSAGE);
        });


        JButton exit = new JButton("Exit");
        exit.setFont(labelFont);
        exit.setBounds(920, 135, 100, 40);
        jPanelBottom.add(exit);
        exit.setFocusable(false);

        exit.addActionListener(e -> {
            new Login();
            questionListFrame.dispose();
        });


        JButton next = new JButton("Next");
        next.setFont(labelFont);
        next.setBounds(920, 35, 100, 40);
        jPanelBottom.add(next);
        next.setFocusable(false);


        next.addActionListener(e -> {
            index = getRandomIndex();
            if (index <= qu.getQuestionsCount()) {
                int n = 10;
                String answer = allQuestion.get(index).getAnswer_key();
                System.out.println("answer------->" + answer);
//                scoreCount(answer);
                quesNo++;
                if (quesNo <= n) {
//                    scoreCount(answer);
                    setQuestionList(index);
                    System.out.println("random index->"+ index);
                }
            }

            if (quesNo > 10) {
                JOptionPane.showMessageDialog(questionListFrame, "End of Question! Submit to Know your Score", "Error", JOptionPane.ERROR_MESSAGE);
            }

            buttonGroup.clearSelection();

        });


        questionListFrame.add(jPanelTop);
        questionListFrame.add(jPanelBottom);
        questionListFrame.setVisible(true);
    }

//    Question qu = new Question();
//    ArrayList<Question> allQuestion=qu.getAllEasyQuestions();;

    public void setCategory() {
        switch (category) {
            case "Easy" -> allQuestion = qu.getAllEasyQuestions();
            case "Medium" -> allQuestion = qu.getAllMediumQuestions();
            case "Hard" -> allQuestion = qu.getAllHardQuestions();
        }
    }

    int index;


    public void setQuestionList(int idx) {


        if (idx < allQuestion.size()) {

            System.out.println("size"+allQuestion.size());

//            int qNo = allQuestion.get(idx).getQuestionId();
            String question = allQuestion.get(idx).getQuestion();
            String opt1 = allQuestion.get(idx).getOption1();
            String opt2 = allQuestion.get(idx).getOption2();
            String opt3 = allQuestion.get(idx).getOption3();
            String opt4 = allQuestion.get(idx).getOption4();
            sN.setText(quesNo + ":");
            ques.setText(question);
            op1R.setText(opt1);
            op1R.setActionCommand(opt1);
            op2R.setText(opt2);
            op1R.setActionCommand(opt2);
            op3R.setText(opt3);
            op1R.setActionCommand(opt3);
            op4R.setText(opt4);
            op1R.setActionCommand(opt4);

//            System.out.println(question);
            String answer = allQuestion.get(idx).getAnswer_key();
            scoreCount(answer);
//            System.out.println("answer->"+answer);

        }


    }


    public int getRandomIndex() {
        return (int) (Math.floor(Math.random() * 30));
    }


    int myScore = 0;

    public void scoreCount(String answer) {


        String ans=answer;
        System.out.println("trimmedAnswer->" + ans);

        System.out.println();


        if (buttonGroup.getSelection() != null) {

            if (op1R.isSelected() && op1R.getText().equals(answer)) {
                myScore++;
            } else if (op2R.isSelected() && op2R.getText().equals(answer)) {
                myScore++;
            } else if (op3R.isSelected() && op3R.getText().equals(answer)) {
                myScore++;
            } else if (op4R.isSelected() && op4R.getText().equals(answer)) {
                myScore++;
            }
        }


        System.out.println("scoreCount->" + myScore);


//        String trimmedOp1R = op1R.getText().trim();
//
//        System.out.println("trimmedOp1R->" + trimmedOp1R);
//        String trimmedOp2R = op2R.getText().trim();
//
//        System.out.println("trimmedOp2R->" + trimmedOp2R);
//        String trimmedOp3R = op3R.getText().trim();
//
//        System.out.println("trimmedOp3R->" + trimmedOp3R);
//        String trimmedOp4R = op4R.getText().trim();
//
//        System.out.println("trimmedOp4R->" + trimmedOp4R);


//        for (int i = 0; i < allQuestion.size(); i++) {
//
//            System.out.println("answer--------->" + allQuestion.get(i).getAnswer_key());
//
//        }


//       Question question=new Question();
//       question.setScore(myScore);
//
//        System.out.println("score from question->"+question.getScore());

    }

    public  boolean isEqual(String s1,String s2){
        return s1.equalsIgnoreCase(s2.trim());
    }

}