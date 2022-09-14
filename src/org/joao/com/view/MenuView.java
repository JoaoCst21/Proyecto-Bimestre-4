package org.joao.com.view;

import net.miginfocom.swing.MigLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.Color;
import java.util.HashMap;

public class MenuView extends JFrame {

    HashMap<String, JMenu> menuButtons = new HashMap<>();

    public MenuView() {
        init();
        setVisible(true);
    }

    public void init() {
        Color bgPrimary = new Color(25, 26, 27);

        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new MigLayout("fill"));
        //        TransactionTable transactionTable = new TransactionTable(new Transaction[]{new Transaction(1, 2, 3, 0, "bla bal", "bla bla", 24.50, new Date()), new Transaction(1, 2, 3, 0, "bla bal", "bla bla", 24.50, new Date())});

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new MigLayout("debug", "5[]5"));

        String[] titles = new String[]{"Ver", "Crear", "Usuario"};
        for (String title : titles) {
            menuButtons.put(title, new JMenu(title));
            menuBar.add(menuButtons.get(title), "w 5%");
        }
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        new MenuView();
    }
}
