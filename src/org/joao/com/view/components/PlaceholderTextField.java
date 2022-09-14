package org.joao.com.view.components;

import javax.swing.JTextField;
import javax.swing.text.Document;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class PlaceholderTextField extends JTextField {
    private String placeholder;
    private Color disableColor;

    public PlaceholderTextField(int columns, String placeholder, Color disableColor) {
        super(columns);
        this.placeholder = placeholder;
        this.disableColor = disableColor;
    }

    public PlaceholderTextField(int columns, String placeholder) {
        super(columns);
        this.placeholder = placeholder;
    }

    public PlaceholderTextField() {
    }

    public PlaceholderTextField(
            final Document pDoc,
            final String pText,
            final int pColumns) {
        super(pDoc, pText, pColumns);
    }

    public PlaceholderTextField(final int pColumns) {
        super(pColumns);
    }

    public PlaceholderTextField(final String pText) {
        super(pText);
    }

    public PlaceholderTextField(final String pText, final int pColumns) {
        super(pText, pColumns);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);

        if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        if (disableColor == null) g.setColor(getDisabledTextColor());
        else g.setColor(disableColor);
        g.drawString(placeholder, getInsets().left, pG.getFontMetrics()
                .getMaxAscent() + getInsets().top);
    }

    public void setPlaceholder(final String s) {
        placeholder = s;
    }

}