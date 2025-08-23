package info.shkryl.workWithJDBC.example2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExampleSecond {
    public static void main(String[] args) {
        // URL базы данных: H2 в памяти
        String url = "jdbc:h2:mem:testdb"; // база в оперативной памяти
        String username = "sa"; // стандартный пользователь H2
        String password = "";   // без пароля

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(50))";
            stmt.execute(sql); // выполняем DDL-запрос
            System.out.println("✅ Таблица 'users' создана");
        } catch (SQLException e) {
            System.err.println("❌ Ошибка при создании таблицы: " + e.getMessage());
        }
    }
}
