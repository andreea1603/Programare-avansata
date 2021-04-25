package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonB {
    public static SingletonB s1= null;
    public Connection conn=null;

    private SingletonB(){
        String url="jdbc:mysql://localhost/REGISTRATION";
        String user="root";
        String pass="";
        Statement st = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url, user, pass);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Conexiune realizata");
    }
    public static SingletonB getInstance()
    {
        if(s1==null)
            s1=new SingletonB();
        return s1;
    }
}