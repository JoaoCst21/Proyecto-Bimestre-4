package org.joao.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DAO<Class> implements CRUD<Class> {
    // Attributes
    private final String saveProcedure;
    private final String updateProcedure;
    private final String searchProcedure;
    private final String readAllProcedure;
    private final String deleteProcedure;

    public DAO(String saveProcedure, String updateProcedure, String searchProcedure, String readAllProcedure, String deleteProcedure) {
        this.saveProcedure = saveProcedure;
        this.updateProcedure = updateProcedure;
        this.searchProcedure = searchProcedure;
        this.readAllProcedure = readAllProcedure;
        this.deleteProcedure = deleteProcedure;
    }

    protected PreparedStatement prepareCall(String procedure) throws SQLException {
        return Conexion.getInstance().getConnection().prepareCall("CALL " + procedure);
    }

    protected abstract void setProcedureParams(PreparedStatement sp, Class object) throws SQLException;

    public abstract Class resultSetToObject(ResultSet resultSet) throws SQLException;

    @Override
    public void save(Class object) {
        try {
            PreparedStatement sp = prepareCall(saveProcedure);
            setProcedureParams(sp, object);
            sp.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Class object) {
        try {
            PreparedStatement sp = prepareCall(updateProcedure);
            setProcedureParams(sp, object);
            sp.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Class search(int idObject) {
        try {
            Class object = null;
            PreparedStatement sp = prepareCall(searchProcedure);
            sp.setInt(1, idObject);
            ResultSet resultSet = sp.executeQuery();
            while (resultSet.next()) {
                object = resultSetToObject(resultSet);
            }
            resultSet.close();
            return object;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Class> readAll() {
        final ArrayList<Class> objectList = new ArrayList<>();
        try {
            PreparedStatement sp = prepareCall(readAllProcedure);
            ResultSet resultSet = sp.executeQuery();
            while (resultSet.next()) {
                objectList.add(resultSetToObject(resultSet));
            }
            resultSet.close();
            return objectList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int idObject) {
        try {
            PreparedStatement sp = prepareCall(deleteProcedure);
            sp.setInt(1, idObject);
            sp.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
