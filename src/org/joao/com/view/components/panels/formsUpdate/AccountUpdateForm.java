package org.joao.com.view.components.panels.formsUpdate;

import org.joao.com.dao.AccountDAO;
import org.joao.com.model.Account;
import org.joao.com.view.components.FormUpdate;

public class AccountUpdateForm extends FormUpdate<Account> {


    public AccountUpdateForm() {
        super(new String[]{"Balance", "id Propietario", "ID Moneda", "ID Tipo de Cuenta", "ID Estado de Cuenta"}, "Modificar Cuenta");
    }

    @Override
    public Account stringArrToObj() {
        int id = Integer.parseInt(buscarInput.getText());
        Double balance = Double.valueOf(inputs.get("Balance").getText());
        int idPropietary = Integer.parseInt(inputs.get("id Propietario").getText());
        int idMoneda = Integer.parseInt(inputs.get("ID Moneda").getText());
        int idTypeAccount = Integer.parseInt(inputs.get("ID Tipo de Cuenta").getText());
        int idStateAccount = Integer.parseInt(inputs.get("ID Estado de Cuenta").getText());

        return new Account(id, balance, idPropietary, idMoneda, idTypeAccount, idStateAccount);
    }

    @Override
    public void updateInDatabase() {
        new AccountDAO().update(stringArrToObj());
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
