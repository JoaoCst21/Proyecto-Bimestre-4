package org.joao.com.view.components.panels.tables;

import org.joao.com.model.TypeAccount;
import org.joao.com.view.components.PanelTable;

public class TypeAccountTable extends PanelTable<TypeAccount> {
    public TypeAccountTable(TypeAccount[] data) {
        super(data, new String[]{"ID", "Tipos de Cuenta"}, "Tipos de Cuentas");
    }

    @Override
    public String[] dataToStringArr(TypeAccount typeAccount) {
        String idStateAccount = String.valueOf(typeAccount.getIdStateAccount());
        String nameStateAccount = typeAccount.getNameStateAccount();

        return new String[]{idStateAccount, nameStateAccount};
    }
}
