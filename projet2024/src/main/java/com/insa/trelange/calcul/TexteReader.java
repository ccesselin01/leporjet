package com.insa.trelange.calcul;

/**
 *
 * @author anais
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TexteReader {
       
    public void TexteReader(String filename) {
  
        try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(" ");
                String mot_cle = fields[0];
                if (mot_cle=="Coin"){
                    int id = Integer.parseInt(fields[1]);
                    double x = Double.parseDouble(fields[2]);
                    double y = Double.parseDouble(fields[3]);
                    Coin c = new Coin(x,y);
                }
                else {
                    if (mot_cle == "Mur"){
                        int id = Integer.parseInt(fields[1]);
                        int debut = Integer.parseInt(fields[2]);
                        int fin = Integer.parseInt(fields[3]);
                        int revetement_mur = Integer.parseInt(fields[4]);
                        int hauteur = Integer.parseInt(fields[5]);
                        Mur m = new Mur(Coin.getCoin(debut), Coin.getCoin(fin), RevetementDatabase.get_Revetement(revetement_mur),hauteur );
                    }
                    else {
                        if (mot_cle=="Plafond") {
                           int id = Integer.parseInt(fields[1]); 
                           int m1 = Integer.parseInt(fields[2]);
                           int m2 = Integer.parseInt(fields[3]);
                           int revetement = Integer.parseInt(fields[4]);
                        }
                        else {
                            if (mot_cle=="Sol"){
                                int id = Integer.parseInt(fields[1]); 
                                int m1 = Integer.parseInt(fields[2]);
                                int m2 = Integer.parseInt(fields[3]);
                                int revetement = Integer.parseInt(fields[4]);
                            }
                            else { 
                                if (mot_cle=="Piece"){
                                    int id = Integer.parseInt(fields[1]);
                                    //Mur[] murs = ;
                                }
                                    
                                    
                            }
                        }
                }
                }
                
            }
 
        }
        catch(FileNotFoundException err){
        System.out.println( "Erreur :le fichier n’existe pas!\n "+err);}
        catch (IOException err){
        System.out.println(" Erreur :\n "+err);}
        
    }
    
    
}
