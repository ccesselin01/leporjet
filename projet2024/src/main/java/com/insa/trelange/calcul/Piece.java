/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insa.trelange.calcul;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tomrelange
 */
public class Piece {
    
    int idPiece ;
    String nomPiece ;
    static int next_piece;
    Mur m1,m2,m3,m4 ;
    Sol sol;
    Plafond plafond;
    double[] List_revetements_surface ;
    private static Map<Integer, Piece> pieceMap = new HashMap<>() ;
    
    public Piece(Mur m1, Mur m2,Mur m3,Mur m4, Sol sol, Plafond plafond,String nomPiece) {
        this.idPiece = next_piece++;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.sol = sol;
        this.nomPiece = nomPiece;
        this.plafond = plafond;
        pieceMap.put(this.getIdPiece(), this);
    }
    
    
    
    public double surface () 
    {
        return (sol.surface());
    }

    public static Map<Integer, Piece> getPieceMap() {
        return pieceMap;
        
        
    }
    
    public static Piece getPiece(int idPiece){
        return pieceMap.get(idPiece);
    }
    
   
    public String getNomPiece() {
        return nomPiece;
    }

    
    
    public int getIdPiece() {
        return idPiece;
    }
    
    

    @Override
    public String toString() {
        return "Piece " + idPiece + " " + m1 + " "+ m2 + " "+ m3 + " "+ m4 + " " + sol + " " + plafond + ", List_revetements_surface=" + List_revetements_surface + '}';
    }
    
    
    
}
