package ui.dashboard;

import javax.swing.*;
import java.awt.*;

public class LearnerDashboard extends BaseDashboardFrame {

    public LearnerDashboard(String userName) {
        super("Learner", userName);
        initUI();
    }

    private void initUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(45, 45, 45));

        JLabel welcome = new JLabel("Welcome, Moiz Shaikh"  + " 👋", SwingConstants.CENTER);
        welcome.setFont(new Font("Segoe UI", Font.BOLD, 26));
        welcome.setForeground(Color.WHITE);

        JLabel subText = new JLabel("Here’s your learning progress and new opportunities.", SwingConstants.CENTER);
        subText.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subText.setForeground(Color.LIGHT_GRAY);

        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        centerPanel.setBackground(new Color(45, 45, 45));
        centerPanel.add(welcome);
        centerPanel.add(subText);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        setContent(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LearnerDashboard("Moiz Shaikh").setVisible(true));
    }
}
