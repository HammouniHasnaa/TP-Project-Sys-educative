package com.example.gestion_educative.main;
import com.example.gestion_educative.services.BD;
import com.example.gestion_educative.classes.Enseignant;
import com.example.gestion_educative.control.Depcontrol;
import java.util.Scanner;

public class Main {
    public static boolean isNull(Object ob) {
        return ob == null;
    }
    public static int getIntInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un nombre entier : ";
        if (msg.length > 0)
            message = msg[0];
        System.out.print(message);
        int num = scan.nextInt();
        return num;
    }
    public static String getStringInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un texte : ";
        if (msg.length > 0)
            message = msg[0];
        System.out.print(message);
        String str = scan.nextLine();
        return str;
    }

    public static void showPrincipalMenu() throws Exception {
        System.out.println("-------------------------[ Bienvenu ]---------------------------");


        System.out.println("1: Pour gérer les départements");
        System.out.println("2: Pour gérer les filières");
        System.out.println("3: Pour gérer les enseignants");
        System.out.println("4: Pour gérer les modules");
        System.out.println("5: Pour gérer les étudiants");
        System.out.println("0: Pour sortir");
        int option = getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                Depcontrol.showMenu();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                // code block
        }
    }

    public static void main(String[] args) throws Exception {
        Enseignant enseignant = new Enseignant();
        enseignant.setNom("hasnaa");
        enseignant.setPrenom("hammouni");
        enseignant.setEmail("test@gmail.com");
        enseignant.setGrade("PES");
        enseignant.setId_ens(BD.getEns_id());
        BD.enseignants.add(enseignant);
        showPrincipalMenu();
    }
}

