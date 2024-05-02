package org.main;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class Login {

    public final String adminEmail = "admin@gmail.com";
    public final String adminPassword = "admin123";

    public String name;


    public Login() {
        initializeUi();
    }

    public void initializeUi() {

        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(1100, 600);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon registerIcon = new ImageIcon("resources/login2.png");
        loginFrame.setIconImage(registerIcon.getImage());
        loginFrame.getContentPane().setBackground(Color.darkGray);
        loginFrame.setResizable(false);
        loginFrame.setLayout(null);

//         left panel
//------------------------------------------------------------------------------------------------------------
        JPanel leftPanel = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 4);
        ImageIcon img1 = new ImageIcon("resources/login1.png");
        leftPanel.setBounds(0, 0, 570, 600);
        leftPanel.setLayout(null);


        JLabel label = new JLabel();
        label.setBounds(0, 0, 570, 600);
        label.setIcon(img1);
        leftPanel.add(label);
        label.setLayout(new BorderLayout());
        label.setBorder(new EmptyBorder(0, 30, 30, 30));
        label.setBackground(Color.lightGray);
        label.setOpaque(true);


//-------------------right panel -----------------------------------------------------------------------------
        Font tittle = new Font(null, Font.BOLD, 48);
        Font labelFont = new Font("Arial", Font.BOLD, 20);
        Font textField = new Font(null, Font.PLAIN, 20);

        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(570, 0, 530, 600);
        rightPanel.setLayout(null);

        rightPanel.setBackground(Color.lightGray);

        JLabel register = new JLabel("Login");
        rightPanel.add(register);
        register.setForeground(Color.BLACK);
        register.setBounds(120, 5, 530, 70);
        register.setFont(tittle);
        register.setVerticalTextPosition(JLabel.CENTER);
        register.setVerticalAlignment(JLabel.CENTER);


        JSeparator jSeparator = new JSeparator();
        jSeparator.setBounds(0, 75, 530, 1);
        jSeparator.setForeground(Color.CYAN);
        jSeparator.setBackground(null);
        rightPanel.add(jSeparator);

        String[] option = new String[]{"<------Select------>", "Admin", "User"};

        JComboBox<String> jComboBox = new JComboBox<>(option);
        jComboBox.setBounds(90, 100, 250, 50);
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


//      Name

        JLabel email = new JLabel("Email:");
        rightPanel.add(email);
        email.setBounds(0, 180, 530, 30);
        email.setFont(labelFont);

        JTextField textFieldEmail = new JTextField(30);
        rightPanel.add(textFieldEmail);
        textFieldEmail.setBounds(0, 210, 400, 40);
        textFieldEmail.setBorder(null);
        textFieldEmail.setFont(textField);

//        Password

        JLabel password = new JLabel("Password:");
        rightPanel.add(password);
        password.setBounds(0, 260, 100, 30);
        password.setFont(labelFont);

        JPasswordField jPasswordField = new JPasswordField(20);
        rightPanel.add(jPasswordField);
        jPasswordField.setBounds(0, 290, 400, 40);
        jPasswordField.setBorder(null);
        jPasswordField.setFont(textField);


//       Register Button
        JButton loginButton = new JButton("Login");
        rightPanel.add(loginButton);
        loginButton.setBounds(0, 370, 150, 50);
        loginButton.setFont(labelFont);
        loginButton.setFocusable(false);
        loginButton.setBorder(null);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email = textFieldEmail.getText();
                char[] password = jPasswordField.getPassword();
                String pass = new String(password);
                String role = (String) jComboBox.getSelectedItem();

                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(loginFrame, "Email cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (Arrays.toString(password).isEmpty()) {
                    JOptionPane.showMessageDialog(loginFrame, "Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (email.equals(adminEmail) && pass.equals(adminPassword) && Objects.equals(role, "Admin")) {
                    JOptionPane.showMessageDialog(loginFrame, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    new CreateQuestionFrame();
                    loginFrame.dispose();
                } else if (validateUser(email, pass) && Objects.equals(role, "User")) {
                    JOptionPane.showMessageDialog(loginFrame, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    new StartFrame(name,email);
                    loginFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Enter Valid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
                textFieldEmail.setText("");
                jPasswordField.setText("");


            }
        });

//      Cancel Button
        JButton cancelButton = new JButton("Cancel");
        rightPanel.add(cancelButton);
        cancelButton.setBounds(250, 370, 150, 50);
        cancelButton.setFont(labelFont);
        cancelButton.setFocusable(false);
        cancelButton.setBorder(null);

        cancelButton.addActionListener(e -> {
            if (e.getSource() == cancelButton) {
                new Register();
                loginFrame.dispose();

            }
        });


        JLabel registerLabel=new JLabel("Don't Have Account ! Click Here ->");
        registerLabel.setBounds(30,430,375,30);
        rightPanel.add(registerLabel);
        registerLabel.setFont(new Font(null,Font.BOLD,14));



        JButton registerBtn =new JButton("Register");
        rightPanel.add(registerBtn);
        registerBtn.setBounds(270,430,80,30);
        registerBtn.setFont(labelFont);
        registerBtn.setFocusable(false);
        registerBtn.setForeground(Color.red);
        registerBtn.setBorder(null);
        registerBtn.setBackground(null);

        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==registerBtn){
                    loginFrame.dispose();
                    new Register();
                }
            }
        });


        loginFrame.add(leftPanel);
        loginFrame.add(rightPanel);
        loginFrame.setVisible(true);
    }

    public boolean validateUser(String email, String pass) {
        User user = new User();
        name= user.getUserNameByEmail(email);
        if (!isValidEmail(email)) {
            return false;
        }
        ;
        if (!user.getUserDataByEmail(email)) {
            return false;
        }
        ;
        return user.getEmail().equals(email) && user.getPassword().equals(pass);
    }

    ;


    private boolean isValidEmail(String email) {
        // Regular expression for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

}

