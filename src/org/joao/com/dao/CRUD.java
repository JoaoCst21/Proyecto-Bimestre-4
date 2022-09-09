package org.joao.com.dao;

import java.util.ArrayList;

public interface DAO<Class> {
    public void save(Class Object);

    public void update(Class Object);

    public Class search(int idObject);

    public ArrayList<Class> readAll();

    public void delete(Class Object);
}
