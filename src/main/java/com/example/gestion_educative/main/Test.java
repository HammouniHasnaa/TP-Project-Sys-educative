package com.example.gestion_educative.main;

import com.example.gestion_educative.classes.Departement;
import com.example.gestion_educative.dao.DBconnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;




















public class Test {
    public static void main(String[] args) throws SQLException {
        Connection con = DBconnection.getConnection();
        Statement st=null;
        if (con == null) {
            System.out.printf("connection failed");
        } else {
            System.out.println("connection success");
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cx = DBconnection.getConnection();
            System.out.println("connection success");
            System.out.println("creat table");
            st= cx.createStatement();
            String sql="CREATE TABLE ENSEINGANT"+
                    "(id INTEGER AUTO_INCREMENT PRIMARY KEY,"+
                    "nom VARCHAR(30),"+
                    "prenom VARCHAR(30),"+
                    "PRIMARY KEY(id))";
            st.executeUpdate(sql);
            System.out.println("table created");

        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        }


    }




