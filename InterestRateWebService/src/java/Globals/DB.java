/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Globals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Shang
 */
public class DB {
    //set up db envorionment
    public static final String dbDriver ="com.mysql.jdbc.Driver"; //db driver type
    public static final String dbName = "moneybucket";  //database name
    public static final String dbUrl ="jdbc:mysql://localhost:3306/"+dbName;
    public static final String dbUsername ="root"; //db username
    public static final String dbPw = "******"; //db password
    
    
    private  Connection conn;
    private PreparedStatement stmt;
    
    //constructor
    public DB(){
        try{
            Class.forName(DB.dbDriver);
            conn = DriverManager.getConnection(DB.dbUrl, DB.dbUsername, DB.dbPw);
        }catch(SQLException e )
        {
            System.out.println("Connection Error!");
            conn = null;
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Connection Error!");
            conn = null;
        }
    }
    //to do query
    public ResultSet query(String sql){
        ResultSet rs = null;
        if(conn!=null){
            try {
                synchronized(this) // synchronize access to stmt
                {
                    stmt = conn.prepareStatement(sql);
                    rs = stmt.executeQuery();   
                }
            } catch (SQLException exc) {
                System.out.println(exc);
            }
        }
        return rs;
    }
    
    //destructor
    protected void finalize() 
            throws Throwable
    {
        //close connection
        if(conn!=null){
            conn.close();
        }
    }
    
}
