package org.joao.com.view.components.panelTable;

import net.miginfocom.swing.MigLayout;
import org.joao.com.model.Transaction;
import org.joao.com.view.tables.TableComponent;

public class TransactionTable extends PanelTable<Transaction> {

    private static TransactionTable instance;

    public static TransactionTable getInstance(Transaction[] data) {
        if (instance == null) instance = new TransactionTable(data);
        instance.updateData(data);
        return instance;
    }

    public static TransactionTable getInstance() {
        return instance;
    }

    private TransactionTable(Transaction[] data) {
        super(data);
    }

    @Override
    protected void init() {
        String[] column;
        setLayout(new MigLayout("fill"));
        column = new String[]{"Enviador", "recibidor", "Provider", "Identificador de Pago", "Descripcion", "monto", "Fecha"};

        String[][] dataString = arrDataToArrStringArr(data);
        table = new TableComponent(dataString, column);
    }

    @Override
    protected String[] dataToStringArr(Transaction transaction) {
        // String id = String.valueOf(transaction.getIdTransaction());
        String sender = String.valueOf(transaction.get_idAccountSender());
        String receiver = String.valueOf(transaction.get_idAccountReceiver());
        String provider = String.valueOf(transaction.get_idProveedor());
        String paymentIdentifier = transaction.getPaymentIdentifier();
        String description = transaction.getDescription();
        String amount = String.valueOf(transaction.getAmount());
        String dateTransaction = String.valueOf(transaction.getDateTransaction());
        return new String[]{sender, receiver, provider, paymentIdentifier, description, amount, dateTransaction};
    }
}
