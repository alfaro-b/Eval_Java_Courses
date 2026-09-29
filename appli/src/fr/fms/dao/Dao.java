package fr.fms.dao;

import java.sql.Connection;
import java.util.List;

/** Interface générique définissant les opérations CRUD communes aux DAO.
 * @param <T> type de l'entité manipulée
 */
public interface Dao<T> {
	T findById(int id, Connection connection);
    List<T> findAll(Connection connection);
    void save(T obj, Connection connection);
    void update(T obj, Connection connection);
    void delete(int id, Connection connection);
}
