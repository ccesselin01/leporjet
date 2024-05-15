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
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.canvas.Canvas;

public class SaisieNiveaux extends Application {
    
    private Map<String, String> pieces = new HashMap<>();
    private Map<String, String> appartements = new HashMap<>();
/*
    public static void main(String[] args) {
        launch(args);
    }
*/
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Interface Graphique");

        // Partie gauche de la fenêtre
        VBox leftPane = new VBox();
        leftPane.setPadding(new Insets(10));
        leftPane.setSpacing(10);

        TabPane tabPane = new TabPane();

        // Premier onglet : Pièce
        Tab pieceTab = new Tab("Pièce");
        GridPane piecePane = new GridPane();
        piecePane.setHgap(10);
        piecePane.setVgap(5);

        Label mur1Label = new Label("Mur 1");
        piecePane.add(mur1Label, 0, 0);
        ComboBox<String> mur1ComboBox = new ComboBox<>();
        // Ajouter les éléments de la map correspondante à la ComboBox
        mur1ComboBox.getItems().addAll(pieces.values());
        piecePane.add(mur1ComboBox, 1, 0);

        // Ajouter les autres labels et ComboBox de manière similaire

        Label nomPieceLabel = new Label("Nom de la pièce");
        piecePane.add(nomPieceLabel, 0, 6);
        TextField nomPieceTextField = new TextField();
        piecePane.add(nomPieceTextField, 1, 6);

        Button ajouterPieceButton = new Button("Ajouter");
        piecePane.add(ajouterPieceButton, 1, 7);

        pieceTab.setContent(piecePane);

        // Deuxième onglet : Appartement
        Tab appartementTab = new Tab("Appartement");
        GridPane appartementPane = new GridPane();
        appartementPane.setHgap(10);
        appartementPane.setVgap(5);

        // Ajouter les labels, ComboBox et bouton de manière similaire

        appartementTab.setContent(appartementPane);

        // Troisième onglet : Niveau
        Tab niveauTab = new Tab("Niveau");
        GridPane niveauPane = new GridPane();
        niveauPane.setHgap(10);
        niveauPane.setVgap(5);

        // Ajouter les labels, ComboBox et bouton de manière similaire

        niveauTab.setContent(niveauPane);

        tabPane.getTabs().addAll(pieceTab, appartementTab, niveauTab);
        leftPane.getChildren().add(tabPane);

        // Partie droite de la fenêtre
        Pane rightPane = new Pane();

        // Zone d'aperçu
        Canvas previewCanvas = new Canvas(400, 400);
        rightPane.getChildren().add(previewCanvas);

        // Boutons Suivant et Précédent
        Button suivantButton = new Button("Suivant");
        suivantButton.setLayoutX(350);
        suivantButton.setLayoutY(350);

        Button precedentButton = new Button("Précédent");
        precedentButton.setLayoutX(280);
        precedentButton.setLayoutY(350);

        rightPane.getChildren().addAll(suivantButton, precedentButton);

        // Fenêtre principale
        HBox root = new HBox(leftPane, rightPane);
        root.setSpacing(10);

        Scene scene = new Scene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

