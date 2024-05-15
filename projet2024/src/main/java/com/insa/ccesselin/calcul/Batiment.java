/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insa.ccesselin.calcul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author
 */
public class Batiment {
   String nomProjet ;
   String idBatiment;
   int nbrNiveaux;
   ArrayList<Niveau> niveaux = new ArrayList<>();
   
   
   

   public Batiment(String idBatiment,String nomProjet, int nbrNiveaux,ArrayList<Niveau> niveaux) {
        
        this.idBatiment = idBatiment;
        this.nbrNiveaux = nbrNiveaux;
        this.nomProjet= nomProjet;
        this.niveaux = niveaux;
        
        
    } 

    public void setNiveaux(ArrayList<Niveau> niveaux) {
        this.niveaux = niveaux;
    }
   
    
    /*
    public double devis_batiment (){
        double devis_bat = 0 ;
        for (int i = 0; i <= niveaux.length - 1; i++) {
            devis_bat = devis_bat + niveaux[i].devis_niveau();
        }
        return devis_bat;
        
    }
*/
    public String getNomProjet() {
        return nomProjet;
    }

    public String getIdBatiment() {
        return idBatiment;
    }
/*
    public static Map<Integer, Batiment> getBatimentMap() {
        return batimentMap;
    }

*/
    
    
    
    
    

    @Override
    public String toString() {
        return "Batiment{" + "idBatiment=" + idBatiment + ", nbrNiveaux=" + nbrNiveaux + ", niveaux=" + niveaux + '}';
    }
   
    
}
