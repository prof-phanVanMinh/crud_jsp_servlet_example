/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;
import java.sql.Connection;
import java.sql.*;


/**
 *
 * @author LENOVO
 */
public class ConnectDB {
    private static final String url = "jdbc:mysql://localhost:3306/bookstore";
    private static final String user = "root";
    private static final String password = "admin";
    public static Connection getConnection(){
        Connection conn = null;
        try{
         conn = DriverManager.getConnection(url, user, password);
         System.out.println("Connect DB success!");
        }catch(SQLException ex){
            System.out.println("Connect DB interupt");
        }
        return conn;
    }
}
