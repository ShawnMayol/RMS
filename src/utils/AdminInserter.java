package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminInserter {

    public static void insertAdmin(Connection conn) {
        // Define admin username, password and role
        String username = "admin";
        String plainPassword = "nimda";
        String role = "admin";

        // Hash the password using PasswordEncryption
        String hashedPassword = PasswordEncryption.hashPassword(plainPassword);

        // SQL query to insert the admin account
        String insertQuery = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
            // Set parameters for the SQL query
            stmt.setString(1, username); // Username
            stmt.setString(2, hashedPassword); // Hashed password
            stmt.setString(3, role); // Role (admin)

            // Execute the query to insert the admin account
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Admin account successfully inserted.");
            } else {
                System.out.println("Failed to insert admin account.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example connection to the database (make sure your db_connect is set up)
        Connection conn = db_connect.connect();

        if (conn != null) {
            // Insert the admin account
            insertAdmin(conn);
        } else {
            System.out.println("Database connection failed.");
        }
    }
}
