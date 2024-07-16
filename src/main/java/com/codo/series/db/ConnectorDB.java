package com.codo.series.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectorDB {
    private static ConnectorDB instance;
    private Connection conn;
    private Statement st;

    private ConnectorDB() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/codo-series-db", "root", "");
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectorDB getInstance() {
        if (instance == null) {
            synchronized (ConnectorDB.class) {
                if (instance == null) {
                    instance = new ConnectorDB();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }

    public Statement getStatement() {
        return st;
    }
}
