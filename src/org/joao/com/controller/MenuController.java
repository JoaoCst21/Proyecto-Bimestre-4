package org.joao.com.controller;

import org.joao.com.dao.AccountDAO;
import org.joao.com.dao.CurrencyDAO;
import org.joao.com.dao.DocumentTypeDAO;
import org.joao.com.dao.PersonDAO;
import org.joao.com.dao.PhoneCompanyDAO;
import org.joao.com.dao.ProveedorDAO;
import org.joao.com.dao.StateAccountDAO;
import org.joao.com.dao.TransactionDAO;
import org.joao.com.dao.TypeAccountDAO;
import org.joao.com.model.Account;
import org.joao.com.model.Currency;
import org.joao.com.model.DocumentType;
import org.joao.com.model.Person;
import org.joao.com.model.PhoneCompany;
import org.joao.com.model.Proveedor;
import org.joao.com.model.StateAccount;
import org.joao.com.model.Transaction;
import org.joao.com.model.TypeAccount;
import org.joao.com.view.MenuView;
import org.joao.com.view.pages.CreatePage;
import org.joao.com.view.pages.DeletePage;
import org.joao.com.view.pages.ReadPage;
import org.joao.com.view.pages.UpdatePage;

import javax.swing.JMenu;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MenuController implements Subscriber<JMenu, MenuListener> {
    private MenuView view;

    public MenuController() {
        init();
        startSubscription();
    }

    protected void init() {
        this.view = MenuView.getInstance();
    }


    private MenuListener deleteMenuListener() {
        return new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                DeletePage deletePage = new DeletePage();
                if (view.getActiveFrame() != null) view.mainPane.remove(view.getActiveFrame());
                view.mainPane.add(deletePage, "grow");
                view.setActiveFrame(deletePage);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        };
    }

    private MenuListener updateMenuListener() {
        return new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                UpdatePage updatePage = new UpdatePage();
                if (view.getActiveFrame() != null) view.mainPane.remove(view.getActiveFrame());
                view.mainPane.add(updatePage, "grow");
                view.setActiveFrame(updatePage);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        };
    }

    private MenuListener createMenuListener() {
        return new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                CreatePage createPage = new CreatePage();
                if (view.getActiveFrame() != null) view.mainPane.remove(view.getActiveFrame());
                view.mainPane.add(createPage, "grow");
                view.setActiveFrame(createPage);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        };
    }

    private MenuListener readMenuListener() {
        return new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                addReadPage();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        };
    }

    @Override
    public void startSubscription() {
        handleEvent(view.getMenuButtons().get("Crear"), createMenuListener());
        handleEvent(view.getMenuButtons().get("Ver"), readMenuListener());
        handleEvent(view.getMenuButtons().get("Modificar"), updateMenuListener());
        handleEvent(view.getMenuButtons().get("Eliminar"), deleteMenuListener());
    }

    @Override
    public void handleEvent(JMenu component, MenuListener event) {
        component.addMenuListener(event);
    }

    public void addReadPage() {
        Transaction[] transactions = new TransactionDAO().readAll().toArray(new Transaction[0]);
        Account[] accounts = new AccountDAO().readAll().toArray(new Account[0]);
        Person[] persons = new PersonDAO().readAll().toArray(new Person[0]);
        Proveedor[] providers = new ProveedorDAO().readAll().toArray(new Proveedor[0]);
        Currency[] currencies = new CurrencyDAO().readAll().toArray(new Currency[0]);
        DocumentType[] documentTypes = new DocumentTypeDAO().readAll().toArray(new DocumentType[0]);
        PhoneCompany[] phoneCompanies = new PhoneCompanyDAO().readAll().toArray(new PhoneCompany[0]);
        StateAccount[] stateAccounts = new StateAccountDAO().readAll().toArray(new StateAccount[0]);
        TypeAccount[] typeAccounts = new TypeAccountDAO().readAll().toArray(new TypeAccount[0]);

        ReadPage readPage = new ReadPage(transactions, accounts, persons, providers, currencies, documentTypes, phoneCompanies, stateAccounts, typeAccounts);
        if (view.getActiveFrame() != null) view.mainPane.remove(view.getActiveFrame());
        view.mainPane.add(readPage, "grow");
        view.setActiveFrame(readPage);
    }
}
