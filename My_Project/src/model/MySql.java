/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class MySql {
    
    
     private static Connection connection;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "MawaNtha5@Deeganu";
    private static final String DATABASE = "jwellary_shop";
    
    private static Statement createConnection() throws Exception{
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DATABASE,USERNAME,PASSWORD);
        }
        return connection.createStatement();
    }
    
    public static void iud(String query) throws Exception{
        try{
            createConnection().executeUpdate(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static ResultSet search(String query) throws Exception{
        return createConnection().executeQuery(query);
    }
    
    public static Connection getConnection(){
        if(connection == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DATABASE,USERNAME,PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    
    
}
