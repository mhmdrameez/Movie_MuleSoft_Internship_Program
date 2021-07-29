package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertApp {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/sql/movies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

   
    public void insert(String name, double capacity) {
        String sql = "INSERT INTO movies(name,actor,actress,director,year) VALUES(?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, actor);
            pstmt.setString(3, actress);
            pstmt.setString(4, director);
            pstmt.setInteger(5, year);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        // insert three new rows
        app.insert("Raw Materials", 3000);
        app.insert("Semifinished Goods", 4000);
        app.insert("Finished Goods", 5000);
    }

}