package utils;

import java.awt.*;
import javax.swing.*;
import com.formdev.flatlaf.FlatDarculaLaf;

public class ThemeUtil {

    public static void applyTheme() {
        FlatDarculaLaf.setup();
        UIManager.put("Component.arc", 15);
        UIManager.put("Button.arc", 20);
        UIManager.put("TextComponent.arc", 10);
    }

    // Accent Colors (SkillSphere Brand)
    public static final Color ACCENT_BLUE = new Color(52, 152, 219);
    public static final Color ACCENT_GREEN = new Color(46, 204, 113);
    public static final Color ACCENT_RED = new Color(231, 76, 60);

    // Common Fonts
    public static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 20);
    public static final Font NORMAL_FONT = new Font("Segoe UI", Font.PLAIN, 14);

    // Consistent button style
    public static void stylePrimaryButton(JButton btn, Color bgColor) {
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFont(NORMAL_FONT);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) { btn.setBackground(bgColor.darker()); }
            public void mouseExited(java.awt.event.MouseEvent e) { btn.setBackground(bgColor); }
        });
    }
}
