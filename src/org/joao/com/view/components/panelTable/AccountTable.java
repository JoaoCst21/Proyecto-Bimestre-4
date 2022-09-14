package org.joao.com.view.components.panelTable;

import net.miginfocom.swing.MigLayout;
import org.joao.com.model.Account;
import org.joao.com.view.tables.TableComponent;

public class AccountTable extends PanelTable<Account> {

    private static AccountTable instance;

    public static AccountTable getInstance(Account[] data) {
        if (instance == null) instance = new AccountTable(data);
        instance.updateData(data);
        return instance;
    }

    public static AccountTable getInstance() {
        return instance;
    }

    protected AccountTable(Account[] data) {
        super(data);
    }

    @Override
    protected void init() {
        String[] column;
        setLayout(new MigLayout("fill, debug"));
        column = new String[]{"saldo", "Propietario", "Moneda", "Tipo de Cuenta", "Estado de Cuenta"};

        String[][] dataString = arrDataToArrStringArr(data);
        table = new TableComponent(dataString, column);
    }

    @Override
    protected String[] dataToStringArr(Account account) {
        String balance = String.valueOf(account.getBalance());
        String _propietaryAccountId = String.valueOf(account.get_propietaryAccountId());
        String _currency = String.valueOf(account.get_currency());
        String _typeAccount = String.valueOf(account.get_typeAccount());
        String _stateAccount = String.valueOf(account.get_stateAccount());

        return new String[]{balance, _propietaryAccountId, _currency, _typeAccount, _stateAccount};
    }
}
