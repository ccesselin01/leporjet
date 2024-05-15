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
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AncienProjet extends Application {

    private Button bOuvrir;
    
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Overture d'un Projet");

        /*
        // Création des composants
        Label nameLabel = new Label("Nom du bâtiment:");
        TextField nameField = new TextField();

        Label projectLabel = new Label("Nom du projet:");
        TextField projectField = new TextField();

        Label levelLabel = new Label("Nombre de niveaux:");
        Spinner<Integer> levelSpinner = new Spinner<>(1, 100, 1);

        Button confirmButton = new Button("Confirmer");

        // Création de la grille pour organiser les composants
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        
/*
        // Ajout des composants à la grille
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(projectLabel, 0, 1);
        gridPane.add(projectField, 1, 1);
        gridPane.add(levelLabel, 0, 2);
        gridPane.add(levelSpinner, 1, 2);
        gridPane.add(confirmButton, 1, 3);

        // Ajustement des tailles des polices
        Font labelFont = Font.font("Arial", 14);
        nameLabel.setFont(labelFont);
        projectLabel.setFont(labelFont);
        levelLabel.setFont(labelFont);
*/
        

        // Création du conteneur principal VBox
        VBox vbCenter = new VBox (this.bOuvrir);
        vbCenter.setSpacing(20);
        vbCenter.setAlignment(Pos.CENTER);
         
        
        Scene scene = new Scene(vbCenter,900, 600);
        
        // Lier la largeur des boutons à la largeur de la fenêtre
        
        bOuvrir.prefWidthProperty().bind(scene.widthProperty().divide(2));

        // Lier la hauteur des boutons à la hauteur de la fenêtre
        
        bOuvrir.prefHeightProperty().bind(scene.heightProperty().divide(6));

        // Configuration de la scène et affichage de la fenêtre
        
        
        bOuvrir.styleProperty().bind(Bindings.concat("-fx-font-size: ", bOuvrir.widthProperty().divide(15)));
        

        // Ajustement des composants avec la fenêtre
        
/*
        nameLabel.prefWidthProperty().bind(scene.widthProperty().multiply(0.3));
        nameField.prefWidthProperty().bind(scene.widthProperty().multiply(0.6));
        projectLabel.prefWidthProperty().bind(scene.widthProperty().multiply(0.3));
        projectField.prefWidthProperty().bind(scene.widthProperty().multiply(0.6));
        levelLabel.prefWidthProperty().bind(scene.widthProperty().multiply(0.3));
        levelSpinner.prefWidthProperty().bind(scene.widthProperty().multiply(0.6));
        confirmButton.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));
        confirmButton.setAlignment(Pos.CENTER_RIGHT);
*/
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
