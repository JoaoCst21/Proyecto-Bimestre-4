package org.joao.com.dao;

import org.joao.com.model.Transaction;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDAO extends DAO<Transaction> {
    public TransactionDAO() {
        super("enterTransactions_sp(?,?,?,?,?,?,?)", "updateTransactions_sp(?,?,?,?,?,?,?,?)", "getTransaction_sp(?)", "getAllTransactions_sp()", "deleteTransaction_sp(?)");
    }

    @Override
    protected void setProcedureParams(PreparedStatement sp, Transaction transaction) throws SQLException {
        sp.setInt(1, transaction.get_idAccountReceiver());
        sp.setInt(2, transaction.get_idAccountSender());
        sp.setInt(3, transaction.get_idProveedor());
        sp.setString(4, transaction.getPaymentIdentifier());
        sp.setString(5, transaction.getDescription());
        sp.setDouble(6, transaction.getAmount());
        sp.setDate(7, (Date) transaction.getDateTransaction());
        if (transaction.get_idProveedor() == 0 && transaction.get_idAccountReceiver() == 0) return;
        if (transaction.get_idProveedor() == 0) sp.setObject(3, null);
        if (transaction.get_idAccountReceiver() == 0) sp.setObject(4, null);


        if (transaction.getIdTransaction() == 0) return;
        sp.setInt(8, transaction.getIdTransaction());
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
        return new Transaction(idTransaction, _idAccountReceiver, _idAccountSender, _idProveedor, paymentIdentifier, description, amount, dateTransaction);
    }

}
