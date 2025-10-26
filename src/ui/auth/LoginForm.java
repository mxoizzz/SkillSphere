package ui.auth;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.User;
import service.UserService;

public class LoginForm extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;

    private UserService userService;

    public LoginForm() {
        userService = new UserService();

        setTitle("SkillSphere | Login");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 50, 180, 25);
        add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 180, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 170, 130, 30);
        add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(200, 170, 130, 30);
        add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterForm().setVisible(true);
            }
        });
    }

    private void loginUser() {
        String email = emailField.getText().trim().toLowerCase();
        String password = new String(passwordField.getPassword()).trim();

        User user = userService.loginUser(email, password);
        if(user != null) {
            JOptionPane.showMessageDialog(this, "Login successful! Welcome " + user.getName());
            dispose();
            // new DashboardForm(user).setVisible(true); // Open dashboard for logged-in user
        } else {
            JOptionPane.showMessageDialog(this, "Invalid email or password.");
        }
    }

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }
}
