package org.joao.com.controller;

import org.joao.com.view.MenuView;
import org.joao.com.view.StartView;
import org.joao.com.view.components.LoginComponent;

import java.awt.event.ActionListener;

public class LoginController extends ControllerObserver {

    private LoginComponent view;

    @Override
    protected void init() {
        this.view = LoginComponent.getInstance();
    }

    private ActionListener loginButtonEvent() {
        return e -> {
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

    public LoginComponent getView() {
        return view;
    }

    public void setView(LoginComponent view) {
        this.view = view;
    }
}
