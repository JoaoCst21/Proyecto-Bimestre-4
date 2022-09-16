package org.joao.com.view.pages;

import net.miginfocom.swing.MigLayout;
import org.joao.com.view.components.panels.forms.AccountForm;
import org.joao.com.view.components.panels.forms.CurrencyForm;
import org.joao.com.view.components.panels.forms.DocumentTypeForm;
import org.joao.com.view.components.panels.forms.PersonForm;
import org.joao.com.view.components.panels.forms.PhoneCompanyForm;
import org.joao.com.view.components.panels.forms.ProviderForm;
import org.joao.com.view.components.panels.forms.StateAccountForm;
import org.joao.com.view.components.panels.forms.TransactionForm;
import org.joao.com.view.components.panels.forms.TypeAccountForm;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class CreatePage extends JInternalFrame {

    public CreatePage() {
        init();
        setVisible(true);
    }

    public void init() {
        setLayout(new MigLayout("fill"));

        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("fill, debug", "0[25%]0", "0[]0[]0[]0[]0"));
        panel.add(new PersonForm(), "grow, span 1 3");
        panel.add(new TransactionForm(), "grow");
        panel.add(new AccountForm(), "grow");
        panel.add(new ProviderForm(), "grow, wrap");
        panel.add(new StateAccountForm(), "grow");
        panel.add(new TypeAccountForm(), "grow");
        panel.add(new DocumentTypeForm(), "grow, wrap");
        panel.add(new CurrencyForm(), "grow");
        panel.add(new PhoneCompanyForm(), "grow");
        add(panel, "align 50% 50%, w 100%, h 90%");
    }
}
