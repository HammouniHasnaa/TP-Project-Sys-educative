package com.example.gestion_educative.classes;

import java.util.ArrayList;

public class Departement {
    private static int id_dep;
    private static String intitule;
    private static Enseignant chef;
    ArrayList<Filiere> filiere=new ArrayList<Filiere>();
    public Departement(){

    }

    public Departement(String intitule,Enseignant chef) {

        this.intitule = intitule;
        this.chef = chef;

    }

    public static int getId() {
        return id_dep;
    }

    public void setId(int id) {
        this.id_dep = id;
    }

    public static String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public static Enseignant getChef() {
        return chef;
    }

    public void setChef(Enseignant chef) {
        this.chef = chef;
    }

    public ArrayList<Filiere> getFiliere() {
        return filiere;
    }

    public void setFiliere(ArrayList<Filiere> filiere) {
        this.filiere = filiere;
    }
}
