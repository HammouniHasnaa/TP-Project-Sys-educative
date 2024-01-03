package com.example.gestion_educative.control;

import com.example.gestion_educative.classes.Etudiant;
import com.example.gestion_educative.dao.DBconnection;
import com.example.gestion_educative.main.Main;
import com.example.gestion_educative.services.*;
import static com.example.gestion_educative.control.Depcontrol.showMenu;
public class Etucontrol {
        public static void showMenuEtu() throws Exception {
            System.out.println("-------------------------[ Départements ]---------------------------");
            System.out.println("1: Pour ajouter un Etudiant");
            System.out.println("2: Pour afficher les Etudiants");
            System.out.println("3: Pour modifier un Etudiant");
            System.out.println("4: Pour supprimer un Etudiant");
            System.out.println("0: Pour retourner au menu principal");
            int option = Main.getIntInput("Veuillez sélectionner une option : ");
            switch(option) {
                case 1:
                    createEtudiant();
                    break;
                case 2:
                    showEtd();
                    break;
                case 3:
                    editEtu();
                    break;
                case 4:
                    destroyEtd();
                    break;
                default:
                    Main.showPrincipalMenu();
            }
        }
    public static void showEtd(){
        for (Etudiant etudiant : BD.etudiants) {
            System.out.print("nom : " + etudiant.getNom());
            System.out.print("prenom : " + etudiant.getPrenom());
            System.out.print("email : " + etudiant.getEmail());
            System.out.print("filiere: " + etudiant.getFiliere());
            System.out.print("code apogee : " + etudiant.getApogee());
            System.out.print("note : " + etudiant.getNote());
            System.out.println("");
        }

    }
        public static void createEtudiant() throws Exception {
            DBconnection cx = new DBconnection();
            String nom = Main.getStringInput("Entrez le nom :");
            String prenom = Main.getStringInput("Entrez le prenom :");
            String email = Main.getStringInput("Entrez l'email' :");
            Enscontrol.showEnseignants();
            int id = Main.getIntInput("Sélecionnez un enseignant par id :");
            Etdservices.addEtd(nom,prenom,email, BD.etu_id,Ensservices.getEnsById(id));
            showEtd();
            showMenu();
        }
        public static void editEtu() throws Exception {
            showEtd();
            int id = Main.getIntInput("Sélecionnez un etudiant par id :");
            String nom = Main.getStringInput("Entrez le nom :");
            String prenom = Main.getStringInput("Entrez le prenom :");
            String email = Main.getStringInput("Entrez l'email :");
           Filcontrol.showFiliere();
            int idfil = Main.getIntInput("Sélecionnez une filiere par id :");
           Etdservices.updateEtd(id, nom,prenom, email,BD.etu_id, Filservices.getFiliereById(idfil));
            showEtd();
            showMenu();
        }
        public static void destroyEtd(){
            int id = Main.getIntInput("Sélecionnez un etudiant par id :");
            Etdservices.deleteEtdById(id);
            showEtd();
        }
    }


