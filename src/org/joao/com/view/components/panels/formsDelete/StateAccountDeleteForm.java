package org.joao.com.view.components.panels.formsDelete;

import org.joao.com.dao.StateAccountDAO;
import org.joao.com.model.StateAccount;
import org.joao.com.view.components.FormDelete;

public class StateAccountDeleteForm extends FormDelete<StateAccount> {
    public StateAccountDeleteForm() {
        super(new String[]{"Estado de Cuenta"}, "Eliminar un Estado de Cuenta");
    }

    @Override
    public void deleteInDatabase(int id) {
        new StateAccountDAO().delete(id);
    }

    @Override
    protected String[] dataToStringArr(StateAccount stateAccount) {
        String stateAccountName = stateAccount.getStateAccount();

        return new String[]{stateAccountName};

    }

    @Override
    protected StateAccount searchInDB(int id) {
        return new StateAccountDAO().search(id);
    }
}
