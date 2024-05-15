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
package com.insa.ccesselin.interfacegraphique;

/**
 *
 * @author
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import com.insa.ccesselin.calcul.Batiment;
import com.insa.ccesselin.calcul.Mur;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;


public class RenseignementDevis extends Application {
    
    public Scene scene;
    private Stage primaryStage;
    

    @Override
    public void start(Stage primaryStage) {
        
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Formulaire de bâtiment");

        // Création des composants
        
        /*
        Label nameLabel = new Label("Nom du bâtiment:");
        TextField nameField = new TextField();

        Label projectLabel = new Label("Nom du projet:");
        TextField projectField = new TextField();

        Label levelLabel = new Label("Nombre de niveaux:");
        Spinner<Integer> levelSpinner = new Spinner<>(1, 100, 1);
        */
        Button bCreationCoin = new Button(" Ajouter un coin ");
        
        Button confirmButton = new Button("Suivant");
        
        Button bCreationMur = new Button(" Ajouter un mur ");
        
        Button bCreationSol = new Button(" Ajouter un sol ");
        
        Button bCreationPlafond = new Button(" Ajouter un plafond ");
        
        
        
        

        // Création de la grille pour organiser les composants
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);

        // Ajout des composants à la grille
        gridPane.add(bCreationCoin, 0, 0);
        gridPane.add(bCreationMur, 1, 0);
        gridPane.add(bCreationSol, 0, 1);
        gridPane.add(bCreationPlafond, 1, 1);
        
        gridPane.add(confirmButton, 1, 3);

        
        /*
        // Ajustement des tailles des polices
        Font labelFont = Font.font("Arial", 14);
        nameLabel.setFont(labelFont);
        projectLabel.setFont(labelFont);
        levelLabel.setFont(labelFont);
        */
        
        // Ajustement des composants avec la fenêtre
        Scene scene = new Scene(gridPane, 900, 600);

        double heightRatio = 0.2;
        double widthRatio = 0.3;
        
        
        
        //nameLabel.prefWidthProperty().bind(scene.widthProperty().multiply(0.3));
        //nameField.prefWidthProperty().bind(scene.widthProperty().multiply(0.6));
        bCreationPlafond.prefHeightProperty().bind(scene.heightProperty().multiply(heightRatio));
        bCreationSol.prefHeightProperty().bind(scene.heightProperty().multiply(heightRatio));
        bCreationMur.prefHeightProperty().bind(scene.heightProperty().multiply(heightRatio));
        bCreationCoin.prefHeightProperty().bind(scene.heightProperty().multiply(heightRatio));
        confirmButton.prefHeightProperty().bind(scene.heightProperty().multiply(0.05));
        
        bCreationPlafond.prefWidthProperty().bind(scene.widthProperty().multiply(widthRatio));
        bCreationSol.prefWidthProperty().bind(scene.widthProperty().multiply(widthRatio));
        bCreationMur.prefWidthProperty().bind(scene.widthProperty().multiply(widthRatio));
        bCreationCoin.prefWidthProperty().bind(scene.widthProperty().multiply(widthRatio));
        confirmButton.prefWidthProperty().bind(scene.widthProperty().multiply(0.3));
        confirmButton.setAlignment(Pos.CENTER_RIGHT);
        
        // taille du texte
        
        bCreationPlafond.styleProperty().bind(Bindings.concat("-fx-font-size: ", bCreationPlafond.widthProperty().divide(14)));
        bCreationSol.styleProperty().bind(Bindings.concat("-fx-font-size: ", bCreationSol.widthProperty().divide(14)));
        bCreationMur.styleProperty().bind(Bindings.concat("-fx-font-size: ", bCreationMur.widthProperty().divide(14)));
        bCreationCoin.styleProperty().bind(Bindings.concat("-fx-font-size: ", bCreationCoin.widthProperty().divide(14)));
        confirmButton.styleProperty().bind(Bindings.concat("-fx-font-size: ", confirmButton.widthProperty().divide(14)));
                
        bCreationPlafond.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent t) {
                
                creationPlafond();
                
             }
            
        });
        
        bCreationPlafond.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Code pour passer au champ suivant
                
                creationPlafond();
            }
        });
        
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent t) {
                System.out.println("suivant(pièces)");
                creationPieces();
                
             }
            
        });
        
        confirmButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Code pour passer au champ suivant
                
                creationPieces();
            }
        });
        
        bCreationSol.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent t) {
                System.out.println("nouveau Sol");
                creationSol();
                
             }
            
        });
        
        bCreationSol.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Code pour passer au champ suivant
                
                creationSol();
            }
        });
        
        bCreationMur.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent t) {
                System.out.println("nouveau Mur");
                creationMur();
                
             }
            
        });
        
        bCreationMur.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Code pour passer au champ suivant
                
                creationMur();
            }
        });
        
        bCreationCoin.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent t) {
                // Pour debug : System.out.println("nouveau Coin");
                creationCoin();
                //EnterPointDialog.demandePoint();
                
             }
            
        });
        
        bCreationCoin.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Code pour passer au champ suivant
                
                creationCoin();
            }
        });
        

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void creationCoin(){
        
        AjoutCoin newCoin = new AjoutCoin();
        Stage stage = new Stage();
        newCoin.start(stage);
        
    }
    
    private void creationMur(){
        
        AjoutMur newMur = new AjoutMur();
        Stage stage = new Stage();
        newMur.start(stage);
        
    }
    
    private void creationSol(){
        
        AjoutSol newSol = new AjoutSol();
        Stage stage = new Stage();
        newSol.start(stage);
        //this.primaryStage.close();
        
    }
    private void creationPlafond(){
        
        AjoutPlafond newPlafond = new AjoutPlafond();
        Stage stage = new Stage();
        newPlafond.start(stage);
        
    }
    
    private void creationPieces(){
        
        //NewInterface niv = new NewInterface();
        
        InterfaceGraphique niv = new InterfaceGraphique(); 
        niv.start(primaryStage);
        //System.out.println(Mur.getmurMap());
        //this.primaryStage.close();
        
    }
}