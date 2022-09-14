package org.joao.com.view.tables;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTable;
import java.awt.Color;

public class TableComponent extends JTable {
    public TableComponent(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
        init();
    }

    public void init() {
        setLayout(new MigLayout("fill"));
        setFocusable(false);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setBackground(new Color(255, 0, 0, 200));
        getTableHeader().setForeground(Color.WHITE);
        getTableHeader().setOpaque(false);
        setSelectionBackground(new Color(0, 0, 0, 10));
        setShowHorizontalLines(false);
        setShowVerticalLines(false);

        setDefaultEditor(Object.class, null);
    }
}
