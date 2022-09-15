package org.joao.com.view;

import net.miginfocom.swing.MigLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.Color;
import java.util.HashMap;

public class MenuView extends JFrame {

    JInternalFrame activeFrame;
    HashMap<String, JMenu> menuButtons = new HashMap<>();
    private static MenuView instance;
    public JDesktopPane mainPane;

    public static MenuView getInstance() {
        if (instance == null) instance = new MenuView();
        return instance;
    }

    private MenuView() {
        init();
    }

    public void init() {
        Color bgPrimary = new Color(25, 26, 27);

        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new MigLayout("fill"));
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new MigLayout("debug", "5[]5"));

        String[] titles = new String[]{"Ver", "Crear", "Usuario"};
        for (String title : titles) {
            menuButtons.put(title, new JMenu(title));
            menuBar.add(menuButtons.get(title), "w 5%");
        }
        System.out.println(menuBar.getSelectionModel());
        setJMenuBar(menuBar);
        mainPane = new JDesktopPane();
        mainPane.setLayout(new MigLayout("fill"));
        add(mainPane, "grow");
    }

    public HashMap<String, JMenu> getMenuButtons() {
        return menuButtons;
    }

    public JInternalFrame getActiveFrame() {
        return activeFrame;
    }

    public void setActiveFrame(JInternalFrame activeFrame) {
        this.activeFrame = activeFrame;
    }

    public void setMenuButtons(HashMap<String, JMenu> menuButtons) {
        this.menuButtons = menuButtons;
    }


}
