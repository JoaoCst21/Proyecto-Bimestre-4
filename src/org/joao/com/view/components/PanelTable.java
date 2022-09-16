package org.joao.com.view.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

public abstract class PanelTable<Class> extends JPanel {

    private String titleText;
    protected Class[] data;
    protected String[] column;
    protected TableComponent table;

    public PanelTable(Class[] data, String[] column, String titleText) {
        this.data = data;
        this.column = column;
        this.titleText = titleText;
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

    protected void init() {
        setLayout(new MigLayout("fill, debug"));
        String[][] dataString = arrDataToArrStringArr(data);
        JLabel title = new JLabel("<html><p style='font-size: 24px'>" + titleText + "</p</html");
        add(title, "wrap, align 50% 50%");
        table = new TableComponent(dataString, column);
    }

    public abstract String[] dataToStringArr(Class object);

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
