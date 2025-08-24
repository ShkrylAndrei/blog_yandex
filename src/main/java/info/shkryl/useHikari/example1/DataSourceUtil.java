package info.shkryl.useHikari.example1;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtil {
    private static HikariDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:h2:mem:testdb"); // URL базы
            config.setUsername("sa");
            config.setPassword("");
            config.setMaximumPoolSize(10);        // макс. 10 соединений
            config.setConnectionTimeout(2000);    // таймаут 2 сек
            config.setIdleTimeout(30000);
            config.setMaxLifetime(45000);

            dataSource = new HikariDataSource(config);
        }
        return dataSource;
    }

    // Получаем соединение из пула
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}