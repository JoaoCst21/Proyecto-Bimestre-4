package org.joao.com.view.pages;

import net.miginfocom.swing.MigLayout;
import org.joao.com.model.Account;
import org.joao.com.model.Currency;
import org.joao.com.model.DocumentType;
import org.joao.com.model.Person;
import org.joao.com.model.PhoneCompany;
import org.joao.com.model.Proveedor;
import org.joao.com.model.StateAccount;
import org.joao.com.model.Transaction;
import org.joao.com.model.TypeAccount;
import org.joao.com.view.components.panels.tables.AccountTable;
import org.joao.com.view.components.panels.tables.CurrencyTable;
import org.joao.com.view.components.panels.tables.DocumentTypeTable;
import org.joao.com.view.components.panels.tables.PersonTable;
import org.joao.com.view.components.panels.tables.PhoneCompanyTable;
import org.joao.com.view.components.panels.tables.ProviderTable;
import org.joao.com.view.components.panels.tables.StateAccountTable;
import org.joao.com.view.components.panels.tables.TransactionTable;
import org.joao.com.view.components.panels.tables.TypeAccountTable;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class ReadPage extends JInternalFrame {
    private final Person[] persons;
    private final Proveedor[] proveedors;
    private final Currency[] currencies;
    private final DocumentType[] documentTypes;
    private final PhoneCompany[] phoneCompanies;
    private final StateAccount[] stateAccounts;
    private final TypeAccount[] typeAccounts;
    Transaction[] transactions;
    Account[] accounts;

    public ReadPage(Transaction[] transactions, Account[] accounts, Person[] persons, Proveedor[] proveedors, Currency[] currencies, DocumentType[] documentTypes, PhoneCompany[] phoneCompanies, StateAccount[] stateAccounts, TypeAccount[] typeAccounts) {
        this.transactions = transactions;
        this.accounts = accounts;
        this.persons = persons;
        this.proveedors = proveedors;
        this.currencies = currencies;
        this.documentTypes = documentTypes;
        this.phoneCompanies = phoneCompanies;
        this.stateAccounts = stateAccounts;
        this.typeAccounts = typeAccounts;
        init();
        setVisible(true);
    }

    public void init() {
        setLayout(new MigLayout("fill", "0[]0", "0[]0"));
        JPanel panel = new JPanel(new MigLayout("fillx"));
        panel.add(new AccountTable(accounts), "align 10 10, growx");
        panel.add(new TransactionTable(transactions), "align 10 10, growx, wrap");
        panel.add(new PersonTable(persons), "growx, span 2, wrap");
        panel.add(new CurrencyTable(currencies), "grow, split 2");
        panel.add(new DocumentTypeTable(documentTypes), "grow");
        panel.add(new PhoneCompanyTable(phoneCompanies), "grow, split 2");
        panel.add(new StateAccountTable(stateAccounts), "grow, wrap");
        panel.add(new TypeAccountTable(typeAccounts), "grow");
        panel.add(new ProviderTable(proveedors), "grow, wrap");

        add(panel, "growx, align 0 50%");
    }
}
