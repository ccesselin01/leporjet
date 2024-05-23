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
import java.util.List;


public class RevetementDatabase {
        
    private static List<Revetement> revetements = new ArrayList<Revetement>() ;
    //private int nextId = 1; // le prochain identifiant à utiliser
    
    
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
                revetements.add(new Revetement(id,denomination, pourSol, pourMur, pourPlafond, prixUnitaire));
                System.out.println(" Lecture faite ");
            }
            // ERREUR : le sol est avant le mur c pas bon??
 
        }
        catch(FileNotFoundException err){
        System.out.println( "Erreur :le fichier n’existe pas!\n "+err);}
        catch (IOException err){
        System.out.println(" Erreur :\n "+err);}
        
    }
    
    public static Revetement get_Revetement(int IDrevetement)
    {
        return revetements.get(IDrevetement);
    }
    
    
    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Revetement revetement : revetements) {
                writer.write(revetement.getId() + ";" + revetement.getDesignation() + ";" + revetement.getPrixunitaire() + ";" + revetement.isPourSol() + ";" + revetement.isPourMur() + ";" + revetement.isPourPlafond());
                writer.newLine();
            }
        }
    }
    
    public List<Revetement> getRevetements() {
        return revetements;
    }

}