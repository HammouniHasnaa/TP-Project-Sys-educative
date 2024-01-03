package com.example.gestion_educative.dao;
import java.sql.*;

public class DBconnection {
    private static final String HOST="localhost";
    private static final int PORT=3306;
    private static final String DB_NAME="gst_educative";
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static Connection connection;
    private ResultSet rs;
    private PreparedStatement pstm;


    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DB_NAME), USERNAME, PASSWORD);
        } catch(SQLException se) {
            se.printStackTrace();
        }
        return connection;
    }

    public void initprepar(String sql){
        try {
            getConnection();
            pstm=connection.prepareStatement(sql);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }

    public ResultSet executeselect() {
       try {
            rs= pstm.executeQuery();
       }catch (Exception ex){
           ex.printStackTrace();
       }
       return rs;
    }








    public static void main(String[] args) {
        Connection con = DBconnection.getConnection();
        if (con == null) {
            System.out.printf("connection failed");
        } else {
            System.out.println("connection success");
        }
    }


    public PreparedStatement prepareStatement(String query) {

        return null;
    }


    public void close() {
    }
}
