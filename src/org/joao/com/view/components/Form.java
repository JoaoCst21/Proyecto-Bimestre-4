package org.joao.com.view.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class Form extends JPanel {
    private final String title;
    protected String[] fields;
    private JButton buttonSubmit;

    public Form(String[] fields, String title) {
        this.fields = fields;
        this.title = title;
        init();
    }

    public void init() {
        setLayout(new MigLayout("fill, debug"));
        System.out.println(fields);
        add(new JLabel("<html><p style = 'font-size: 24px;'>" + title + "</p></html>"), "wrap, align 50% 50%");
        for (String title : fields) {
            PlaceholderTextField text = new PlaceholderTextField(30, title, Color.GRAY);
            text.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            add(text, "wrap, align 50% 50%");
        }
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setForeground(Color.WHITE);
        buttonSubmit.setBackground(new Color(25, 26, 27));
        add(buttonSubmit, "w 280, align 50% 50%");
    }
}
