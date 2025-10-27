package main;

import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatDarculaLaf;

import ui.auth.LoginForm;
import utils.DBConnection;
import java.sql.Connection;

public class SkillSphereApp {

    public static void main(String[] args) {
        System.out.println("Starting SkillSphere Application...");

        // Test database connection
        try (Connection con = DBConnection.getConnection()) {
            if (con != null) {
                System.out.println("Connected to the database successfully.");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Launch GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            try {
                // Set system look and feel
                javax.swing.UIManager.setLookAndFeel(new FlatDarculaLaf());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Open Login Form
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
        });
    }
}
