/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insa.trelange.calcul;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tomrelange
 */
public class Appartement {

    int idAppart;
    static int next_appartement;
    ArrayList<Piece> pieces = new ArrayList<>();
    
    int nbrPieces;
    private static Map<Integer, Appartement> appartementMap = new HashMap<>() ;

    public Appartement(ArrayList<Piece> pieces) {

        this.idAppart = next_appartement++;
        
            this.pieces = pieces;
            appartementMap.put(this.idAppart, this);
        
        
    }
    public Appartement() {
        this.idAppart = next_appartement++;
        appartementMap.put(this.idAppart, this);
    }
    
    public static void addPiece (int idApt, Piece piece) {

        appartementMap.get(idApt).setPieces(piece);
        
    }
    public void setPieces(Piece piece) {
        this.pieces.add(piece);
    }
    
    public static Appartement getAppart(int idAppart){
        return appartementMap.get(idAppart);
    }

    public double surface(Piece[] ListPiece) {
        double surface = 0;
        for (int i = 0; i <= nbrPieces - 1; i++) {
            surface = surface + ListPiece[i].surface();

        }
        return surface;
    }

    
    
    
    
    
    public double devis_appart (){
        double devis_appart = 0;
        for (int i = 0; i <= nbrPieces - 1; i++) {
            //devis_appart = devis_appart + pieces[i].devis_piece();
        }
        return devis_appart;
        
    }

    public static Map<Integer, Appartement> getAppartementMap() {
        return appartementMap;
    }
    

}
