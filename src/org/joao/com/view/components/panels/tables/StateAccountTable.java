package org.joao.com.view.components.panels.tables;

import org.joao.com.model.StateAccount;
import org.joao.com.view.components.PanelTable;

public class StateAccountTable extends PanelTable<StateAccount> {
    public StateAccountTable(StateAccount[] data) {
        super(data, new String[]{"ID", "Estados de Cuenta"}, "Estado de Cuenta");
    }

    @Override
    protected String[] dataToStringArr(StateAccount stateAccount) {
        String idStateAccount = String.valueOf(stateAccount.getIdStateAccount());
        String stateAccountName = stateAccount.getStateAccount();

        return new String[]{idStateAccount, stateAccountName};
    }
}
