package ui.auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.User;
import service.UserService;

public class RegisterForm extends JFrame {

    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private JComboBox<String> roleBox;
    private final UserService userService = new UserService();

    public RegisterForm() {
        setTitle("SkillSphere | Register");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        // ==== Background ====
        JPanel background = new JPanel(new GridBagLayout());
        background.setBackground(new Color(25, 25, 25));
        add(background);

        // ==== Card ====
        JPanel card = new JPanel();
        card.setBackground(new Color(40, 40, 40));
        card.setPreferredSize(new Dimension(380, 500));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // ==== Title ====
        JLabel title = new JLabel("Create Your Account", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(title);
        card.add(Box.createVerticalStrut(25));

        // ==== Name ====
        JLabel nameLabel = createLabel("Name");
        card.add(wrapLeftAligned(nameLabel));
        nameField = createTextField();
        card.add(nameField);
        card.add(Box.createVerticalStrut(20));

        // ==== Email ====
        JLabel emailLabel = createLabel("Email");
        card.add(wrapLeftAligned(emailLabel));
        emailField = createTextField();
        card.add(emailField);
        card.add(Box.createVerticalStrut(20));

        // ==== Password ====
        JLabel passwordLabel = createLabel("Password");
        card.add(wrapLeftAligned(passwordLabel));
        passwordField = new JPasswordField();
        styleField(passwordField);
        card.add(passwordField);
        card.add(Box.createVerticalStrut(20));

        // ==== Role ====
        JLabel roleLabel = createLabel("Role");
        card.add(wrapLeftAligned(roleLabel));
        roleBox = new JComboBox<>(new String[]{"Learner", "Mentor", "Employer"});
        styleComboBox(roleBox);
        card.add(roleBox);
        card.add(Box.createVerticalStrut(30));

        // ==== Register Button ====
        JButton registerButton = createButton("Register", new Color(46, 204, 113));
        registerButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        registerButton.addActionListener(e -> registerUser());
        card.add(registerButton);
        card.add(Box.createVerticalStrut(20));

        // ==== Login text ====
        JLabel loginLabel = new JLabel(
            "<html><div style='text-align:center;color:#ccc;'>Already have an account? <span style='color:#3498DB;text-decoration:underline;'>Login</span></div></html>",
            SwingConstants.CENTER
        );
        loginLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginForm().setVisible(true);
            }
            public void mouseEntered(MouseEvent e) {
                loginLabel.setText("<html><div style='text-align:center;color:#ccc;'>Already have an account? <span style='color:#2980B9;text-decoration:underline;'>Login</span></div></html>");
            }
            public void mouseExited(MouseEvent e) {
                loginLabel.setText("<html><div style='text-align:center;color:#ccc;'>Already have an account? <span style='color:#3498DB;text-decoration:underline;'>Login</span></div></html>");
            }
        });
        card.add(loginLabel);

        background.add(card);
    }

    // ===== Helper methods =====

    private JPanel wrapLeftAligned(JComponent comp) {
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        wrapper.setOpaque(false);
        wrapper.add(comp);
        return wrapper;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        label.setForeground(Color.LIGHT_GRAY);
        return label;
    }

    private JTextField createTextField() {
        JTextField field = new JTextField();
        styleField(field);
        return field;
    }

    private void styleField(JTextField field) {
        field.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        field.setBackground(new Color(60, 60, 60));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(90, 90, 90)),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
    }

    private void styleComboBox(JComboBox<String> combo) {
        combo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        combo.setBackground(new Color(60, 60, 60));
        combo.setForeground(Color.WHITE);
        combo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        combo.setFocusable(false);
        combo.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));
    }

    private JButton createButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btn.setBackground(bg.darker()); }
            public void mouseExited(MouseEvent e) { btn.setBackground(bg); }
        });
        return btn;
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

        if (result.equals("User registered successfully.")) {
            dispose();
            new LoginForm().setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegisterForm().setVisible(true));
    }
}
