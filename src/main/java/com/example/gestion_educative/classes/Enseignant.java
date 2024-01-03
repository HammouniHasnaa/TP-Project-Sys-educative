package com.example.gestion_educative.classes;

import java.util.ArrayList;

public class Enseignant {
    private int id_ens;
    private String nom;
    private String prenom;
    private String email;
    private String grade;
    private Departement dept;
    ArrayList<Module> module_ens=new ArrayList<Module>();
public Enseignant(){

}
    public Enseignant(String nom, String prenom, String email, String grade, Departement dept) {

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.grade = grade;
        this.dept = dept;

    }

    public int getId_ens() {
        return id_ens;
    }

    public void setId_ens(int id_ens) {
        this.id_ens = id_ens;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Departement getDept() {
        return dept;
    }

    public void setDept(Departement dept) {
        this.dept = dept;
    }

    public ArrayList<Module> getModule_ens() {
        return module_ens;
    }

    public void setModule_ens(ArrayList<Module> module_ens) {
        this.module_ens = module_ens;
    }
}
