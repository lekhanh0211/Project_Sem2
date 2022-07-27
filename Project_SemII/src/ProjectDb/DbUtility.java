/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DbUtility {
     public static Connection openConnection() {
        Connection con = null;
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Project_Sem2";
        String user = "sa";
        String password = "1234";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException er) {
        }
        return con;
    }
     public static void main(String[] args) {
         System.out.println(DbUtility.openConnection());
    }
}
