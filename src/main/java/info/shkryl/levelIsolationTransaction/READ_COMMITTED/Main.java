package info.shkryl.levelIsolationTransaction.READ_COMMITTED;

import info.shkryl.levelIsolationTransaction.utility.Connection;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        final java.sql.Connection conn1 = Connection.getConnectionOne();
        conn1.setTransactionIsolation(java.sql.Connection.TRANSACTION_READ_COMMITTED);
        final java.sql.Connection conn2 = Connection.getConnectionSecond();
        conn2.setTransactionIsolation(java.sql.Connection.TRANSACTION_READ_COMMITTED);

        // Поток 1: Alice переводит 100 Бобу
        Thread t1 = new Thread(() -> {
            try (
                 PreparedStatement get = conn1
                         .prepareStatement("SELECT balance FROM accounts WHERE name = 'Alice'");
                 PreparedStatement upd = conn1
                         .prepareStatement("UPDATE accounts SET balance = ? WHERE name = 'Alice'")) {

                ResultSet rs = get.executeQuery();
                rs.next();
                BigDecimal balance = rs.getBigDecimal(1); // 1000
                Thread.sleep(1000);
                upd.setBigDecimal(1, balance.subtract(BigDecimal.valueOf(100)));
                upd.executeUpdate();
                conn1.commit();
                BigDecimal newBalance = balance.subtract(BigDecimal.valueOf(100));
                System.out.println("Поток 1: Успешно списал 100. Новый баланс = " + newBalance);
            } catch (SQLException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // Поток 2: Alice переводит 50 Бобу (параллельно)
        Thread t2 = new Thread(() -> {
            try (
                 PreparedStatement get = conn2
                         .prepareStatement("SELECT balance FROM accounts WHERE name = 'Alice'");
                 PreparedStatement upd = conn2
                         .prepareStatement("UPDATE accounts SET balance = ? WHERE name = 'Alice'")) {

                ResultSet rs = get.executeQuery();
                rs.next();
                BigDecimal balance = rs.getBigDecimal(1); // 1000 (!)
                Thread.sleep(1000);
                upd.setBigDecimal(1, balance.subtract(BigDecimal.valueOf(50)));
                upd.executeUpdate();
                conn2.commit();
                BigDecimal newBalance = balance.subtract(BigDecimal.valueOf(50));
                System.out.println("Поток 2: Успешно списал 50. Новый баланс = " + newBalance);
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
