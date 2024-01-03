package com.example.gestion_educative.services;

import com.example.gestion_educative.classes.Enseignant;
import com.example.gestion_educative.classes.Etudiant;
import com.example.gestion_educative.classes.Filiere;

import java.util.ArrayList;

public class Etdservices {
    public static Etudiant addEtd(String nom, String prenom, String email, int apogee, Enseignant filiere){
        Etudiant etudiant=new Etudiant();
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setEmail(email);
        etudiant.setApogee(apogee);
        etudiant.setFiliere(filiere);
        BD.etudiants.add(etudiant);
        return  new Etudiant();
    }

    public static Etudiant updateEtd(int id,String nom, String prenom, String email, int apogee, Filiere filiere){
        for (Etudiant etudiant : BD.etudiants) {
            if (etudiant.getId_etu() == id) {
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setApogee(apogee);
                etudiant.setEmail(email);
                etudiant.setFiliere(filiere);
            }
        }
        return  new Etudiant();
    }
    public static ArrayList<Etudiant> deleteEtdById(int id){
        BD.etudiants.remove(getEtdById(id));
        return  BD.etudiants;
    }

    public static Etudiant getEtdById(int id){
        for(Etudiant etudiant:BD.etudiants){
            if(etudiant.getId_etu()==id) return etudiant;
        }
        return new Etudiant();
    }

    public static ArrayList<Etudiant> getAllEtd(){
        return  BD.etudiants;
    }
}
