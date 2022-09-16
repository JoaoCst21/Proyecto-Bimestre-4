package org.joao.com.view.pages;

import net.miginfocom.swing.MigLayout;
import org.joao.com.view.components.panels.formsUpdate.AccountUpdateForm;
import org.joao.com.view.components.panels.formsUpdate.CurrencyUpdateForm;
import org.joao.com.view.components.panels.formsUpdate.DocumentTypeUpdateForm;
import org.joao.com.view.components.panels.formsUpdate.PersonUpdateForm;
import org.joao.com.view.components.panels.formsUpdate.PhoneCompanyUpdateForm;
import org.joao.com.view.components.panels.formsUpdate.ProviderUpdateForm;
import org.joao.com.view.components.panels.formsUpdate.StateAccountUpdateForm;
import org.joao.com.view.components.panels.formsUpdate.TransactionUpdateForm;
import org.joao.com.view.components.panels.formsUpdate.TypeAccountUpdateForm;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class UpdatePage extends JInternalFrame {
    public UpdatePage() {
        init();
        setVisible(true);
    }

    public void init() {
        setLayout(new MigLayout("fill"));

        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("fill", "0[25%]0", "0[]0[]0[]0[]0"));
        panel.add(new PersonUpdateForm(), "grow, span 1 3");
        panel.add(new TransactionUpdateForm(), "grow");
        panel.add(new AccountUpdateForm(), "grow");
        panel.add(new ProviderUpdateForm(), "grow, wrap");
        panel.add(new StateAccountUpdateForm(), "grow");
        panel.add(new TypeAccountUpdateForm(), "grow");
        panel.add(new DocumentTypeUpdateForm(), "grow, wrap");
        panel.add(new CurrencyUpdateForm(), "grow");
        panel.add(new PhoneCompanyUpdateForm(), "grow");

        add(panel, "align 50% 50%, w 100%");
    }
}
