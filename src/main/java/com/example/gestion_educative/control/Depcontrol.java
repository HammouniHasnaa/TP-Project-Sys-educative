package com.example.gestion_educative.control;

import com.example.gestion_educative.dao.DBconnection;
import com.example.gestion_educative.services.Depservices;
import com.example.gestion_educative.services.Ensservices;
import com.example.gestion_educative.main.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.gestion_educative.dao.BDdepartement.*;

public class Depcontrol {
    public static void showMenu() throws Exception {
        System.out.println("-------------------------[ Départements ]---------------------------");


        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createDepartement();
                break;
            case 2:
                Show();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyDepartement();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }


    public static void Show() {
        try {
            Connection connection = DBconnection.getConnection();
            String query = "SELECT id, intetule,chef FROM departement";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String intetule = resultSet.getString("intetule");
                        System.out.println("ID : " + id + "| Name : " + intetule);
                    }
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    public static void createDepartement() throws Exception {
        DBconnection cx = new DBconnection();
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        Enscontrol.showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        Depservices.addDep(intitule, Ensservices.getEnsById(id));
           Insertdep(intitule,id,cx);
        Show();
        showMenu();


    }
    public static void editDepartement() throws Exception {
        DBconnection cx = new DBconnection();
        Show();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        Enscontrol.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");
        Depservices.updateDep(id, intitule, Ensservices.getEnsById(idEns));
        Updatedep(id,intitule,cx);
        Show();
        showMenu();
    }
    public static void destroyDepartement(){
        Show();
       DBconnection cx = new DBconnection();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        Depservices.deleteDept(id);
        try {
            deletedepartement(id, cx);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       Show();
    }
}
