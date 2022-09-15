package org.joao.com.dao;

import org.joao.com.model.Currency;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyDAO extends DAO<Currency> {
    public CurrencyDAO() {
        super("enterCurrency_sp(?)", "updateCurrency_sp(?, ?)", "searchProcedure", "getAllCurrencies_sp()", "deleteCurrency_sp(?)");
    }

    @Override
    protected void setProcedureParams(PreparedStatement sp, Currency currency) throws SQLException {
        sp.setString(1, currency.getCurrencyName());
        if (currency.getIdCurrency() == 0) return;
        sp.setInt(2, currency.getIdCurrency());
    }

    @Override
    public Currency resultSetToObject(ResultSet resultSet) throws SQLException {
        int idCurrency = resultSet.getInt(1);
        String currencyName = resultSet.getString(2);

        return new Currency(idCurrency, currencyName);
    }
}
