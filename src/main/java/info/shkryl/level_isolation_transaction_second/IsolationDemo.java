package info.shkryl.level_isolation_transaction_second;

import java.sql.*;

public class IsolationDemo {
    private static final String URL = "jdbc:postgresql://localhost:5432/demo";
    private static final String USER = "postgres";
    private static final String PASSWORD = "";

    private static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        conn.setAutoCommit(false); // важно: управляем транзакциями вручную
        return conn;
    }


    public static void readCommittedDemo() throws SQLException {
        try (Connection conn1 = getConnection();
             Connection conn2 = getConnection()) {

            // Устанавливаем уровень (хотя он и так по умолчанию)
            conn1.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            conn2.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            // Транзакция 1: читает слово
            PreparedStatement stmt1 = conn1.prepareStatement("SELECT translation FROM words WHERE word = 'hello'");
            ResultSet rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                System.out.println("T1 first read: " + rs1.getString(1)); // например, "привет"
            }

            // Транзакция 2: обновляет перевод и коммитит
            PreparedStatement stmt2 = conn2.prepareStatement("UPDATE words SET translation = 'здрасте' WHERE word = 'hello'");
            stmt2.executeUpdate();
            conn2.commit(); // фиксируем изменения

            // Транзакция 1: читает снова
            rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                System.out.println("T1 second read: " + rs1.getString(1)); // "здрасте" — non-repeatable read!
            }

            conn1.rollback();
        }
    }

    public static void repeatableReadDemo() throws SQLException {
        try (Connection conn1 = getConnection();
             Connection conn2 = getConnection()) {

            conn1.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            conn2.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

            // T1: первое чтение
            PreparedStatement stmt1 = conn1.prepareStatement("SELECT translation FROM words WHERE word = 'hello'");
            ResultSet rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                System.out.println("T1 first read: " + rs1.getString(1)); // "привет"
            }

            // T2: обновляет и коммитит
            PreparedStatement stmt2 = conn2.prepareStatement("UPDATE words SET translation = 'хай' WHERE word = 'hello'");
            stmt2.executeUpdate();
            conn2.commit();

            // T1: второе чтение — данные не изменились!
            rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                System.out.println("T1 second read: " + rs1.getString(1)); // всё ещё "привет"
            }

            conn1.commit(); // при коммите всё ок
        }
    }

    public static void serializableDemo() throws SQLException {
        try (Connection conn1 = getConnection();
             Connection conn2 = getConnection()) {

            conn1.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn2.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            // Обе транзакции читают количество слов
            PreparedStatement countStmt1 = conn1.prepareStatement("SELECT COUNT(*) FROM words");
            PreparedStatement countStmt2 = conn2.prepareStatement("SELECT COUNT(*) FROM words");

            ResultSet rs1 = countStmt1.executeQuery();
            rs1.next();
            System.out.println("T1 count: " + rs1.getInt(1));

            ResultSet rs2 = countStmt2.executeQuery();
            rs2.next();
            System.out.println("T2 count: " + rs2.getInt(1));

            // Обе добавляют новое слово
            conn1.prepareStatement("INSERT INTO words (word, translation) VALUES ('new1', 'новое1')").executeUpdate();
            conn2.prepareStatement("INSERT INTO words (word, translation) VALUES ('new2', 'новое2')").executeUpdate();

            // Одна из транзакций завершится успешно, другая — выбросит исключение при commit!
            conn1.commit(); // допустим, прошла
            try {
                conn2.commit(); // может выбросить:
                // org.postgresql.util.PSQLException: ERROR: could not serialize access due to read/write dependency
            } catch (SQLException e) {
                System.out.println("T2 failed: " + e.getMessage());
                conn2.rollback();
            }
        }
    }
}
