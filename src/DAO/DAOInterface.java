package DAO;

import java.util.List;

public interface DAOInterface<T> {
    public void createTable();
    public void add(T t);
    public void delete(T t);
    public void update(T t);
    public List<T> selectAll();
    public T selectById(int id);
    public List<T> selectByCondition(String condition);
}
