package info.shkryl.useHikari.example2;

import info.shkryl.useHikari.example1.DataSourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    // CREATE
    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO users (id, name) VALUES (?, ?)";
        try (Connection conn = DataSourceUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.executeUpdate();
        }
    }

    // READ (все)
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT id, name FROM users";

        try (Connection conn = DataSourceUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                users.add(user);
            }
        }
        return users;
    }

    // READ by ID
    public User getUserById(int id) throws SQLException {
        String sql = "SELECT id, name FROM users WHERE id = ?";
        try (Connection conn = DataSourceUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    return user;
                }
            }
            return null; // не найден
        }
    }

    // UPDATE
    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET name = ? WHERE id = ?";
        try (Connection conn = DataSourceUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getName());
            pstmt.setInt(2, user.getId());
            return pstmt.executeUpdate() > 0;
        }
    }

    // DELETE
    public boolean deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DataSourceUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        }
    }
}
