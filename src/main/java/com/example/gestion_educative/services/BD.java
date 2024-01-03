package com.example.gestion_educative.services;

import com.example.gestion_educative.classes.Departement;
import com.example.gestion_educative.classes.Filiere;
import com.example.gestion_educative.classes.Enseignant;
import com.example.gestion_educative.classes.Etudiant;
import com.example.gestion_educative.classes.Module;
import com.example.gestion_educative.classes.Note;

import java.util.ArrayList;

public class BD {
   public static int dep_id;
   public static int ens_id;
   public static int fil_id;
   public static int mod_id;
   public static int etu_id;
   public static ArrayList<Departement> departements=new ArrayList<Departement>();
    public static ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
    public static ArrayList<Filiere> filieres = new ArrayList<Filiere>();
    public static ArrayList<Module> modules = new ArrayList<Module>();
    public static ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
    public static ArrayList<Note> notes = new ArrayList<Note>();

 public static int getDep_id() {
  dep_id++;
  return dep_id;
 }

 public static int getEns_id() {
  ens_id++;
  return ens_id;
 }
}
