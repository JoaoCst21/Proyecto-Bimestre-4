package org.joao.com.controller;

import org.joao.com.view.LoginView;

import java.awt.event.ActionListener;

public class LoginController extends ControllerObserver {

    private LoginView view;

    @Override
    protected void init() {
        this.view = LoginView.getInstance();
    }

    private ActionListener loginButtonEvent() {
        return e -> {
            System.out.println("WORKSSSSSSSSSSS");
        };
    }

    private ActionListener signUpButtonEvent() {
        return e -> {
            System.out.println("YEAHHH");
        };
    }

    @Override
    public void startSubscription() {
        handleEvent(view.getLoginButton(), loginButtonEvent());
        handleEvent(view.getSignUpButton(), signUpButtonEvent());
    }

    public LoginView getView() {
        return view;
    }

    public void setView(LoginView view) {
        this.view = view;
    }
}
