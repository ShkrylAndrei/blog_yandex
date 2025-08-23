package info.shkryl.workWithJDBC.example4;

import java.sql.*;

public class JdbcExampleFourth {
    // URL базы данных: H2 в памяти
    private static String url = "jdbc:h2:mem:testdb"; // база в оперативной памяти
    private static String username = "sa"; // стандартный пользователь H2
    private static String password = "";   // без пароля

    public static void main(String[] args) {
        String selectSql = "SELECT id, name FROM users";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSql)) {

            System.out.println("📋 Список пользователей:");
            while (rs.next()) { // переходим к следующей строке
                int id = rs.getInt("id");      // можно по имени столбца
                String name = rs.getString(2); // или по индексу (1-based)
                System.out.println("ID: " + id + ", Имя: " + name);
            }
        } catch (SQLException e) {
            System.err.println("❌ Ошибка чтения: " + e.getMessage());
        }
    }
}
