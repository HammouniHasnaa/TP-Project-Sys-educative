package com.example.gestion_educative.control;
import com.example.gestion_educative.classes.Module;
import com.example.gestion_educative.dao.DBconnection;
import com.example.gestion_educative.main.Main;
import com.example.gestion_educative.services.*;

public class Modcontrol {
    public static void showMenu() throws Exception {
        System.out.println("-------------------------[ Module]---------------------------");
        System.out.println("1: Pour ajouter un module");
        System.out.println("2: Pour afficher les modules");
        System.out.println("3: Pour modifier un module");
        System.out.println("4: Pour supprimer un module");
        System.out.println("0: Pour retourner au menu principal");
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createmodule();
                break;
            case 2:
                showModule();
                break;
            case 3:
                editmodule();
                break;
            case 4:
                destroymodule();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showModule(){
        for (Module mod : BD.modules) {
            System.out.print("Id : " + mod.getId_mod());
            System.out.print(" | intitule : " + mod.getIntitule() );
            System.out.print(" | chef : " + mod.getChef());
            System.out.print(" | FILIERE : " + mod.getFiliere());
            System.out.println("");
        }
    }
    public static void createmodule() throws Exception {
        DBconnection cx = new DBconnection();
        String intitule = Main.getStringInput("Entrez l'Intitule :");
        Enscontrol.showEnseignants();
        int idchef = Main.getIntInput("selectionner un chef par id:");
       Filcontrol.showFiliere();
        int idfil = Main.getIntInput("selectionner une filiere par id :");
        Modservices.addModule(intitule, Ensservices.getEnsById(idchef), Filservices.getFiliereById(idfil));
        showModule();
        showMenu();

    }
    public static void editmodule() throws Exception {
        DBconnection cx = new DBconnection();
        showModule();
        int id = Main.getIntInput("Sélecionnez un module par id :");
        String intitule = Main.getStringInput("Entrez l'intitule':");
        Enscontrol.showEnseignants();
        int idchef = Main.getIntInput("selectionner le chef par id:");
        Filcontrol.showFiliere();
        int idfil = Main.getIntInput("Sélecionnez une filiere par id :");
        Modservices.updatemod(id, intitule, Ensservices.getEnsById(idchef),Filservices.getFiliereById(idfil));
        showModule();
        showMenu();
    }
    public static void destroymodule(){
        showModule();
        DBconnection cx = new DBconnection();
        int id = Main.getIntInput("Sélecionnez un module par id :");
        Modservices.deleteModuleById(id);
        showModule();
    }

}


