package org.joao.com.view;

import net.miginfocom.layout.AC;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import org.joao.com.view.components.LoginComponent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
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
        setResizable(false);
        setLayout(new MigLayout("fill", "0[]0", "0[]0"));
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        // Main panel
        JLayeredPane panel = new JLayeredPane();
        panel.setBackground(new Color(25, 26, 27));
        panel.setOpaque(true);

        // Components
        JPanel header = new JPanel();
        JPanel login = new JPanel(new MigLayout(new LC().fill(), new AC(), new AC()));
        login.setBorder(BorderFactory.createCompoundBorder(login.getBorder(), BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        loginComponent = LoginComponent.getInstance();
        loginComponent.setBackground(new Color(33, 36, 36));
        loginComponent.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 5, 0, 0, Color.BLACK),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        ImageIcon image = new ImageIcon(getClass().getResource("../assets/BAC_Credomatic_logo 1.png"));
        JLabel imageLabel = new JLabel(scaleImage(image, width / 4));

        login.add(imageLabel, new CC().grow().width("0%").height("0%").alignX("center"));
        login.add(loginComponent, new CC().alignX("right").alignY("center").height("100%"));

        // Style Components
        header.setBounds(0, 0, width, height / 4);
        header.setBackground(Color.RED);
        login.setBounds(width / 4, height / 6, width / 2, height / 2);
        login.setBackground(new Color(33, 36, 36));

        // Adding Components
        setIconImage(new ImageIcon(getClass().getResource("../assets/BAC_Credomatic_logo_leon.png")).getImage());
        panel.add(login);
        panel.add(header);

        // adding Main Panel
        add(panel, "grow");
    }
}
