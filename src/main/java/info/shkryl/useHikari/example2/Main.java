package info.shkryl.useHikari.example2;

import info.shkryl.useHikari.example1.DataSourceUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        try {
            // Создаём таблицу (один раз)
            try (Connection conn = DataSourceUtil.getConnection();
                 Statement stmt = conn.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR)");
            }

            // CRUD
            dao.createUser(new User(1, "Анна"));
            dao.createUser(new User(2, "Борис"));

            System.out.println(dao.getAllUsers()); // [User{id=1, name='Анна'}, ...]

            User user = dao.getUserById(1);
            System.out.println("Найден: " + user);

            user.setName("Анна (обновлена)");
            dao.updateUser(user);

            dao.deleteUser(2);
            System.out.println("После удаления: " + dao.getAllUsers());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
