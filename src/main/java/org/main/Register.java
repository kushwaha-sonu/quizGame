package org.main;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Register {
     public Register(){
         initializeUi();
     }

     public void initializeUi(){
         JFrame registerFrame=new JFrame("Register");
         registerFrame.setSize(1100,600);
         registerFrame.setLocationRelativeTo(null);
         registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ImageIcon registerIcon=new ImageIcon("resources/reg.png");
         registerFrame.setIconImage(registerIcon.getImage());
         registerFrame.getContentPane().setBackground(Color.darkGray);
         registerFrame.setResizable(false);
         registerFrame.setLayout(null);

//         left panel
//------------------------------------------------------------------------------------------------------------
         JPanel leftPanel=new JPanel();
         Border border=BorderFactory.createLineBorder(Color.BLACK,4);
         ImageIcon img1=new ImageIcon("resources/reg.png");
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

         JLabel register=new JLabel("Register");
         rightPanel.add(register);
         register.setForeground(Color.BLACK);
         register.setBounds(120,5,530,70);
         register.setFont(tittle);
         register.setVerticalTextPosition(JLabel.CENTER);
         register.setVerticalAlignment(JLabel.CENTER);


         JSeparator jSeparator=new JSeparator();
         jSeparator.setBounds(0,75,530,1);
         jSeparator.setForeground(Color.CYAN);
         jSeparator.setBackground(null);
         rightPanel.add(jSeparator);


//      Name

         JLabel name = new JLabel("Name:");
         rightPanel.add(name);
         name.setBounds(0,90,530,30);
         name.setFont(labelFont);

         JTextField textFieldName=new JTextField(30);
         rightPanel.add(textFieldName);
         textFieldName.setBounds(0,120,400,40);
         textFieldName.setBorder(null);
         textFieldName.setFont(textField);


//       Email

         JLabel email = new JLabel("Email:");
         rightPanel.add(email);
         email.setBounds(0,160,60,30);
         email.setFont(labelFont);

         JTextField jTextFieldEmail=new JTextField(20);
         rightPanel.add(jTextFieldEmail);
         jTextFieldEmail.setBounds(0,190,400,40);
         jTextFieldEmail.setBorder(null);
         jTextFieldEmail.setFont(textField);


//        Password

         JLabel password = new JLabel("Password:");
         rightPanel.add(password);
         password.setBounds(0,230,100,30);
         password.setFont(labelFont);

         JPasswordField jPasswordField =new JPasswordField(20);
         rightPanel.add(jPasswordField);
         jPasswordField.setBounds(0,260,400,40);
         jPasswordField.setBorder(null);
         jPasswordField.setFont(textField);

//        Confirm Password

         JLabel confirmPassword = new JLabel("Confirm Password:");
         rightPanel.add(confirmPassword);
         confirmPassword.setBounds(0,300,200,30);
         confirmPassword.setFont(labelFont);

         JPasswordField jPasswordFieldC =new JPasswordField(20);
         rightPanel.add(jPasswordFieldC);
         jPasswordFieldC.setBounds(0,330,400,40);
         jPasswordFieldC.setBorder(null);
         jPasswordFieldC.setFont(textField);

//       Register Button
         JButton registerButton =new JButton("Register");
         rightPanel.add(registerButton);
         registerButton.setBounds(0,410,150,50);
         registerButton.setFont(labelFont);
         registerButton.setFocusable(false);
         registerButton.setBorder(null);



         registerButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 User user =new User();

                 String name=textFieldName.getText();
                 String email=jTextFieldEmail.getText();
                 char [] password= jPasswordField.getPassword();
                 String pass=new String(password);
                 char [] cPassword=jPasswordFieldC.getPassword();
                 if (name.isEmpty()){
                     JOptionPane.showMessageDialog(registerFrame, "Username cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                 }else if (email.isEmpty()){
                     JOptionPane.showMessageDialog(registerFrame, "Email cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                 } else if (Arrays.toString(password).isEmpty()) {
                     JOptionPane.showMessageDialog(registerFrame, "Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                 } else if (Arrays.toString(cPassword).isEmpty()) {
                     JOptionPane.showMessageDialog(registerFrame, "Confirm Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                 } else if (!Arrays.equals(password, cPassword)) {
                     JOptionPane.showMessageDialog(registerFrame, "Password and Confirm Password must match!", "Error", JOptionPane.ERROR_MESSAGE);
                 } else if (Arrays.toString(password).length()<6) {
                     JOptionPane.showMessageDialog(registerFrame, "Password must be at least 6 characters long!", "Error", JOptionPane.ERROR_MESSAGE);
                 } else if (!Arrays.toString(password).matches(".*[a-zA-Z].*")) {
                     JOptionPane.showMessageDialog(registerFrame, "Password must contain at least one letter!", "Error", JOptionPane.ERROR_MESSAGE);
                 } else if (!Arrays.toString(password).matches(".*\\d.*")) {
                     JOptionPane.showMessageDialog(registerFrame, "Password must contain at least one digit!", "Error", JOptionPane.ERROR_MESSAGE);
                 } else if (!isValidEmail(email)){
                     JOptionPane.showMessageDialog(registerFrame, "Invalid email address!", "Error", JOptionPane.ERROR_MESSAGE);
                 } else if (user.getUserDataByEmail(email)) {
                     JOptionPane.showMessageDialog(registerFrame, "Account already exits with this email ! Please Login to your Account!", "Error", JOptionPane.ERROR_MESSAGE);
                 } else {
                     JOptionPane.showMessageDialog(registerFrame, "Account Created successful ! Click Below to Login ", "Success", JOptionPane.INFORMATION_MESSAGE);
                     if(!user.getUserDataByEmail(email)){
                         user.addUserToDatabase(name,email,pass);
                     }
                     textFieldName.setText("");
                     jTextFieldEmail.setText("");
                     jPasswordField.setText("");
                     jPasswordFieldC.setText("");
                 };



             }
         });

//      Cancel Button
         JButton cancelButton =new JButton("Cancel");
         rightPanel.add(cancelButton);
         cancelButton.setBounds(250,410,150,50);
         cancelButton.setFont(labelFont);
         cancelButton.setFocusable(false);
         cancelButton.setBorder(null);


         JLabel loginLabel=new JLabel("Already Have Account ! Click Here ->");
         loginLabel.setBounds(50,470,375,30);
         rightPanel.add(loginLabel);
         loginLabel.setFont(new Font(null,Font.BOLD,12));

//         login btn


         JButton loginBtn =new JButton("Log In");
         rightPanel.add(loginBtn);
         loginBtn.setBounds(260,470,80,30);
         loginBtn.setFont(labelFont);
         loginBtn.setFocusable(false);
         loginBtn.setForeground(Color.red);
         loginBtn.setBorder(null);
         loginBtn.setBackground(null);

         loginBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if (e.getSource()==loginBtn){
                     registerFrame.dispose();
                     new Login();
                 }
             }
         });


         registerFrame.add(leftPanel);
         registerFrame.add(rightPanel);
         registerFrame.setVisible(true);
     }

    private  boolean isValidEmail(String email) {
        // Regular expression for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
}
