package org.joao.com.dao;

import org.joao.com.model.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO extends DAO<Account> {
    public AccountDAO() {
        super("saveProcedure", "updateProcedure", "searchProcedure", "readAllProcedure", "deleteProcedure");
    }

    @Override
    protected void setProcedureParams(PreparedStatement sp, Account account) throws SQLException {
        sp.setDouble(1, account.getBalance());
        sp.setInt(2, account.get_propietaryAccountId());
        sp.setInt(3, account.get_currency());
        sp.setInt(4, account.get_typeAccount());
        sp.setInt(5, account.get_stateAccount());
        if (account.getIdAccount() == 0) return;
        sp.setDouble(6, account.getIdAccount());
    }

    @Override
    public Account resultSetToObject(ResultSet resultSet) throws SQLException {
        int idAccount = resultSet.getInt(1);
        Double balance = resultSet.getDouble(2);
        int _idPerson = resultSet.getInt(3);
        int _idCurrency = resultSet.getInt(4);
        int _idTypeAccount = resultSet.getInt(5);
        int _idStateAccount = resultSet.getInt(6);

        return new Account(idAccount, balance, _idPerson, _idCurrency, _idTypeAccount, _idStateAccount);
    }
}
