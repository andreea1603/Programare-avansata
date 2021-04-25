package com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public interface Dao<T> {
    T findById(int id, Connection conn) throws SQLException;
    void insert(Connection conn, int id, String nume ) throws SQLException;
}
