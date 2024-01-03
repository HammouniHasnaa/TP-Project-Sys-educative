package com.example.gestion_educative.control;
import com.example.gestion_educative.classes.Filiere;
import com.example.gestion_educative.dao.DBconnection;
import com.example.gestion_educative.main.Main;
import com.example.gestion_educative.services.BD;
import com.example.gestion_educative.services.Depservices;
import com.example.gestion_educative.services.Ensservices;
import com.example.gestion_educative.services.Filservices;

public class Filcontrol {
    public static void showMenu() throws Exception {
        System.out.println("-------------------------[ Filiere]---------------------------");
        System.out.println("1: Pour ajouter une Filiere");
        System.out.println("2: Pour afficher les Filieres");
        System.out.println("3: Pour modifier une Filiere");
        System.out.println("4: Pour supprimer une Filiere");
        System.out.println("0: Pour retourner au menu principal");
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createfiliere();
                break;
            case 2:
                showFiliere();
                break;
            case 3:
                editFiliere();
                break;
            case 4:
                destroyFil();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showFiliere(){
        for (Filiere fil : BD.filieres) {
            System.out.print("Id : " + fil.getId());
            System.out.print(" | intitule : " + fil.getIntitule() );
            System.out.print(" | chef : " + fil.getChef());
            System.out.print(" | departement : " + fil.getDept());
            System.out.println("");
        }
    }
    public static void createfiliere() throws Exception {
        DBconnection cx = new DBconnection();
        String intitule = Main.getStringInput("Entrez l'Intitule :");
        Enscontrol.showEnseignants();
        int idchef = Main.getIntInput("selectionner un chef par id:");
        Depcontrol.Show();
        int IDdep = Main.getIntInput("selectionner un dep par id :");
        Filservices.addFiliere(intitule, Ensservices.getEnsById(idchef), Depservices.getDepById(IDdep));
        showFiliere();
        showMenu();

    }
    public static void editFiliere() throws Exception {
        DBconnection cx = new DBconnection();
        showFiliere();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        String intitule = Main.getStringInput("Entrez le nom:");
        Enscontrol.showEnseignants();
       int idchef = Main.getIntInput("selectionner le chef par id:");
        Depcontrol.Show();
        int iddep = Main.getIntInput("Sélecionnez un departement par id :");
        Filservices.updateFiliere(id, intitule, Ensservices.getEnsById(idchef),Depservices.getDepById(iddep));
        showFiliere();
        showMenu();
    }
    public static void destroyFil(){
        showFiliere();
        DBconnection cx = new DBconnection();
        int id = Main.getIntInput("Sélecionnez une filiere par id :");
        Filservices.deleteFiliereById(id);
        showFiliere();
    }

}

