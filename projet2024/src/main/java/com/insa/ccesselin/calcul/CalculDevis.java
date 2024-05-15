package com.insa.ccesselin.calcul;

import java.util.Map;

/**
 *
 * @author 
 */

public class CalculDevis {
    
    private Devis devis;
    
    public CalculDevis(){
        devis = new Devis();
    }

    public void getRevetementPrixSurface() {
        
        for (Map.Entry<Integer, Mur> entry : Mur.getmurMap().entrySet()) {
            Integer key = entry.getKey();
            Mur value = entry.getValue();

            devis.ajouterRevetement(value.getRevetement_mur(),value.surface());
        }
        
        System.out.println("Mur fait !");
        
        for (Map.Entry<Integer, Sol> entry : Sol.getSolMap().entrySet()) {
            Integer key = entry.getKey();
            Sol value = entry.getValue();

            devis.ajouterRevetement(value.getRevetement(),value.surface());
        }
        
        System.out.println("Sol fait !");
        
        
        
        for (Map.Entry<Integer, Plafond> entry : Plafond.getplafondMap().entrySet()) {
            Integer key = entry.getKey();
            Plafond value = entry.getValue();

            devis.ajouterRevetement(value.getRevetement(),value.surface());
        }
        
        System.out.println("plafond Fait !");
    }

    public Devis getDevis() {
        return devis;
    }
    
    
}
