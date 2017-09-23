/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import br.com.customer.factory.ConnectionFactory;
import br.com.customer.model.Customer;
/**
 *
 * @author Thiago
 */
public class customerDAO {
    public void save(Customer customer){

        String query = "INSERT INTO tb_customer_account (cpf_cnpj,nm_customer, is_active, vl_total)";
        query+= " VALUES(?,?,?,?)";

        Connection connection = null;
        PreparedStatement preparedStm = null;

        try{
            connection = ConnectionFactory.createConnection();  
            preparedStm = connection.prepareStatement(query);
            
            preparedStm.setString(1, customer.getCpf_cnpj());
            preparedStm.setString(2, customer.getNm_customer());
            preparedStm.setBoolean(3, customer.isIs_active());
            preparedStm.setDouble(4, customer.getVl_total());
            
            preparedStm.execute();
     
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(preparedStm != null){
                    preparedStm.close();
                }
                if(connection != null){
                    connection.close();
                }
            }catch(Exception ex){
                ex.printStackTrace();           
            }
        }
    }
}