package org.joao.com.view.pages;

import net.miginfocom.swing.MigLayout;
import org.joao.com.view.components.panels.formsDelete.AccountDeleteForm;
import org.joao.com.view.components.panels.formsDelete.CurrencyDeleteForm;
import org.joao.com.view.components.panels.formsDelete.DocumentTypeDeleteForm;
import org.joao.com.view.components.panels.formsDelete.PersonDeleteForm;
import org.joao.com.view.components.panels.formsDelete.PhoneCompanyDeleteForm;
import org.joao.com.view.components.panels.formsDelete.ProviderDeleteForm;
import org.joao.com.view.components.panels.formsDelete.StateAccountDeleteForm;
import org.joao.com.view.components.panels.formsDelete.TransactionDeleteForm;
import org.joao.com.view.components.panels.formsDelete.TypeAccountDeleteForm;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class DeletePage extends JInternalFrame {
    public DeletePage() {
        init();
        setVisible(true);
    }

    public void init() {
        setLayout(new MigLayout("fill"));

        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("fill, debug", "0[25%]0", "0[]0"));
        panel.add(new PersonDeleteForm(), "grow, span 1 3");
        panel.add(new TransactionDeleteForm(), "grow");
        panel.add(new AccountDeleteForm(), "grow");
        panel.add(new ProviderDeleteForm(), "grow, wrap");
        panel.add(new StateAccountDeleteForm(), "grow");
        panel.add(new TypeAccountDeleteForm(), "grow");
        panel.add(new CurrencyDeleteForm(), "grow, wrap");
        panel.add(new DocumentTypeDeleteForm(), "grow");
        panel.add(new PhoneCompanyDeleteForm(), "grow");

        add(panel, "align 50% 50%, w 100%");

    }
}
