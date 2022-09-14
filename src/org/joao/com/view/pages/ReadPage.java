package org.joao.com.view.pages;

import net.miginfocom.swing.MigLayout;
import org.joao.com.model.Account;
import org.joao.com.model.Transaction;
import org.joao.com.view.components.panelTable.AccountTable;
import org.joao.com.view.components.panelTable.TransactionTable;

import javax.swing.JInternalFrame;

public class ReadPage extends JInternalFrame {
    Transaction[] transactions;
    Account[] accounts;

    public ReadPage(Transaction[] transactions, Account[] accounts) {
        this.transactions = transactions;
        this.accounts = accounts;
        init();
        setVisible(true);
    }

    public void init() {
        setLayout(new MigLayout("fill"));
        add(TransactionTable.getInstance(transactions), "align 0 0, split 2, growx");
        add(AccountTable.getInstance(accounts), "align 0 0, growx");
    }
}
