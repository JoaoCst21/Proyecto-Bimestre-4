package org.joao.com.view;

import net.miginfocom.swing.MigLayout;
import org.joao.com.view.components.LoginComponent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;

public class StartView extends View {
    private static StartView instance;
    LoginComponent loginComponent;

    public static StartView getInstance() {
        if (instance == null) instance = new StartView();
        return instance;
    }

    private StartView() {
        init();
        setVisible(true);
    }

    @Override
    protected void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;

        setLayout(new MigLayout("fill", "0[]0", "0[]0"));
        // Main panel
        JPanel panel = new JPanel(new MigLayout("fill", "0[]0", "0[]0"));
        panel.setBackground(new Color(25, 26, 27));

        // Components
        JPanel header = new JPanel();
        header.setBackground(Color.RED);

        JPanel login = new JPanel(new MigLayout("fill"));
        login.setBorder(BorderFactory.createCompoundBorder(login.getBorder(), BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        LoginComponent loginComponent = LoginComponent.getInstance();
        loginComponent.setBackground(new Color(33, 36, 36));
        loginComponent.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 5, 0, 0, Color.BLACK),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        ImageIcon image = new ImageIcon(getClass().getResource("../assets/BAC_Credomatic_logo 1.png"));
        JLabel imageLabel = new JLabel(scaleImage(image, width / 4));

        login.add(imageLabel, "grow, alignx center");
        login.add(loginComponent, "align right center, h 100%");
        login.setBackground(new Color(33, 36, 36));

        // Adding Components
        setIconImage(new ImageIcon(getClass().getResource("../assets/BAC_Credomatic_logo_leon.png")).getImage());
        panel.add(login, "pos 25% 16.5%, w 50%, h 50%");
        panel.add(header, "h 25%, growx, align 0 0");

        // adding Main Panel
        add(panel, "grow");
    }
}
