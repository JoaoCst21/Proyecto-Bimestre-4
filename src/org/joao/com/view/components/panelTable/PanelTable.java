package org.joao.com.view.components.panelTable;

import org.joao.com.view.tables.TableComponent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

public abstract class PanelTable<Class> extends JPanel {

    protected Class[] data;
    protected TableComponent table;

    protected PanelTable(Class[] data) {
        this.data = data;
        init();
        addJScrollPane();
    }

    private void addJScrollPane() {
        int cols = table.getColumnModel().getTotalColumnWidth();
        int rows = table.getRowHeight() * table.getRowCount();
        table.setPreferredScrollableViewportSize(new Dimension(cols, rows));

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.getViewport().setBackground(new Color(35, 36, 37, 30));
        add(jScrollPane, "grow");
    }

    protected abstract void init();

    protected abstract String[] dataToStringArr(Class object);

    protected String[][] arrDataToArrStringArr(Class[] transactions) {
        ArrayList<String[]> arrStrings = new ArrayList<>();
        for (Class transaction : transactions)
            arrStrings.add(dataToStringArr(transaction));

        String[][] strings = {{""}};
        return arrStrings.toArray(strings);
    }

    public void updateData(Class[] data) {
        this.data = data;
    }
}
