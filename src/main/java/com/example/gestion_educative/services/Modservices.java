package com.example.gestion_educative.services;

import com.example.gestion_educative.classes.Enseignant;
import com.example.gestion_educative.classes.Filiere;
import com.example.gestion_educative.classes.Module;

import java.util.ArrayList;

public class Modservices {
    public static Module addModule(String intitule, Enseignant chef, Filiere filiere) {
        Module module=new Module();
        module.getIntitule();
        module.getFiliere();
        module.getChef() ;
        BD.modules.add(module);
        return  new Module();
    }

    public static Module updatemod(int id , String intitule, Enseignant chef, Filiere fil){
        for (Module module : BD.modules) {
            if (module.getId_mod() == id) {
                module.setIntitule(intitule);
                module.setChef(chef);
                module.setFiliere(fil);
                return module;
            }
        }
        return  new Module();
    }
    public static ArrayList<Module> deleteModuleById(int id){
        BD.modules.remove(getModuleById(id));
        return  BD.modules;
    }

    public static Module getModuleById(int id){
        for(Module module:BD.modules){
            if(module.getId_mod()==id) return module;
        }
        return  new Module();
    }

    public static ArrayList<Filiere> getAllFiliere(){

        return  BD.filieres;
    }
}
