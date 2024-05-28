/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insa.ccesselin01.calcul;

/**
 *
 * @author ccesselin01
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RevetementDatabase {
    private static Map<Integer, Revetement> revetements = new HashMap<>();

    public static Revetement get_Revetement(int id) { //TEST
        return revetements.get(id);
    } 
    //TESTprivate static List<Revetement> revetements = new ArrayList<Revetement>() ;
    //private int nextId = 1; // le prochain identifiant à utiliser
    //public static Map<Integer, Revetement> idrevMap = new HashMap<>() ; TEST
    
    /*public RevetementDatabase() {
        // Ajouter des exemples de produits à la base de données
        revetements.add(new Revetement("Revêtement de sol en bois franc", true,false,false, 7.99));
        
    }*/ //à enlever?
    public static void loadFromFile (String filename) throws IOException {
        
        try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                int id = Integer.parseInt(fields[0]);
                String denomination = fields[1];
                boolean pourMur  = fields[2].equals("1");
                boolean pourSol = fields[3].equals("1");
                boolean pourPlafond = fields[4].equals("1");
                double prixUnitaire = Double.parseDouble(fields[5]);
                //revetements.add(new Revetement(denomination, pourSol, pourMur, pourPlafond, prixUnitaire));
                //TESTrevetements.add(new Revetement(id,denomination, pourSol, pourMur, pourPlafond, prixUnitaire));
                Revetement rev = new Revetement(id, denomination, pourSol, pourMur, pourPlafond, prixUnitaire);
                revetements.put(id, rev); //TEST
                System.out.println(" Lecture faite ");
            }
            System.out.println(revetements.get(48));
            // ERREUR : le sol est avant le mur c pas bon??
 
        }
        catch(FileNotFoundException err){
        System.out.println( "Erreur :le fichier n’existe pas!\n "+err);}
        catch (IOException err){
        System.out.println(" Erreur :\n "+err);}
        
    }
    
    /*public static Revetement get_Revetement(int IDrevetement) TEST
    {
        return revetements.get(IDrevetement);
        
    }*/
    
    
    /*public void saveToFile(String filename) throws IOException { TEST
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Revetement revetement : revetements) {
                writer.write(revetement.getId() + ";" + revetement.getDesignation() + ";" + revetement.getPrixunitaire() + ";" + revetement.isPourSol() + ";" + revetement.isPourMur() + ";" + revetement.isPourPlafond());
                writer.newLine();
            }
        }
    }*/
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<Integer, Revetement> entry : revetements.entrySet()) {
                Revetement revetement = entry.getValue();
                writer.write(revetement.getId() + ";" + revetement.getDesignation() + ";" + revetement.getPrixunitaire() + ";" + (revetement.isPourSol() ? "1" : "0") + ";" + (revetement.isPourMur() ? "1" : "0") + ";" + (revetement.isPourPlafond() ? "1" : "0"));
                writer.newLine();
            }
            System.out.println("Données enregistrées avec succès dans le fichier : " + filename);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement dans le fichier : " + e.getMessage());
        }
    }
    
   /* public List<Revetement> getRevetements() {
        return revetements;
    }*/
}



