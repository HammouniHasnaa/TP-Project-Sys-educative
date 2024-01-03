package com.example.gestion_educative.control;

import com.example.gestion_educative.classes.Enseignant;
import com.example.gestion_educative.dao.DBconnection;
import com.example.gestion_educative.main.Main;
import com.example.gestion_educative.services.BD;
import com.example.gestion_educative.services.Depservices;
import com.example.gestion_educative.services.Ensservices;

import java.sql.SQLException;

import static com.example.gestion_educative.dao.BDdepartement.*;

public class Enscontrol {

    public static void showMenu() throws Exception {
        System.out.println("-------------------------[ Enseignant]---------------------------");


        System.out.println("1: Pour ajouter un Enseignant");
        System.out.println("2: Pour afficher les Enseignant");
        System.out.println("3: Pour modifier un Enseignant");
        System.out.println("4: Pour supprimer un Enseignant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }


    public static void showEnseignants(){
        for (Enseignant enseignant : BD.enseignants) {
            System.out.print("Id : " + enseignant.getId_ens());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail() );
            System.out.print(" | Grade : " + enseignant.getGrade() );
            System.out.print(" | dep : " + enseignant.getDept() );

            System.out.println("");
        }
    }
    public static void createEnseignant() throws Exception {
        DBconnection cx = new DBconnection();
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l'email' :");
        String grade= Main.getStringInput("Entrez le grade' :");
        Depcontrol.Show();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
       Ensservices.addEns(nom,prenom,email,grade, Depservices.getDepById(id));

        showEnseignants();
        showMenu();

    }
    public static void editEnseignant() throws Exception {
        DBconnection cx = new DBconnection();
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        String nom = Main.getStringInput("Entrez le nom:");
        String prenom = Main.getStringInput("Entrez le prenom:");
        String email = Main.getStringInput("Entrez l'email:");
        String grade = Main.getStringInput("Entrez le grade:");
        Depcontrol.Show();
        int iddep = Main.getIntInput("Sélecionnez un departement par id :");
        Ensservices.updateEns(id, nom,prenom,email,grade, Depservices.getDepById(iddep));
        //Updatedep(id,nom,prenom,cx);
       showEnseignants();
        showMenu();
    }
    public static void destroyEnseignant(){
        showEnseignants();
        DBconnection cx = new DBconnection();
        int id = Main.getIntInput("Sélecionnez un enseignat par id :");
       Ensservices.deleteEnsById(id);
        showEnseignants();
    }

}
