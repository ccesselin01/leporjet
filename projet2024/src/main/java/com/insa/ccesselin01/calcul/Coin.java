/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.insa.ccesselin01.calcul;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ccesselin01
 */
public class Coin 
{
    
    int idCoin ;
    static int next_Coin; 
    double x;
    double y;
    private static Map<Integer, Coin> coinMap = new HashMap<>() ;

    
    public Coin (double x, double y)
    {
        this.x = x ; 
        this.y = y ; 
        this.idCoin = this.next_Coin++ ; 
        coinMap.put(this.getIdCoin(), this);
        
    }
    
    public Coin ()
    {
        this.x = 0 ; this.y = 0 ; idCoin = 0 ;
    }
    
    
    public double getX() {
        return x;
    }

    public int getIdCoin() {
        return idCoin;
    }

    public double getY() {
        return y;
    }
    
    public static Coin getCoin(int idCoin) {
        return coinMap.get(idCoin) ;
    }

    public static Map<Integer, Coin> getCoinMap() {
        return coinMap;
    }
    
    @Override
    public String toString() {
        return "Coin ; "+ idCoin + " ; " + x + " ; " + y; // modif
    }

}
