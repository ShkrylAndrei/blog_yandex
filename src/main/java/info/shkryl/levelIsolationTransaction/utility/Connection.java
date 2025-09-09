package info.shkryl.levelIsolationTransaction.utility;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "";

    public static String getUrlForConnection() {
        return "jdbc:postgresql://localhost:5432/LevelIsolationTransaction";
    }
    public static java.sql.Connection getConnectionOne() {
        try {
            java.sql.Connection conn = DriverManager.getConnection(getUrlForConnection(), USERNAME, PASSWORD);
            System.out.println("Подключение к базе установлено!");
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException e) {
            System.err.println("Ошибка подключения: " + e.getMessage());
            throw new RuntimeException("Ошибка подключения.", e);
        }
    }
    public static java.sql.Connection getConnectionSecond() {
        try {
            java.sql.Connection conn = DriverManager.getConnection(getUrlForConnection(), USERNAME, PASSWORD);
            System.out.println("Подключение к базе установлено!");
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException e) {
            System.err.println("Ошибка подключения: " + e.getMessage());
            throw new RuntimeException("Ошибка подключения.", e);
        }
    }
}
