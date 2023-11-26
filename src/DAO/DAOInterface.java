package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAOInterface<T> {
    public void createTable();
    public void add(T t);
    public void delete(T t);
    public void update(T t);
    public ArrayList<T> selectAll();
    public T selectById(int id);
    public ArrayList<T> selectByCondition(String condition);
}
