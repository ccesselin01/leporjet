/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insa.ccesselin.calcul;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author 
 */
public class Sol {
    int idSol;
    static int next_Sol; 
    Mur m1,m2,m3,m4 ;
    Revetement revetement;
    private static Map<Integer, Sol> solMap = new HashMap<>() ;
    

    public Sol(Mur m1, Mur m2,Mur m3,Mur m4, Revetement revetement) {
        this.idSol = next_Sol++;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        
        this.revetement = revetement;
        solMap.put(this.getIdSol(), this);
    }
    
    
    public double surface()
    {
        double surface;
        if (m1.surface()==m2.surface()) {
            surface  = m1.surface()*m3.surface();
        } else {
            
            surface = m1.surface()*m2.surface();
            
        }
        
       return surface ;
    }
    
    public double devis_Sol (){
        double devis_sol= this.surface()*this.revetement.prixunitaire;
        return devis_sol;
        
    }

    public int getIdSol() {
        return idSol;
    }

    public Revetement getRevetement() {
        return revetement;
    }
    
    public Mur getM1(){
        return this.m1;
    }
    
    public Mur getM2(){
        return this.m2;
    }
    
    public Mur getM3(){
        return this.m3;
    }
    
    public Mur getM4(){
        return this.m4;
    }
    
    
    
    public static Sol getSol(int idSol){
        return solMap.get(idSol);
    }
    
    

    public static Map<Integer, Sol> getSolMap() {
        return solMap;
    }
    
    
    @Override
    public String toString() {
        return "Sol " + idSol + " " + m1 + " " + m2 + " " + revetement.getId() ;
    }
    
}
