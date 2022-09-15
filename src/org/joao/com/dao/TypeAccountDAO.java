package org.joao.com.dao;

import org.joao.com.model.TypeAccount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeAccountDAO extends DAO<TypeAccount> {
    public TypeAccountDAO() {
        super("enterTypeAccount_sp(?)", "updateTypeAccount_sp(?, ?)", "searchProcedure", "getAllTypeAccounts_sp()", "deleteTypeAccount_s(?)");
    }

    @Override
    protected void setProcedureParams(PreparedStatement sp, TypeAccount typeAccount) throws SQLException {
        sp.setString(1, typeAccount.getNameStateAccount());
        if (typeAccount.getIdStateAccount() == 0) return;
        sp.setInt(2, typeAccount.getIdStateAccount());
    }

    @Override
    public TypeAccount resultSetToObject(ResultSet resultSet) throws SQLException {
        int idTypeAccount = resultSet.getInt(1);
        String nameTypeAccount = resultSet.getString(2);

        return new TypeAccount(idTypeAccount, nameTypeAccount);
    }
}
