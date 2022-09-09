package org.joao.com.dao;

import org.joao.com.model.Transaction;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDAO extends DAO<Transaction> {
    public TransactionDAO() {
        super("saveProcedure", "updateProcedure", "searchProcedure", "SELECT * FROM Transactions", "deleteProcedure");
    }

    @Override
    protected void setProcedureParams(PreparedStatement sp, Transaction transaction) throws SQLException {
        if (transaction.getIdTransaction() == 0) {
            sp.setInt(1, transaction.get_idAccountReceiver());
            sp.setInt(2, transaction.get_idAccountSender());
            sp.setInt(3, transaction.get_idProveedor());
            sp.setString(4, transaction.getPaymentIdentifier());
            sp.setString(5, transaction.getDescription());
            sp.setDouble(6, transaction.getAmount());
            sp.setDate(7, (Date) transaction.getDateTransaction());
            return;
        }
        sp.setInt(1, transaction.getIdTransaction());
        sp.setInt(2, transaction.get_idAccountReceiver());
        sp.setInt(3, transaction.get_idAccountSender());
        sp.setInt(4, transaction.get_idProveedor());
        sp.setString(5, transaction.getPaymentIdentifier());
        sp.setString(6, transaction.getDescription());
        sp.setDouble(7, transaction.getAmount());
        sp.setDate(8, (Date) transaction.getDateTransaction());
    }

    @Override
    public Transaction resultSetToObject(ResultSet resultSet) throws SQLException {
        System.out.println(resultSet);
        int idTransaction = resultSet.getInt(1);
        int _idAccountReceiver = resultSet.getInt(2);
        int _idAccountSender = resultSet.getInt(3);
        int _idProveedor = resultSet.getInt(4);
        String paymentIdentifier = resultSet.getString(5);
        String description = resultSet.getString(6);
        Double amount = resultSet.getDouble(7);
        Date dateTransaction = resultSet.getDate(8);

        Transaction xd = new Transaction(idTransaction, _idAccountReceiver, _idAccountSender, _idProveedor, paymentIdentifier, description, amount, dateTransaction);
        System.out.println(xd.toString());
        return xd;
    }
}
