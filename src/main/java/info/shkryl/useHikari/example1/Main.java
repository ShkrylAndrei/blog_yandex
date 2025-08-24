package info.shkryl.useHikari.example1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DataSourceUtil.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR)");
            System.out.println("✅ Таблица создана");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
