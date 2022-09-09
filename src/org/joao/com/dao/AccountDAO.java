package org.joao.com.dao;

import org.joao.com.dao.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO extends DAO<Account> {
    public AccountDAO() {
        super("saveProcedure", "updateProcedure", "searchProcedure", "readAllProcedure", "deleteProcedure");
    }

    @Override
    protected void setProcedureParams(PreparedStatement sp, Account object) throws SQLException {
        if (object.getIdAccount() == 0) {
            sp.setDouble(1, object.getBalance());
            sp.setInt(2, object.get_propietaryAccountId());
            sp.setInt(3, object.get_currency());
            sp.setInt(4, object.get_typeAccount());
            sp.setInt(5, object.get_stateAccount());
            return;
        }
        sp.setDouble(1, object.getIdAccount());
        sp.setDouble(2, object.getBalance());
        sp.setInt(3, object.get_propietaryAccountId());
        sp.setInt(4, object.get_currency());
        sp.setInt(5, object.get_typeAccount());
        sp.setInt(6, object.get_stateAccount());
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
