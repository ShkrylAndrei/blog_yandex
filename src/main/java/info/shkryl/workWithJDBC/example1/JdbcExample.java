package info.shkryl.workWithJDBC.example1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcExample {
    public static void main(String[] args) {
        // URL базы данных: H2 в памяти
        String url = "jdbc:h2:mem:testdb"; // база в оперативной памяти
        String username = "sa"; // стандартный пользователь H2
        String password = "";   // без пароля

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("✅ Подключение к базе установлено!");
        } catch (SQLException e) {
            System.err.println("❌ Ошибка подключения: " + e.getMessage());
        }
    }
}
