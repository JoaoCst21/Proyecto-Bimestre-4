package org.joao.com.dao;

import org.joao.com.model.PhoneCompany;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneCompanyDAO extends DAO<PhoneCompany> {
    public PhoneCompanyDAO() {
        super("sp_enterPhoneCompany(?)", "sp_updatePhoneCompany(?, ?)", "sp_searchPhoneCompany(?)", "getAllPhoneCompanies_sp()", "sp_deletePhoneCompany(?)");
    }

    @Override
    protected void setProcedureParams(PreparedStatement sp, PhoneCompany phoneCompany) throws SQLException {
        sp.setString(1, phoneCompany.getNameCompany());
        if (phoneCompany.getIdPhoneCompany() == 0) return;
        sp.setInt(2, phoneCompany.getIdPhoneCompany());
    }

    @Override
    public PhoneCompany resultSetToObject(ResultSet resultSet) throws SQLException {
        int idPhoneCompany = resultSet.getInt(1);
        String namePhoneCompany = resultSet.getString(2);

        return new PhoneCompany(idPhoneCompany, namePhoneCompany);
    }
}
