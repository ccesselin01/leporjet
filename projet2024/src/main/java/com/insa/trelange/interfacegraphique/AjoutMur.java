/*
Copyright 2000- Francois de Bertrand de Beuvron

This file is part of CoursBeuvron.

CoursBeuvron is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

CoursBeuvron is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with CoursBeuvron.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.insa.trelange.interfacegraphique;

import com.insa.trelange.calcul.Coin;
import com.insa.trelange.calcul.Mur;
import com.insa.trelange.calcul.Revetement;
import java.text.DecimalFormat;
import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author tomrelange
 */
public class AjoutMur extends Application  {
    
    private Stage primaryStage;
    Label succes = new Label();
    Label lCoutMur = new Label();
    //private Textfield spin


    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    
    @Override
    public void start(Stage primaryStage) {
        
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Ajouter un coin par coodonnées");

        // Création des composants
        
        Label Debut = new Label("Choisir un coin Début");

        Label Fin = new Label("Choisir un coin de Fin");
        
        Label hauteur = new Label("Hauteur ");
        
        Label lRevetement = new Label("Choisir un Revetement");
        
       
        
        //TextField spinnerX = new TextField();
        //TextField spinnerY = new TextField();
        
        TextField tfh = new TextField();
        
        ComboBox<Integer> cbDebut = new ComboBox<>();
        // Ajoute les clés de la HashMap à la liste déroulante
        cbDebut.getItems().addAll(Coin.getCoinMap().keySet());
        
        
        ComboBox<Integer> cbFin = new ComboBox<>();
        // Ajoute les clés de la HashMap à la liste déroulante
        cbFin.getItems().addAll(Coin.getCoinMap().keySet());
        
        
        ComboBox<Revetement> cbRevetement = new ComboBox<>();
        
        //Commande pour debugage
        //System.out.println("Ajout combo");
        //System.out.println(Revetement.getRevPourMurMap().values());
        
        cbRevetement.getItems().addAll(Revetement.getRevPourMurMap().values());
        
        // Ajoute les objets Revêtement à la liste déroulante
        

        // Définis une cellule de rendu personnalisée pour afficher l'attribut "dénomination"
        cbRevetement.setCellFactory(param -> new ListCell<Revetement>() {
            @Override
            protected void updateItem(Revetement item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getDesignation());
                }
            }
        });

        
        
        //boutton suivant
        Button bSuivant = new Button("Suivant");
        
        //boutton annuler
        
        Button bAnnuler = new Button("Fermer");
        
        

        // Création de la grille pour organiser les composants
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Ajout des composants à la grille
       
        // objet, colone, ligne
        gridPane.add(Debut, 0, 1);
        gridPane.add(cbDebut, 1, 1);
        gridPane.add(Fin, 0, 2);
        gridPane.add(cbFin, 1, 2);
        gridPane.add(hauteur, 0, 3);
        gridPane.add(tfh, 1, 3);
        gridPane.add(bAnnuler, 0, 5);
        gridPane.add(bSuivant, 2, 5);
        gridPane.add(succes, 1, 0);
        gridPane.add(lCoutMur, 2, 3);
        gridPane.add(lRevetement, 0, 4);
        gridPane.add(cbRevetement, 1, 4);
        
        // Ajustement des tailles des polices
        Font labelFont = Font.font("Arial", 14);
        Debut.setFont(labelFont);
        Fin.setFont(labelFont);
        lRevetement.setFont(labelFont);
        lCoutMur.setFont(labelFont);
        tfh.setFont(labelFont);
        hauteur.setFont(labelFont);
        

        // Ajustement des composants avec la fenêtre
        Scene scene = new Scene(gridPane, 700, 200);
        
        //Ajuster les tailles des composants en fonction da la taille de la fenêtre

        Debut.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        Fin.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        lRevetement.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        hauteur.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        
        lCoutMur.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbDebut.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbFin.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbRevetement.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        tfh.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        
        bAnnuler.prefHeightProperty().bind(scene.heightProperty().multiply(0.05));
        bSuivant.prefHeightProperty().bind(scene.heightProperty().multiply(0.05));
        
        
        
        lCoutMur.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        Debut.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        Fin.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        lRevetement.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        hauteur.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        
        cbDebut.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        cbFin.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        cbRevetement.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        tfh.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        
        bSuivant.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));
        bSuivant.setAlignment(Pos.CENTER);
        bAnnuler.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));
        bAnnuler.setAlignment(Pos.CENTER);
        
        
        //Action lorsque le revetement est selectionné pour afficher le devis du mur
        cbRevetement.setOnAction(e -> {
            
            if (cbDebut.getValue() != null && cbFin != null && cbRevetement != null && tfh.getText() != null ){
            int selectedKey = cbDebut.getValue();
            Coin debut = Coin.getCoin(selectedKey);
                 
            int selectedKey1 = cbFin.getValue();
            Coin fin = Coin.getCoin(selectedKey1);
            
            
            Revetement revetement = cbRevetement.getValue();
            
            double hauteurmur = Double.parseDouble(tfh.getText());
            
            double surface = hauteurmur * Math.sqrt(Math.pow((debut.getX()-fin.getX()),2)+Math.pow(debut.getY()-fin.getY(), 2));
            
            double cout = surface*revetement.getPrixunitaire();
            
            String valeurFormat = decimalFormat.format(cout);
            System.out.println(surface+"m2 "+"cout : "+cout);
            lCoutMur.setText(valeurFormat+" \u20AC");
            } else {
                lCoutMur.setText("");
                System.out.println("entrer qqch");
            }
                 
            
        });
        
        
        //Creation du nouveau mur avec les atribus selectionnés
        
        bSuivant.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent t) {
                 
                 succes.setText("");
                 
                 int selectedKey = cbDebut.getValue();
                 Coin coin = Coin.getCoin(selectedKey);
                 
                 int selectedKey1 = cbFin.getValue();
                 Coin coin1 = Coin.getCoin(selectedKey1);
                 
                 double hauteurmurad = Double.parseDouble(tfh.getText());
                 
                 Revetement revetement = cbRevetement.getValue();
                 
                 Mur m = new Mur(coin,coin1,revetement,hauteurmurad);
                 System.out.println("nouveau Mur "+ coin.getIdCoin() + " "+coin1.getIdCoin()+" "+revetement.getDesignation());
                 
                 cbDebut.setValue(null);
                 cbFin.setValue(null);
                 cbRevetement.setValue(null);
                 tfh.setText("");
                 succes.setText("Mur "+m.getIdMur()+" ajouté !");
                 succes.setTextFill(Color.GREEN);
                 
                 
                 
                 
             }
            
        });
        
        //fermer la fenêtre lorsque l'on clique sur annuler
        
        bAnnuler.setOnAction(event -> primaryStage.close());
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
}
