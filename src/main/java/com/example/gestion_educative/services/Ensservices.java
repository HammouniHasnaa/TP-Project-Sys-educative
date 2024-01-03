package com.example.gestion_educative.services;

import com.example.gestion_educative.classes.Departement;
import com.example.gestion_educative.classes.Enseignant;
import com.example.gestion_educative.classes.Filiere;

import java.util.ArrayList;

public class Ensservices {
    public static Enseignant addEns(String nom, String prenom, String email, String grade, Departement dep){
        Enseignant enseignant=new Enseignant();
        enseignant.setNom(nom);
        enseignant.setPrenom(prenom);
        enseignant.setEmail(email);
        enseignant.setGrade(grade);
        enseignant.setDept(dep);
        BD.enseignants.add(enseignant);
        return new Enseignant();
    }
    public static Enseignant updateEns(int id,String nom, String prenom, String email, String grade, Departement dep) {
        for (Enseignant enseignant : BD.enseignants) {
            if (enseignant.getId_ens() == id) {
                enseignant.setNom(nom);
                enseignant.setPrenom(prenom);
                enseignant.setGrade(grade);
                enseignant.setEmail(email);
                enseignant.setDept(dep);
            }
            }
            return new Enseignant();
        }

    public static ArrayList<Enseignant> deleteEnsById(int id){
        BD.enseignants.remove(getEnsById(id));
        return  BD.enseignants;
    }



    public static Enseignant getEnsById(int id){
        for (Enseignant enseignant : BD.enseignants) {
            if (enseignant.getId_ens() == id) return  enseignant;
        }
        return  new Enseignant();
    }
    public static ArrayList<Enseignant> getAllEns(){
        return  BD.enseignants;
    }

}
