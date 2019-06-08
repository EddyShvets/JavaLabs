package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private Connection conn;
    private final static String DATABASE_FILE_NAME = "/java.db";

    public Database() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String databasePath = getClass().getResource(DATABASE_FILE_NAME)
                .getPath()
                .replace("%20", " ");

        String url = "jdbc:sqlite:" + databasePath;

        try {
            conn = DriverManager.getConnection(url);
            //System.out.println("Connection to SQLite has been established.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
}
