package main;

import javax.swing.SwingUtilities;
import utils.DBConnection;
import utils.ThemeUtil;
import ui.auth.LoginForm;
import java.sql.Connection;

public class SkillSphereApp {
    public static void main(String[] args) {
        System.out.println("Starting SkillSphere Application...");

        // Test DB connection
        try (Connection con = DBConnection.getConnection()) {
            System.out.println(con != null ? "Connected to DB successfully." : "Failed to connect to DB.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Launch UI
        SwingUtilities.invokeLater(() -> {
            ThemeUtil.applyTheme();   // 🌙 Initialize FlatDarculaLaf + custom tweaks
            new LoginForm().setVisible(true);
        });
    }
}
