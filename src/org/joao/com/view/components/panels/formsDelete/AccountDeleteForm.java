package org.joao.com.view.components.panels.formsDelete;

import org.joao.com.dao.AccountDAO;
import org.joao.com.model.Account;
import org.joao.com.view.components.FormDelete;

public class AccountDeleteForm extends FormDelete<Account> {
    public AccountDeleteForm() {
        super(new String[]{"Balance", "id Propietario", "ID Moneda", "ID Tipo de Cuenta", "ID Estado de Cuenta"}, "Eliminar Cuenta");
    }

    @Override
    public void deleteInDatabase(int id) {
        new AccountDAO().delete(id);
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

    @Override
    protected Account searchInDB(int id) {
        return new AccountDAO().search(id);
    }
}
