package br.com.customer.factory;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Thiago
 */

public class ConnectionFactory { 
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE = "jdbc:mysql://localhost:3306/thiago_teste";
    
    public static Connection createConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(DATABASE, USERNAME,PASSWORD);

        return connection;
    }
    
    public static void main(String[] args) throws Exception{
        Connection con = createConnection();

        if(con != null){
            System.out.println("Conexão obtida com sucesso!");
            con.close();
        }
    }
}