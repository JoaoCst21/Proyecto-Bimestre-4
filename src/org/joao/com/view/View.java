package org.joao.com.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Image;

public abstract class View extends JFrame {
    protected abstract void init();

    public ImageIcon scaleImage(ImageIcon icon, int w) {
        int nh = icon.getIconHeight() * w / icon.getIconWidth();
        return new ImageIcon(icon.getImage().getScaledInstance(w, nh, Image.SCALE_DEFAULT));
    }
}
