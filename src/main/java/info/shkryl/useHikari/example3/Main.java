package info.shkryl.useHikari.example3;

import info.shkryl.useHikari.example1.DataSourceUtil;
import info.shkryl.useHikari.example2.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<User> findUsersByName(String partialName) throws SQLException {
        String sql = "SELECT id, name FROM users WHERE name LIKE ?";
        List<User> users = new ArrayList<>();

        try (Connection conn = DataSourceUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + partialName + "%"); // поиск по подстроке
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    users.add(new User(rs.getInt("id"), rs.getString("name")));
                }
            }
        }
        return users;
    }
}
