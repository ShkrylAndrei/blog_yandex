package info.shkryl.levelIsolationTransaction.READ_UNCOMMITTED;

import info.shkryl.levelIsolationTransaction.utility.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        final java.sql.Connection conn1 = Connection.getConnectionOne();
        conn1.setTransactionIsolation(java.sql.Connection.TRANSACTION_READ_COMMITTED);
        final java.sql.Connection conn2 = Connection.getConnectionSecond();
        conn2.setTransactionIsolation(java.sql.Connection.TRANSACTION_READ_COMMITTED);

        // Поток 1 — Alice снимает 200, но ещё не зафиксировала
        Thread t1 = new Thread(() -> {
            try (PreparedStatement ps = conn1
                    .prepareStatement("UPDATE accounts SET balance = balance - 200 WHERE name = 'Alice'")) {
                ps.executeUpdate();
                Thread.sleep(2000); // Делаем паузу
                conn1.rollback(); // Откатываем
            } catch (SQLException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // Поток 2 — Bob читает баланс Alice ДО фиксации
        Thread t2 = new Thread(() -> {
            try (PreparedStatement ps = conn2.prepareStatement("SELECT balance FROM accounts WHERE name = 'Alice'")) {
                Thread.sleep(1000);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    System.out.println("Bob видит баланс Alice: " + rs.getBigDecimal(1)); // 800!
                }
            } catch (SQLException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        // Ждём завершения обоих потоков, чтобы main не завершился раньше
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            conn1.close();
            conn2.close();
            System.out.println("Соединения закрыты.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
