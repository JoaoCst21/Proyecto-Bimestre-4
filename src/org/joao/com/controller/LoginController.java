package org.joao.com.controller;

import org.joao.com.dao.AccountDAO;
import org.joao.com.dao.TransactionDAO;
import org.joao.com.model.Account;
import org.joao.com.model.Transaction;
import org.joao.com.view.MenuView;
import org.joao.com.view.StartView;
import org.joao.com.view.components.LoginComponent;
import org.joao.com.view.pages.ReadPage;

import java.awt.event.ActionListener;

public class LoginController extends ControllerObserver {

    private LoginComponent view;

    @Override
    protected void init() {
        this.view = LoginComponent.getInstance();
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
            MenuView menuView = new MenuView();
            ReadPage readPage = new ReadPage(new TransactionDAO().readAll().toArray(new Transaction[0]), new AccountDAO().readAll().toArray(new Account[0]));
            menuView.add(readPage, "grow");
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
