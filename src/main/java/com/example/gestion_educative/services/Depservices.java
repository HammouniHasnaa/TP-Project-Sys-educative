package com.example.gestion_educative.services;

import com.example.gestion_educative.classes.Departement;
import com.example.gestion_educative.classes.Enseignant;

import java.sql.SQLException;
import java.util.ArrayList;

public class Depservices {
    public static Departement addDep(String intitule, Enseignant... chef) throws SQLException {
    Departement departement=new Departement();
    departement.setIntitule(intitule);
    departement.setId(BD.getDep_id());
    if(chef.length>0){
        departement.setChef(chef[0]);
    }
    BD.departements.add(departement);
    return departement;
    }
    public static Departement updateDep(int id , String intitule, Enseignant... chef) {
        for (Departement departement : BD.departements) {
            if (departement.getId() == id) {
                departement.setIntitule(intitule);
                if (chef.length > 0) {
                    departement.setChef(chef[0]);
                }
                return departement;
            }
        }
        return new Departement();
    }
    public static Departement getdep(int id){
        for(Departement departement:BD.departements){
            if(departement.getId()==id) return departement;
        }
        return new Departement();
    }
    public static ArrayList<Departement> deleteDept(int id){
        BD.departements.remove(getdep(id));
        return BD.departements ;
    }
    public static Departement getDepById(int id){
        for (Departement dep : BD.departements) {
            if (dep.getId() == id) return dep;
        }
        return  new Departement();
    }
    public static ArrayList<Departement> getAllDept(){

        return  BD.departements;
    }

}

