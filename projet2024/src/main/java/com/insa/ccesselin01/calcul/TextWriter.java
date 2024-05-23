package com.insa.ccesselin01.calcul;

/**
 *
 * @author ccesselin01
 */

import java.io.File;
import java.awt.Desktop;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Map;

public class TextWriter {
    
    private static DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    
    public static void genererDevisTexte(Devis devis, String cheminFichier) {
        try {
            FileWriter fileWriter = new FileWriter(cheminFichier);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Devis de revêtements");
            printWriter.println();
            printWriter.println("______________________________________________________________________");
            printWriter.println();

            for (Map.Entry<Revetement, Double> entry : devis.getPrixRevetements().entrySet()) {
                Revetement revêtement = entry.getKey();
                double coutRevetement = entry.getValue();

                String CoutFormat = decimalFormat.format(coutRevetement);
                
                printWriter.print("Revêtement : " + revêtement.getDesignation()+"     ");
                printWriter.println("Coût : " + CoutFormat + " euros");
                printWriter.println();
            }
            printWriter.println("______________________________________________________________________");
            printWriter.println();
            printWriter.println("Coût total : " + decimalFormat.format(devis.getTotal()) + " euros");

            printWriter.close();
            System.out.println("Le devis a été généré avec succès !");
            Desktop.getDesktop().open(new File(cheminFichier));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void sauvegarde_projet( String CheminFichier) {
        try {
            FileWriter fileWriter = new FileWriter(CheminFichier);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Sauvegarde du Projet");
            printWriter.println();

            for (Map.Entry<Integer, Coin> entry : Coin.getCoinMap().entrySet()) {
                Integer idCoin = entry.getKey();
                Coin coinsauvegarde = entry.getValue();

                printWriter.print(" " +coinsauvegarde.toString()); // cf classe Coin
                printWriter.println();
            }
            for (Map.Entry<Integer, Mur> entry : Mur.getmurMap().entrySet()) {
                Integer idMur = entry.getKey();
                Mur mursauvegarde = entry.getValue();

                printWriter.print(mursauvegarde.toString());
                printWriter.println();
            }
            for (Map.Entry<Integer, Plafond> entry : Plafond.getplafondMap().entrySet()) {
                Integer idPlafond = entry.getKey();
                Plafond plafondsauvegarde = entry.getValue();

                printWriter.print(plafondsauvegarde.toString());
                printWriter.println();
            }
            for (Map.Entry<Integer, Sol> entry : Sol.getSolMap().entrySet()) {
                Integer idSol = entry.getKey();
                Sol solsauvegarde = entry.getValue();

                printWriter.print(solsauvegarde.toString());
                printWriter.println();
            }
            for (Map.Entry<Integer, Piece> entry : Piece.getPieceMap().entrySet()) {
                Integer idPiece = entry.getKey();
                Piece piecesauvegarde = entry.getValue();

                printWriter.print(piecesauvegarde.toString());
                printWriter.println();
            }
            for (Map.Entry<Integer, Niveau> entry : Niveau.getNiveauMap().entrySet()) {
                Integer idNiveau = entry.getKey();
                Niveau niveausauvegarde = entry.getValue();

                printWriter.print(niveausauvegarde.toString());
                printWriter.println();
            }
            for (Map.Entry<Integer, Appartement> entry : Appartement.getAppartementMap().entrySet()) {
                Integer idappartement = entry.getKey();
                Appartement appartementsauvegarde = entry.getValue();

                printWriter.print(appartementsauvegarde.toString());
                printWriter.println();
            }
           
            printWriter.close();
            System.out.println("La Sauvegarde a été faite avec succès !");
            Desktop.getDesktop().open(new File(CheminFichier));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


