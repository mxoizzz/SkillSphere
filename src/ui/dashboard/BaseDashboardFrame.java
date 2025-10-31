package ui.dashboard;

import javax.swing.*;
import java.awt.*;

public class BaseDashboardFrame extends JFrame {

    protected JPanel contentPanel;
    protected SidebarPanel sidebar;
    protected NavbarPanel navbar;

    public BaseDashboardFrame(String role, String userName) {
        setTitle("SkillSphere | " + role + " Dashboard");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(35, 35, 35));

        // Navbar (top)
        navbar = new NavbarPanel(userName, role);
        add(navbar, BorderLayout.NORTH);

        // Sidebar (left)
        sidebar = new SidebarPanel(role);
        add(sidebar, BorderLayout.WEST);

        // Main content area (center)
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(new Color(45, 45, 45));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(contentPanel, BorderLayout.CENTER);
    }

    protected void setContent(Component panel) {
        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
