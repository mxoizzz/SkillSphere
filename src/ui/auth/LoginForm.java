package ui.auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.User;
import service.UserService;

public class LoginForm extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private final UserService userService = new UserService();

    public LoginForm() {
        setTitle("SkillSphere | Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 450);
        setLocationRelativeTo(null);
        setResizable(false);

        // ==== Background ====
        JPanel background = new JPanel(new GridBagLayout());
        background.setBackground(new Color(25, 25, 25));
        add(background);

        // ==== Card ====
        JPanel card = new JPanel();
        card.setBackground(new Color(40, 40, 40));
        card.setPreferredSize(new Dimension(380, 370));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // ==== Title ====
        JLabel title = new JLabel("Welcome to SkillSphere", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(title);
        card.add(Box.createVerticalStrut(25));

        // ==== Email Label + Field ====
        JLabel emailLabel = createLabel("Email");
        card.add(wrapLeftAligned(emailLabel));
        emailField = createTextField();
        card.add(emailField);
        card.add(Box.createVerticalStrut(20));

        // ==== Password Label + Field ====
        JLabel passLabel = createLabel("Password");
        card.add(wrapLeftAligned(passLabel));
        passwordField = new JPasswordField();
        styleField(passwordField);
        card.add(passwordField);
        card.add(Box.createVerticalStrut(30));

        // ==== Login Button (wide) ====
        JButton loginButton = createButton("Login", new Color(52, 152, 219));
        loginButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        loginButton.addActionListener(e -> loginUser());
        card.add(loginButton);
        card.add(Box.createVerticalStrut(20));

        // ==== Register text ====
        JLabel registerLabel = new JLabel(
            "<html><div style='text-align:center;color:#ccc;'>Don't have an account? <span style='color:#2ECC71;text-decoration:underline;'>Register</span></div></html>",
            SwingConstants.CENTER
        );
        registerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                new RegisterForm().setVisible(true);
            }
            public void mouseEntered(MouseEvent e) {
                registerLabel.setText("<html><div style='text-align:center;color:#ccc;'>Don't have an account? <span style='color:#27AE60;text-decoration:underline;'>Register</span></div></html>");
            }
            public void mouseExited(MouseEvent e) {
                registerLabel.setText("<html><div style='text-align:center;color:#ccc;'>Don't have an account? <span style='color:#2ECC71;text-decoration:underline;'>Register</span></div></html>");
            }
        });
        card.add(registerLabel);

        background.add(card);
    }

    // ===== Helper methods =====

    // Left-aligned wrapper for BoxLayout
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
        // field.setAlignmentX(Component.LEFT_ALIGNMENT);
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

    private void loginUser() {
        String email = emailField.getText().trim().toLowerCase();
        String password = new String(passwordField.getPassword()).trim();

        User user = userService.loginUser(email, password);
        if (user != null) {
            JOptionPane.showMessageDialog(this, "Login successful! Welcome " + user.getName());
            dispose();
            // new DashboardForm(user).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid email or password.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}
