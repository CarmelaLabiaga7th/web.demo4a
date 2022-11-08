package com.webshoppe.ecommerce.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.webshoppe.ecommerce.config.AppConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JdbcConnectionManager {

    private static final Logger logger = LogManager.getLogger(JdbcConnectionManager.class);

    public JdbcConnectionManager() {
        try {
            Class.forName(AppConfiguration.getString("jdbc.driver"));
            logger.info("operation=load_jdbc_driver, message=jdbc_driver_loaded_successfully, status=success");

        } catch (ClassNotFoundException e) {
            logger.error("operation=load_jdbc_driver, error_message={}", e.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        try {
            final Connection connection = DriverManager.getConnection(AppConfiguration.getString("jdbc.url"),
                                                                      AppConfiguration.getString("jdbc.username"),
                                                                      AppConfiguration.getString("jdbc.password"));
            logger.info("operation=create_jdbc_connection, message=jdbc_connection_created, status=success");

            return connection;

        } catch (SQLException e) {
            logger.error("operation=create_jdbc_connection, error_message={}", e.getMessage());
            throw e;
        }
    }

}
