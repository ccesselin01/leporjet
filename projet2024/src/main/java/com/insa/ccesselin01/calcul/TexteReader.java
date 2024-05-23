package com.insa.ccesselin01.calcul;

/**
 *
 * @author ccesselin01
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TexteReader {
       
    public void readTextFile(String filename) {
  
        try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(" ; ");
                String mot_cle = fields[0];
                if ("Coin".equals(mot_cle)){
                    int id = Integer.parseInt(fields[1]);
                    double x = Double.parseDouble(fields[2]);
                    double y = Double.parseDouble(fields[3]);
                    Coin c = new Coin(id,x,y);
                }
                else {
                    if ("Mur".equals(mot_cle)){
                        int id = Integer.parseInt(fields[1]);
                        int debut = Integer.parseInt(fields[2]);
                        int fin = Integer.parseInt(fields[3]);
                       // int revetement_mur = Integer.parseInt(fields[4]);
                       // int hauteur = Integer.parseInt(fields[5]);
                       int nbportes = Integer.parseInt(fields[4]);
                       int nbfenetre = Integer.parseInt(fields[5]);
                       int revetement_mur = Integer.parseInt(fields[6]);
                       int hauteur = Integer.parseInt(fields[7]);
                       //Mur m = new Mur(Coin.getCoin(debut), Coin.getCoin(fin), RevetementDatabase.get_Revetement(revetement_mur),hauteur );
                       Mur m = new Mur(id, Coin.getCoin(debut),Coin.getCoin(fin),nbportes, nbfenetre, RevetementDatabase.get_Revetement(revetement_mur),hauteur);
                    }
                    else {
                            if ("Sol".equals(mot_cle)){
                                int id = Integer.parseInt(fields[1]); 
                                int m1 = Integer.parseInt(fields[2]);
                                int m2 = Integer.parseInt(fields[3]);
                                int m3 = Integer.parseInt(fields[4]);
                                int m4 = Integer.parseInt(fields[4]);
                                int revetement = Integer.parseInt(fields[5]);
                                Sol s = new Sol(id, Mur.getMur(m1), Mur.getMur(m2),Mur.getMur(m3),Mur.getMur(m4),RevetementDatabase.get_Revetement(revetement));
                            }
                    else {
                        if ("Plafond".equals(mot_cle)) {
                           int idp = Integer.parseInt(fields[1]); 
                           int sol = Integer.parseInt(fields[2]);
                           int revetement = Integer.parseInt(fields[3]);
                           Plafond p = new Plafond(idp, Sol.getSol(sol), RevetementDatabase.get_Revetement(revetement));
                        }
                    else { // à continuer
                                if ("Piece".equals(mot_cle)){
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
