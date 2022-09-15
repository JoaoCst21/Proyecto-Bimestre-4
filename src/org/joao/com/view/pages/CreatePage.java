package org.joao.com.view.pages;

import net.miginfocom.swing.MigLayout;
import org.joao.com.view.components.panels.forms.AccountForm;
import org.joao.com.view.components.panels.forms.PersonForm;
import org.joao.com.view.components.panels.forms.TransactionForm;

import javax.swing.JInternalFrame;

public class CreatePage extends JInternalFrame {

    public CreatePage() {
        init();
        setVisible(true);
    }

    public void init() {
        setLayout(new MigLayout("fill", "0[]0", "0[]0"));
        add(new PersonForm(), "grow, span 1 2");
        add(new TransactionForm(), "grow");
        add(new AccountForm(), "grow, wrap");
        add(new TransactionForm(), "grow");
        add(new TransactionForm(), "grow");
        add(new TransactionForm(), "grow");
    }
}
