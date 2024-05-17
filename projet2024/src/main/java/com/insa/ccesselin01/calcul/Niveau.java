/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insa.ccesselin01.calcul;

import static com.insa.ccesselin01.calcul.Appartement.next_appartement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ccesselin01
 */
public class Niveau {
  int idNiveau ;
  static int next_niveau;
  ArrayList<Appartement> apparts = new ArrayList<>();
  private static Map<Integer, Niveau> niveauMap = new HashMap<>() ;
    
    
    public Niveau(ArrayList<Appartement> apt) {

        this.idNiveau = next_appartement++;
        
            this.apparts = apt;
            niveauMap.put(this.idNiveau, this);
        
        
    }
    public Niveau() {
        this.idNiveau = next_niveau++;
        niveauMap.put(this.idNiveau, this);
    }
    
    public static void addAppartement (int idNiveau, Appartement apt) {

        niveauMap.get(idNiveau).setAppart(apt);
        
    }
    public void setAppart(Appartement apt) {
        this.apparts.add(apt);
    }
   
    public static Map<Integer, Niveau> getNiveauMap() {
        return niveauMap;
    }
    
      
}
