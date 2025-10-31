package ui.dashboard;

import javax.swing.*;
import java.awt.*;
import ui.auth.LoginForm;

public class NavbarPanel extends JPanel {

    private final Color navBg = new Color(30, 30, 30);
    private final Color accent = new Color(0, 200, 150);

    public NavbarPanel(String userName, String role) {
        setBackground(navBg);
        setPreferredSize(new Dimension(0, 60));
        setLayout(new BorderLayout());

        JLabel logo = new JLabel("SkillSphere", SwingConstants.LEFT);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        logo.setForeground(accent);
        logo.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        userPanel.setOpaque(false);

        JLabel userInfo = new JLabel(userName + "  |  " + role);
        userInfo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        userInfo.setForeground(Color.WHITE);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBackground(new Color(200, 0, 70));
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        logoutBtn.setBorder(BorderFactory.createEmptyBorder(8, 14, 8, 14));
        logoutBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                logoutBtn.setBackground(new Color(170, 0, 60));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                logoutBtn.setBackground(new Color(200, 0, 70));
            }
        });

        // ✅ Logout functionality with confirmation dialog
        logoutBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    NavbarPanel.this,
                    "Are you sure you want to logout?",
                    "Confirm Logout",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            if (confirm == JOptionPane.YES_OPTION) {
                Window topWindow = SwingUtilities.getWindowAncestor(NavbarPanel.this);
                if (topWindow != null) topWindow.dispose();
                new LoginForm().setVisible(true);
            }
        });

        userPanel.add(userInfo);
        userPanel.add(logoutBtn);

        add(logo, BorderLayout.WEST);
        add(userPanel, BorderLayout.EAST);
    }
}
