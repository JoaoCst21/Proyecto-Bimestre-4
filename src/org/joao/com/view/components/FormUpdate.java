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

public abstract class FormUpdate<Class> extends JPanel implements ActionListener {
    String title;
    String[] fields;
    JButton buttonSearch;
    JButton buttonSubmit;
    protected HashMap<String, PlaceholderTextField> inputs = new HashMap<>();
    protected PlaceholderTextField buscarInput;
    private JPanel panelForm;

    public FormUpdate(String[] fields, String title) {
        this.title = title;
        this.fields = fields;
        init();
    }

    void init() {
        setLayout(new MigLayout("fill, debug", "3[]3", "3[0]3"));
        System.out.println(fields);
        add(new JLabel("<html><p style = 'font-size: 24px; text-align: center;'>" + title + "</p></html>"), "wrap, align 50% 50%, span 2");
        buttonSearch = new JButton("Search");
        buttonSearch.setBackground(Color.RED);

        buscarInput = new PlaceholderTextField(1, "ID del Registro", Color.GRAY);
        buscarInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panel = new JPanel(new MigLayout("fill", "0[]5[]0", "0[]0"));
        panel.add(new JLabel("ID del registro"), "align 0% 50%, w 40%");
        panel.add(buscarInput, "align 100% 50%, wrap, w 60%");
        add(panel, "align 50% 50%, wrap, w 80%");
        add(buttonSearch, "wrap, align 50% 50%, w 80%");
        buttonSearch.addActionListener(this);
    }

    private void tryConversion() throws Exception {
        try {
            stringArrToObj();
        } catch (Exception e) {
            throw new Exception("Algun Dato no coincide con el tipo Solicitado");
        }
    }

    public abstract Class stringArrToObj();

    public abstract void updateInDatabase();

    protected void validateFields() throws Exception {
        for (Map.Entry<String, PlaceholderTextField> entry : inputs.entrySet()) {
            if (entry.getValue().getText().isEmpty()) throw new Exception("Todos Los datos deben ser llenados");
        }
    }

    protected abstract String[] dataToStringArr(Class obj);

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSubmit) {
            try {
                validateFields();
                tryConversion();
                updateInDatabase();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Create Error", JOptionPane.ERROR_MESSAGE);
            }
            return;
        }

        Class object;
        try {
            object = searchInDB(Integer.parseInt(buscarInput.getText()));
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun registro con ese ID", "Create Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (panelForm != null) {
            String id = buscarInput.getText();
            removeAll();
            init();
            buscarInput.setText(id);
        }

        String[] props = dataToStringArr(object);

        int i = 0;
        for (String text : fields) {
            String prop = props[i];
            inputs.put(text, new PlaceholderTextField(20, text, Color.GRAY));
            inputs.get(text).setText(prop);
            inputs.get(text).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panelForm = new JPanel(new MigLayout("fill", "0[]5[]0", "0[]0"));
            panelForm.add(new JLabel(text), "align 0% 50, w 40%");
            panelForm.add(inputs.get(text), "wrap, align 100% 50%, w 60%");
            add(panelForm, "align 50% 50%, wrap, w 80%");

            i++;
        }

        buttonSubmit = new JButton("Submit");
        buttonSubmit.setForeground(Color.WHITE);
        buttonSubmit.setBackground(new Color(25, 26, 27));
        add(buttonSubmit, "w 80%, align 50% 50%");

        buttonSubmit.addActionListener(this);
        revalidate();
        repaint();
    }

    protected abstract Class searchInDB(int id);
}
