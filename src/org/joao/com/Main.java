package org.joao.com;

import org.joao.com.dao.TransactionDAO;

public class Main {
    public static void main(String[] args) {
        new TransactionDAO().readAll();
    }
}
