package ui.auth;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.User;
import service.UserService;

public class RegisterForm extends JFrame {

    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private JComboBox<String> roleBox;
    private JButton registerButton, loginButton;

    private UserService userService;

    public RegisterForm() {
        userService = new UserService();

        setTitle("SkillSphere | Register");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 50, 180, 25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 100, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 100, 180, 25);
        add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 150, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 180, 25);
        add(passwordField);

        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(50, 200, 100, 25);
        add(roleLabel);

        roleBox = new JComboBox<>(new String[]{"Learner", "Mentor", "Employer"});
        roleBox.setBounds(150, 200, 180, 25);
        add(roleBox);

        registerButton = new JButton("Register");
        registerButton.setBounds(50, 270, 130, 30);
        add(registerButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(200, 270, 130, 30);
        add(loginButton);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close register form
                new LoginForm().setVisible(true);
            }
        });
    }

    private void registerUser() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim().toLowerCase();
        String password = new String(passwordField.getPassword()).trim();
        int roleId = roleBox.getSelectedIndex() + 1; // 1 = Learner, 2 = Mentor, 3 = Employer

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoleId(roleId);

        String result = userService.registerUser(user);
        JOptionPane.showMessageDialog(this, result);

        if(result.equals("User registered successfully.")) {
            dispose();
            new LoginForm().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new RegisterForm().setVisible(true);
    }
}
