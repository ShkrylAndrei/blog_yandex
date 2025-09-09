package info.shkryl.levelIsolationTransaction.REPEATABLE_READ;

import info.shkryl.levelIsolationTransaction.utility.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        final java.sql.Connection conn1 = Connection.getConnectionOne();
        conn1.setTransactionIsolation(java.sql.Connection.TRANSACTION_REPEATABLE_READ);
        final java.sql.Connection conn2 = Connection.getConnectionSecond();
        conn2.setTransactionIsolation(java.sql.Connection.TRANSACTION_REPEATABLE_READ);

        // Поток 1
        Thread t1 = new Thread(() -> {
            try (var get = conn1.prepareStatement("SELECT balance FROM accounts WHERE name = 'Alice'")) {
                ResultSet rs = get.executeQuery();
                rs.next();
                Thread.sleep(1000);
                // Попытка обновить
                try (var upd = conn1.prepareStatement("UPDATE accounts SET balance = balance - 100 WHERE name = 'Alice'")) {
                    upd.executeUpdate();
                    conn1.commit(); // ✅ Успех
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } catch (SQLException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // Поток 2 — параллельно
        Thread t2 = new Thread(() -> {
            try (var get = conn2.prepareStatement("SELECT balance FROM accounts WHERE name = 'Alice'")) {
                ResultSet rs = get.executeQuery();
                rs.next();
                Thread.sleep(1000);
                try (var upd = conn2.prepareStatement("UPDATE accounts SET balance = balance - 50 WHERE name = 'Alice'")) {
                    upd.executeUpdate();
                    conn2.commit(); //  Ошибка: could not serialize access
                } catch (SQLException e) {
                    throw new RuntimeException(e);
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
