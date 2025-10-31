package ui.dashboard;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class SidebarPanel extends JPanel {

    private final Color sidebarBg = new Color(25, 25, 25);
    private final Color buttonBg = new Color(40, 40, 40);
    private final Color hoverBg = new Color(55, 55, 55);
    private final Color accent = new Color(0, 200, 150);

    public SidebarPanel(String role) {
        setPreferredSize(new Dimension(230, 0));
        setBackground(sidebarBg);
        setLayout(new BorderLayout());

        JPanel navPanel = new JPanel();
        navPanel.setBackground(sidebarBg);
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));
        navPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        Map<String, String[]> roleMenus = new LinkedHashMap<>();
        roleMenus.put("Learner", new String[]{"Dashboard", "My Courses", "My Skills", "Progress", "Settings"});
        roleMenus.put("Mentor", new String[]{"Dashboard", "My Learners", "Courses", "Analytics", "Settings"});
        roleMenus.put("Employer", new String[]{"Dashboard", "Post Jobs", "Applicants", "Reports", "Settings"});
        roleMenus.put("Admin", new String[]{"Dashboard", "Manage Users", "Reports", "System Settings"});

        String[] menuItems = roleMenus.getOrDefault(role, new String[]{"Dashboard"});

        for (String item : menuItems) {
            JButton btn = createNavButton(item);
            navPanel.add(btn);
            navPanel.add(Box.createVerticalStrut(10));
        }

        add(navPanel, BorderLayout.CENTER);
    }

    private JButton createNavButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(sidebarBg);
        btn.setForeground(Color.LIGHT_GRAY);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // ✅ Make full width
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(hoverBg);
                btn.setForeground(accent);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(sidebarBg);
                btn.setForeground(Color.LIGHT_GRAY);
            }
        });

        return btn;
    }
}
