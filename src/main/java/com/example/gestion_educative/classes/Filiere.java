package com.example.gestion_educative.classes;

import java.util.ArrayList;

public class Filiere {
    private int id_fil;
    private String intitule;
    private Enseignant chef;
    private Departement dept;
    ArrayList<Module> modules=new ArrayList<Module>();
    public Filiere(){

}
    public Filiere( String intitule, Enseignant chef, Departement dept) {

        this.intitule = intitule;
        this.chef = chef;
        this.dept = dept;

    }

    public int getId() {
        return id_fil;
    }

    public void setId(int id) {
        this.id_fil= id;
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

    public Departement getDept() {
        return dept;
    }

    public void setDept(Departement dept) {
        this.dept = dept;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
}
