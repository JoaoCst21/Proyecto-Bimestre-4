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

public abstract class FormDelete<Class> extends JPanel implements ActionListener {
    String title;
    String[] fields;
    JButton buttonSearch;
    JButton buttonDelete;
    protected HashMap<String, PlaceholderTextField> inputs = new HashMap<>();
    protected PlaceholderTextField buscarInput;
    private JPanel panelForm;

    public FormDelete(String[] fields, String title) {
        this.title = title;
        this.fields = fields;
        init();
    }

    void init() {
        setLayout(new MigLayout("fill", "3[]3", "0[0]0"));
        System.out.println(fields);
        add(new JLabel("<html><p style = 'font-size: 24px; text-align: center;'>" + title + "</p></html>"), "wrap, align 50% 50%, span 2");
        buttonSearch = new JButton("Search");
        buttonSearch.setForeground(Color.WHITE);
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

    public abstract void deleteInDatabase(int id);

    protected abstract String[] dataToStringArr(Class obj);

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonDelete) {
            try {
                String id = buscarInput.getText();
                String message = "Estas seguro que deseas eliminar el registro con id " + id;
                String[] responses = {"SI", "NO"};
                int option = JOptionPane.showOptionDialog(null, message, "Seguro?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, responses, 0);
                if (option != 0) return;

                deleteInDatabase(Integer.parseInt(id));
                return;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
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

        String[] props = dataToStringArr(object);

        int i = 0;
        if (panelForm != null) {
            for (String text : fields) {
                String prop = props[i];
                inputs.get(text).setText(prop);

                i++;
            }
            revalidate();
            repaint();
            return;
        }

        panelForm = new JPanel(new MigLayout("fill", "0[]5[]0", "3[]3"));
        for (String text : fields) {
            String prop = props[i];
            inputs.put(text, new PlaceholderTextField(20, text, Color.GRAY));
            inputs.get(text).setDisabledTextColor(Color.BLACK);
            inputs.get(text).setBackground(Color.GRAY);
            inputs.get(text).setText(prop);
            inputs.get(text).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            inputs.get(text).setEnabled(false);
            panelForm.add(new JLabel(text), "align 0% 50, w 40%");
            panelForm.add(inputs.get(text), "wrap, align 100% 50%, w 60%");
            add(panelForm, "align 50% 50%, wrap, w 80%");
            i++;
        }

        buttonDelete = new JButton("Delete");
        buttonDelete.setForeground(Color.WHITE);
        buttonDelete.setBackground(new Color(25, 26, 27));
        add(buttonDelete, "w 80%, align 50% 100%");

        buttonDelete.addActionListener(this);
        revalidate();
        repaint();
    }

    protected abstract Class searchInDB(int id);
}