/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insa.ccesselin01.calcul;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ccesselin01
 */

public class Plafond {
    
    Mur m1,m2 ;
    int idplafond;
    static int next_plafond;
    Revetement revetement;
    private static Map<Integer, Plafond> plafondMap = new HashMap<>() ;
    
    
    public Plafond(Mur m1, Mur m2,Mur m3, Mur m4, Revetement revetement)
    {
      this.idplafond = next_plafond++ ;
      this.m1 = m1 ;
      this.m2 = m2 ;
      this.m1 = m3 ;
      this.m2 = m4 ;
      this.revetement = revetement;
      plafondMap.put(this.idplafond, this);
    }
    
    public double surface() 
    {
       return m1.longueur()*m2.longueur() ;
    }  
    
   public double devis_plafond (){
        double devis_plafond= this.surface()*this.revetement.prixunitaire;
        return devis_plafond;
        
    } 

    public int getIdplafond() {
        return idplafond;
    }

    public static Map<Integer, Plafond> getplafondMap() {
        return plafondMap;
    }
    
    public static Plafond getPlafond(int idPlafond){
        
        return plafondMap.get(idPlafond);
        
    }
    
    public Revetement getRevetement() {
        return revetement;
    }

    @Override
    public String toString() {
        return "Plafond " + idplafond + " " + m1 + " " + m2 + " " + revetement.getId() ;
    }
   
}
