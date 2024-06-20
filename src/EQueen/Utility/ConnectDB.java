/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EQueen.Utility;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ConnectDB {
        public static Connection getJDBCConnection(){
            String url="jdbc:mysql://localhost:3306/chess";
            String user="root";
            String password="sa2008";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                try {
                    return DriverManager.getConnection(url, user, password);
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

    public static void saveData(String name, int size, int number, String state) throws SQLException {
        Connection conn = getJDBCConnection();
        String query = "INSERT INTO chess.table (name, size, number, state, date) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);

        // Set values for prepared statement parameters
        ps.setString(1, name);
        ps.setInt(2, size);
        ps.setInt(3, number);
        ps.setString(4, state);
        ps.setTimestamp(5, new java.sql.Timestamp(new Date().getTime())); 
        
        ps.executeUpdate(); // Execute the update query

        ps.close();
        conn.close();
      }
   
    public static void main(String[] args) throws SQLException {
        //saveData("Queen", 9, 1, "Done");
        Connection conn = getJDBCConnection();
        java.sql.Statement stmt = conn.createStatement();

        String query = "SELECT * FROM chess.table";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int size = rs.getInt("size");
            int number = rs.getInt("number");
            String state = rs.getString("state");
            // Process retrieved data
            System.out.println("ID: " + id + ", Name: " + name + ", Size: " + size + ", Number: " + number + ", State: " + state);
        }

        rs.close();
        stmt.close();
        conn.close();
    }
        
}
