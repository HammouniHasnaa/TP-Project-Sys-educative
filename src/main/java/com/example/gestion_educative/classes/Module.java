package com.example.gestion_educative.classes;

public class Module {
    private int id_mod;
    private String intitule;
    private Enseignant chef;
    private Filiere filiere;

    public Module() {
    }

    public Module(int id_mod, String intitule, Enseignant chef, Filiere filiere) {
        this.id_mod = id_mod;
        this.intitule = intitule;
        this.chef = chef;
        this.filiere = filiere;
    }

    public int getId_mod() {
        return id_mod;
    }

    public void setId_mod(int id_mod) {
        this.id_mod = id_mod;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getChef() {
        return chef;
    }

    public void setChef(Enseignant chef) {
        this.chef = chef;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
}
