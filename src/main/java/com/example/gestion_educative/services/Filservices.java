package com.example.gestion_educative.services;
import com.example.gestion_educative.classes.Filiere;
import com.example.gestion_educative.classes.Enseignant;
import com.example.gestion_educative.classes.Departement;
import java.util.ArrayList;

public class Filservices {
    public static Filiere addFiliere(String intitule, Enseignant chef, Departement dept) {
        Filiere filiere=new Filiere();
        filiere.setIntitule(intitule);
        filiere.setChef(chef);
        filiere.setDept(dept);
        BD.filieres.add(filiere);
        return  new Filiere();
    }

    public static Filiere updateFiliere(int id , String intitule, Enseignant chef, Departement dept){
        for (Filiere filiere : BD.filieres) {
            if (filiere.getId() == id) {
                filiere.setIntitule(intitule);
               filiere.setDept(dept);
               filiere.setChef(chef);
                return filiere;
            }
        }
        return  new Filiere();
    }
    public static ArrayList<Filiere> deleteFiliereById(int id){
        BD.filieres.remove(getFiliereById(id));
        return  BD.filieres;
    }

    public static Filiere getFiliereById(int id){
        for(Filiere filiere:BD.filieres){
            if(filiere.getId()==id) return filiere;
        }
        return  new Filiere();
    }

    public static ArrayList<Filiere> getAllFiliere(){

        return  BD.filieres;
    }
}
