package org.joao.com.dao;

import org.joao.com.model.StateAccount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StateAccountDAO extends DAO<StateAccount> {
    public StateAccountDAO() {
        super("saveProcedure", "updateProcedure", "searchProcedure", "readAllProcedure", "deleteProcedure");
    }

    @Override
    protected void setProcedureParams(PreparedStatement sp, StateAccount stateAccount) throws SQLException {
        sp.setString(1, stateAccount.getStateAccount());
        if (stateAccount.getIdStateAccount() == 0) return;
        sp.setInt(2, stateAccount.getIdStateAccount());
    }

    @Override
    public StateAccount resultSetToObject(ResultSet resultSet) throws SQLException {
        int idStateAccount = resultSet.getInt(1);
        String nameStateAccount = resultSet.getString(2);

        return new StateAccount(idStateAccount, nameStateAccount);
    }
}
