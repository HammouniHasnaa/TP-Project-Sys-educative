package com.example.gestion_educative.dao;
import com.example.gestion_educative.classes.Departement;
import com.example.gestion_educative.services.BD;
import java.sql.*;
public class BDdepartement {
    public static void Insertdep(String intetule,int idens,DBconnection cx) throws Exception {
        int rowsInserted =0;
        try {
                Connection connection = DBconnection.getConnection();
                String sql = "INSERT INTO departement (intetule,chef) values(?,?)" ;
                PreparedStatement preparedStatement;
                preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
               // preparedStatement.setInt(1,BD.getDep_id());
                preparedStatement.setString(1, Departement.getIntitule());
               preparedStatement.setString(2, String.valueOf(Departement.getChef().getNom())+String.valueOf(Departement.getChef().getPrenom()));
               preparedStatement.executeUpdate();
                if(rowsInserted>0) {
                    System.out.println("Rows inserted: ");
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    public static void deletedepartement(int id,DBconnection cx) throws SQLException {
        try {
            Connection connection = DBconnection.getConnection();
            System.out.println("suppression...");
            String query = "DELETE  from departement where id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("table supprimee avec succee!!!");
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
public static void Updatedep(int id,String intetule,DBconnection cx){
            try {
                Connection conn = DBconnection.getConnection();
                Statement stmt = conn.createStatement();
                System.out.println("Mise à jour...");
                String sql = "UPDATE departement SET intetule =? WHERE id = ?";
                PreparedStatement stm=conn.prepareStatement(sql);
                stm.setString(1,intetule);
                stm.setInt(2,id);
                stm.executeUpdate(sql);
                System.out.println("La table a été mis à jour avec succès");
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    public static Departement getDepartementById(int id) {
        Connection connection = DBconnection.getConnection();
        Departement departement = null;
        String query = "SELECT id, intetule, chef FROM departements WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, BD.dep_id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    departement = new Departement();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departement;
    }
    public static Departement afficher(int id, DBconnection cx) {

        Departement departement = BDdepartement.getDepartementById(id);

        if (departement != null) {
            System.out.println("Departement details:");
            System.out.println("ID: " + departement.getId());
            System.out.println("Name: " + departement.getIntitule());
        } else {
            System.out.println("Departement not found for ID: " + id);
        }
        return departement;
    }

    }




