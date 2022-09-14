package org.joao.com.view.forms;

import net.miginfocom.swing.MigLayout;
import org.joao.com.view.components.PlaceholderTextField;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;

public class Form extends JPanel {
    String[] fields;

    public Form (String[] fields) {
        init();
        this.fields = fields;
    }

    public void init() {
        setLayout(new MigLayout("fill"));
        for (String title : fields) {
            PlaceholderTextField text = new PlaceholderTextField(30, title, Color.GRAY);
            text.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            add(text, "wrap, align 50% 50%");
        }
    }
}
