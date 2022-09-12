package org.joao.com.view;

import net.miginfocom.layout.AC;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;

public class LoginView extends JPanel {
    private JButton loginButton;
    private JButton signUpButton;

    private static LoginView instance;

    public static LoginView getInstance() {
        if (instance == null) instance = new LoginView();
        return instance;
    }

    private LoginView() {
        init();
    }

    public void init() {
        // Layout
        setLayout(new MigLayout(new LC().alignY("center").alignX("center"), new AC().gap("0"), new AC().gap("10")));
        setInputs(new String[]{"Usuario", "Contraseña"});

        loginButton = new JButton("Ingresar");
        loginButton.setFocusable(false);
        loginButton.setBackground(Color.RED);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel signUpLabel = new JLabel("No Tienes Cuenta aun?");
        signUpLabel.setForeground(Color.WHITE);

        signUpButton = new JButton("Crear Cuenta");
        signUpButton.setBackground(new Color(25, 26, 27));
        signUpButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFocusable(false);

        add(loginButton, new CC().alignX("center").grow().gapTop("50").wrap());
        add(signUpLabel, new CC().gapTop("20").split(2).gapTop("20"));
        add(signUpButton, new CC().growX());
    }

    public void setInputs(String[] texts) {
        HashMap<String, PlaceholderTextField> textFields = new HashMap<>();

        int i = 1;
        for (String text : texts) {
            textFields.put(text, new PlaceholderTextField(20, text, Color.GRAY));

            textFields.get(text).setForeground(Color.white);
            textFields.get(text).setCaretColor(Color.CYAN);
            textFields.get(text).setBackground(new Color(25, 26, 27));
            textFields.get(text).setBorder(null);
            textFields.get(text).setPreferredSize(new Dimension(PlaceholderTextField.WIDTH, 20));
            textFields.get(text).setBorder(BorderFactory.createCompoundBorder(
                    textFields.get(text).getBorder(),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));


            add(textFields.get(text), new CC().wrap());
            i++;
        }
    }

    // Getters
    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    // Setters
    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public void setSignUpButton(JButton signUpButton) {
        this.signUpButton = signUpButton;
    }
}
