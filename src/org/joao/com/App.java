package org.joao.com;

import org.joao.com.controller.LoginController;
import org.joao.com.view.StartView;
import org.joao.com.view.View;

public class App {
    public static View run() {
        new LoginController();
        return StartView.getInstance();
    }
}
