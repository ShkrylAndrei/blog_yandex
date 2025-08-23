package info.shkryl.workWithJDBC.example3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcExampleThird {
    public static void main(String[] args) {
        // URL базы данных: H2 в памяти
        String url = "jdbc:h2:mem:testdb"; // база в оперативной памяти
        String username = "sa"; // стандартный пользователь H2
        String password = "";   // без пароля

        String insertSql = "INSERT INTO users (id, name) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {

            pstmt.setInt(1, 1);           // первый параметр — id
            pstmt.setString(2, "Анна");   // второй — name
            pstmt.executeUpdate();        // выполнить вставку

            pstmt.setInt(1, 2);
            pstmt.setString(2, "Борис");
            pstmt.executeUpdate();

            System.out.println("✅ Данные добавлены");
        } catch (SQLException e) {
            System.err.println("❌ Ошибка вставки: " + e.getMessage());
        }
    }
}
