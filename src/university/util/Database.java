/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lahiru
 */
public class Database {
    
    private final static String dbPath = "jdbc:mysql://localhost/uni_db";
    private final static String dbUsername = "root";
    private final static String dbPassword = "";
    private static Connection connection = null;
    
    private Database(){
        
    }

    // Singleton Design Pattern
    public static Connection openConnection() {
        if(connection != null) {
            return connection;
        } else {
             try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(dbPath, dbUsername, dbPassword);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
       
               // JOptionPane.showMessageDialog(this,"Check your database connection!","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        return connection;
    }
    
}
