package org.joao.com.view.components.panels.tables;

import org.joao.com.model.Account;
import org.joao.com.view.components.PanelTable;

public class AccountTable extends PanelTable<Account> {

    public AccountTable(Account[] data) {
        super(data, new String[]{"ID Cuenta", "saldo", "Propietario", "Moneda", "Tipo de Cuenta", "Estado de Cuenta"}, "Cuentas");
    }

    @Override
    public String[] dataToStringArr(Account account) {
        String idAccount = String.valueOf(account.getIdAccount());
        String balance = String.valueOf(account.getBalance());
        String _propietaryAccountId = String.valueOf(account.get_propietaryAccountId());
        String _currency = String.valueOf(account.get_currency());
        String _typeAccount = String.valueOf(account.get_typeAccount());
        String _stateAccount = String.valueOf(account.get_stateAccount());
        return new String[]{idAccount, balance, _propietaryAccountId, _currency, _typeAccount, _stateAccount};
    }
}
