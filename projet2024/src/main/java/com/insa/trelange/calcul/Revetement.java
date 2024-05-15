/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insa.trelange.calcul ;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tomrelange
 */
public class Revetement {
    
    
    int idRevetement ;
    static int next_revetement;
    String designation ;
    double prixunitaire ;
    boolean poursol ;
    boolean pourmur ;
    boolean pourplafond ;
    
    private static Map<Integer, Revetement> revPourSolMap = new HashMap<>() ; 
    private static Map<Integer, Revetement> revPourMurMap = new HashMap<>() ;
    private static Map<Integer, Revetement> revPourPlafondMap = new HashMap<>() ;

    public Revetement() {
    }
    
    public Revetement(String designation, boolean poursol, boolean pourmur, boolean pourplafond, double prixunitaire) {
        this.idRevetement = next_revetement++;
        this.designation = designation;
        this.prixunitaire = prixunitaire;
        this.poursol = poursol;
        this.pourmur = pourmur;
        this.pourplafond = pourplafond;
        if (poursol){
            revPourSolMap.put(this.idRevetement, this);
            System.out.println("Sol");
        }
        if (pourmur){
            revPourMurMap.put(this.idRevetement, this);
            System.out.println("Mur");
        }
        if (pourplafond){
            revPourPlafondMap.put(this.idRevetement, this);
            System.out.println("Plafond");
        }
        
        
    }

    public String getDesignation() {
        return designation;
    }

    public void setPrixunitaire(double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public void setPourmur(boolean pourmur) {
        this.pourmur = pourmur;
    }

    public void setPourplafond(boolean pourplafond) {
        this.pourplafond = pourplafond;
    }

    public void setPoursol(boolean poursol) {
        this.poursol = poursol;
    }

    public void setDesignation(String Designation) {
        this.designation = Designation;
    }

    public int getId() {
        return idRevetement;
    }

    public double getPrixunitaire() {
        return prixunitaire;
    }
    
    public boolean isPourSol() {
        return poursol;
    }
    
    public boolean isPourMur() {
        return pourmur;
    }
    
    public boolean isPourPlafond() {
        return pourplafond;
    }

    public static Map<Integer, Revetement> getRevPourMurMap() {
        return revPourMurMap;
    }

    public static Map<Integer, Revetement> getRevPourPlafondMap() {
        return revPourPlafondMap;
    }

    public static Map<Integer, Revetement> getRevPourSolMap() {
        return revPourSolMap;
    }

    
    
    
    
    public static void loadRevetement() throws IOException {
    
        RevetementDatabase.loadFromFile("revetements.txt");
    }

    @Override
    public String toString() {
        return "Revetement{" + "idRevetement=" + idRevetement + ", designation=" + designation + ", prixunitaire=" + prixunitaire + ", poursol=" + poursol + ", pourmur=" + pourmur + ", pourplafond=" + pourplafond + '}';
    }
    
    
}

