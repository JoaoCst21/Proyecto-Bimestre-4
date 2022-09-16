package org.joao.com.view.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public abstract class Form<Class> extends JPanel implements ActionListener {
    private final String title;
    protected String[] fields;
    private JButton buttonSubmit;
    protected HashMap<String, PlaceholderTextField> inputs = new HashMap<>();

    public Form(String[] fields, String title) {
        this.fields = fields;
        this.title = title;
        init();
    }

    public void init() {
        setLayout(new MigLayout("fill", "3[]3", "3[]3"));
        System.out.println(fields);
        add(new JLabel("<html><p style = 'font-size: 24px;'>" + title + "</p></html>"), "wrap, align 50% 50%");
        for (String text : fields) {
            inputs.put(text, new PlaceholderTextField(10, text, Color.GRAY));
            inputs.get(text).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            add(inputs.get(text), "wrap, align 50% 50%, w 80%");
        }
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setForeground(Color.WHITE);
        buttonSubmit.setBackground(new Color(25, 26, 27));
        add(buttonSubmit, "w 80%, align 50% 100%");

        buttonSubmit.addActionListener(this);
    }

    private void tryConversion() throws Exception {
        try {
            stringArrToObj();
        } catch (Exception e) {
            throw new Exception("Algun Dato no coincide con el tipo Solicitado");
        }
    }

    public abstract Class stringArrToObj();

    public abstract void saveInDatabase();

    protected void validateFields() throws Exception {
        for (Map.Entry<String, PlaceholderTextField> entry : inputs.entrySet()) {
            if (entry.getValue().getText().isEmpty()) throw new Exception("Todos Los datos deben ser llenados");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            validateFields();
            tryConversion();
            saveInDatabase();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Create Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
