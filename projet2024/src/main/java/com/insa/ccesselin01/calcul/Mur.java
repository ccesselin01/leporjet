/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insa.ccesselin01.calcul;

/**
 *
 * @author ccesselin01
 */
import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Mur
{
    
    Coin debut, fin ;
    int idMur ;
    static int next_mur;
    Revetement revetement_mur;
    double hauteur ;
    private static Map<Integer, Mur> murMap = new HashMap<>() ;
    private int nbFenetres ;
    private int nbPortes ;

    // pour prendre en compte portes et fenêtres
    public Mur(Coin debut, Coin fin, Revetement revetement_mur, double hauteur, int nbFenetres, int nbPortes) {
        this.debut = debut;
        this.fin = fin;
        this.revetement_mur = revetement_mur;
        this.hauteur = hauteur;
        this.nbFenetres = nbFenetres;
        this.nbPortes = nbPortes;
        this.idMur = next_mur++;
        murMap.put(this.idMur, this);
        System.out.println("Mur ajouté avec succès");

    }

    public int getNbFenetres() {
        return nbFenetres;
    }

    public int getNbPortes() {
        return nbPortes;
    }
    
    


    public Mur(Coin debut, Coin fin, Revetement revetement,double hauteur ) 
    {
        this.debut = debut;
        this.fin = fin;
        this.idMur = next_mur++;
        this.revetement_mur = revetement;
        
        this.hauteur = hauteur;
        murMap.put(this.idMur, this);
        System.out.println("Mur ajouté avec succès");
        
        
    }
    
    public static Mur getMur(int idMur) {
        return murMap.get(idMur) ;
    }
    
    public double longueur() {
        return Math.sqrt(Math.pow((debut.getX()-fin.getX()),2)+Math.pow(debut.getY()-fin.getY(), 2));
    }
    
    public double surface() { // modifié
        
        return this.longueur()*this.hauteur-(this.nbFenetres*1.20*1.20)-(this.nbPortes*0.90*2.10);
    }

    public Coin getDebut() {
        return debut;
    }

    public Coin getFin() {
        return fin;
    }

    public int getIdMur() {
        return idMur;
    }

    public Revetement getRevetement_mur() {
        return revetement_mur;
    }

    public static Map<Integer, Mur> getmurMap() {
        return murMap;
    }
    
    

    @Override
    public String toString() {
        return "Mur " + idMur + " " +  debut + " " + fin + " " + revetement_mur.getId() + " " + hauteur ;
    }

       
    public double devis_Mur (){
        double devis_mur= this.surface()*this.revetement_mur.prixunitaire;
        return devis_mur;
        
    }
    
   
}
