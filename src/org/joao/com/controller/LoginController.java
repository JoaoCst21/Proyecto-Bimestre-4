package org.joao.com.controller;

import org.joao.com.view.MenuView;
import org.joao.com.view.StartView;
import org.joao.com.view.components.LoginForm;

import java.awt.event.ActionListener;

public class LoginController extends ControllerObserver {

    private LoginForm view;

    @Override
    protected void init() {
        this.view = LoginForm.getInstance();
    }

    private ActionListener loginButtonEvent() {
        return e -> {
            System.out.println("WORKSSSSSSSSSSS");
        };
    }

    private ActionListener signUpButtonEvent() {
        return e -> {
            StartView startView = StartView.getInstance();
            startView.dispose();
            MenuView menuView = MenuView.getInstance();
            menuView.setVisible(true);
            MenuController menuController = new MenuController();
            menuController.addReadPage();
        };
    }

    @Override
    public void startSubscription() {
        handleEvent(view.getLoginButton(), loginButtonEvent());
        handleEvent(view.getSignUpButton(), signUpButtonEvent());
    }

    public LoginForm getView() {
        return view;
    }

    public void setView(LoginForm view) {
        this.view = view;
    }
}
