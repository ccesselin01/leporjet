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
package com.insa.ccesselin01.interfacegraphique;

import com.insa.ccesselin01.calcul.Mur;
import com.insa.ccesselin01.calcul.Piece;
import com.insa.ccesselin01.calcul.Plafond;
import com.insa.ccesselin01.calcul.Revetement;
import com.insa.ccesselin01.calcul.Sol;
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
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author ccesselin01
 */
public class SaisiePiece extends Application{
    
    private Stage primaryStage;
    Label succes = new Label();
    Label lCoutMur = new Label();
    //private Textfield spin

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        primaryStage.setTitle("Saisir les pieces");

        // Création des composants
        Label m1 = new Label("Choisir un Mur");

        Label m2 = new Label("Choisir un Mur");

        Label m3 = new Label("Choisir un Mur ");

        Label m4 = new Label("Choisir un Mur");

        Label sol = new Label("Choisir un Sol");
        
        Label plafond = new Label("Choisir un Plafond");
        
        Label nom = new Label("Nom de la pièce :");

        //TextField spinnerX = new TextField();
        //TextField spinnerY = new TextField();
        //TextField tfh = new TextField();
        ComboBox<Integer> cbM1 = new ComboBox<>();
        // Ajoute les clés de la HashMap à la liste déroulante
        cbM1.getItems().addAll(Mur.getmurMap().keySet());

        ComboBox<Integer> cbM2 = new ComboBox<>();
        // Ajoute les clés de la HashMap à la liste déroulante
        cbM2.getItems().addAll(Mur.getmurMap().keySet());

        ComboBox<Integer> cbM3 = new ComboBox<>();
        // Ajoute les clés de la HashMap à la liste déroulante
        cbM3.getItems().addAll(Mur.getmurMap().keySet());

        ComboBox<Integer> cbM4 = new ComboBox<>();
        // Ajoute les clés de la HashMap à la liste déroulante
        cbM4.getItems().addAll(Mur.getmurMap().keySet());
        

        ComboBox<Integer> cbSol = new ComboBox<>();
        cbSol.getItems().addAll(Sol.getSolMap().keySet());
        
        ComboBox<Integer> cbPlafond = new ComboBox<>();
        cbPlafond.getItems().addAll(Plafond.getplafondMap().keySet());
        
        TextField tfNom = new TextField();
        
        // Ajoute les objets Revêtement à la liste déroulante
        

        //cbRevetement.setButtonCell(comboBox.getCellFactory().call(null));
        //cbRevetement.getItems().addAll(Revetement.getRevetementMap().values().getDenomination());
        //Spinner<Double> spinnerX = new Spinner<>();
        // Définition de la plage de valeurs du Spinner avec un pas de 0.001
        //SpinnerValueFactory<Double> valueFactoryx = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 100.0, 0.0, 0.001);
        //spinnerX.setValueFactory(valueFactoryx);
        //Spinner<Double> spinnerY = new Spinner<>();
        // Définition de la plage de valeurs du Spinner avec un pas de 0.001
        //SpinnerValueFactory<Double> valueFactoryy = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 100.0, 0.0, 0.001);
        //spinnerY.setValueFactory(valueFactoryy);
        //spinnerX.setEditable(true);
        //spinnerY.setEditable(true);
/*
        // Définition d'un éditeur de texte personnalisé pour le Spinner
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        UnaryOperator<Change> filter = change -> {
            String newText = change.getControlNewText();
            ParsePosition parsePosition = new ParsePosition(0);
            decimalFormat.parse(newText, parsePosition);

            if (newText.isEmpty() || parsePosition.getIndex() == newText.length()) {
                return change;
            }

            return null;
        };
        
         */
        //boutton suivant
        Button bSuivant = new Button("Suivant");

        //boutton annuler
        Button bAnnuler = new Button("Fermer");

        // Création de la grille pour organiser les composants
        SplitPane splitPane = new SplitPane();
        
        StackPane stack = new StackPane();
        
        HBox hbChamp = new HBox();
        
        hbChamp.getChildren().addAll(nom,cbM1, cbM2, cbM3,cbM4,cbSol,cbPlafond);
        
        
        HBox hbText = new HBox();
        
        hbText.getChildren().addAll(m1, m2, m3,m4,sol,plafond);
        
        
        
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Ajout des composants à la grille
        // objet, colone, ligne
        gridPane.add(m1, 0, 1);
        gridPane.add(cbM1, 1, 1);
        gridPane.add(m2, 0, 2);
        gridPane.add(cbM2, 1, 2);
        gridPane.add(m3, 0, 3);
        gridPane.add(cbM3, 1, 3);
        gridPane.add(m4, 0, 4);
        gridPane.add(cbM4, 1, 4);
        gridPane.add(sol, 0, 5);
        gridPane.add(cbSol, 1, 5);
        gridPane.add(plafond, 0, 6);
        gridPane.add(cbPlafond, 1, 6);
        //gridPane.add(plafond, 0, 7);
        //gridPane.add(cbPlafond, 1, 7);
        
        gridPane.add(bAnnuler, 0, 8);
        gridPane.add(bSuivant, 2, 8);
        gridPane.add(succes, 1, 0);
        //gridPane.add(lCoutMur, 2, 3);
        
        splitPane.getItems().addAll(gridPane,stack);

        //gridPane.add(bSuivant, 1, 2);
        //gridPane.add(bClose, 2, 2);
        // Ajustement des tailles des polices
        Font labelFont = Font.font("Arial", 14);
        m1.setFont(labelFont);
        m2.setFont(labelFont);
        m4.setFont(labelFont);
        m3.setFont(labelFont);
        lCoutMur.setFont(labelFont);
        sol.setFont(labelFont);
        plafond.setFont(labelFont);

        // Ajustement des composants avec la fenêtre
        Scene scene = new Scene(splitPane, 900, 600);

        m1.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        m2.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        m4.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        m3.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        sol.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        plafond.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        nom.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));

        lCoutMur.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbM1.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbM2.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbM3.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbM4.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbSol.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbPlafond.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        tfNom.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        
        bAnnuler.prefHeightProperty().bind(scene.heightProperty().multiply(0.05));
        bSuivant.prefHeightProperty().bind(scene.heightProperty().multiply(0.05));

        lCoutMur.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        m1.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        m2.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        m4.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        m3.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        sol.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        plafond.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        nom.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));

        cbM1.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        cbM2.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        cbM3.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        cbM4.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        cbSol.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        cbPlafond.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        tfNom.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));

        bSuivant.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));
        bSuivant.setAlignment(Pos.CENTER);
        bAnnuler.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));
        bAnnuler.setAlignment(Pos.CENTER);


        bSuivant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                succes.setText("");

                int selectedKey = cbM1.getValue();
                Mur mur1 = Mur.getMur(selectedKey);

                int selectedKey1 = cbM2.getValue();
                Mur mur2 = Mur.getMur(selectedKey1);

                int selectedKey2 = cbM3.getValue();
                Mur mur3 = Mur.getMur(selectedKey2);

                int selectedKey3 = cbM4.getValue();
                Mur mur4 = Mur.getMur(selectedKey3);

                Sol sol = Sol.getSol(cbSol.getValue());
                Plafond plafond = Plafond.getPlafond(cbPlafond.getValue());
                
                String nomPiece = tfNom.getText();
                
              

                Piece p = new Piece(mur1, mur2, mur3, mur4, sol, plafond, nomPiece);
                System.out.println("nouvelle piece ");

                cbM1.setValue(null);
                cbM2.setValue(null);
                cbM3.setValue(null);
                cbM4.setValue(null);
                cbSol.setValue(null);
                cbPlafond.setValue(null);

                succes.setText("Sol " + p.getIdPiece() + " ajouté !");
                succes.setTextFill(Color.GREEN);

            }

        });

        bAnnuler.setOnAction(event -> primaryStage.close());

        //primaryStage.close();
        primaryStage.setScene(scene);
        primaryStage.show();

        /*
        bClose.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent t) {
                String buildingName = m1.getText();
                String projectName = m2.getText();
                int levelCount = levelSpinner.getValue();

                // Utilisez les valeurs récupérées comme vous le souhaitez
                Batiment bat =new Batiment(buildingName,projectName,levelCount);
                System.out.println("Nom du bâtiment : " + buildingName);
                System.out.println("Nom du projet : " + projectName);
                System.out.println("Nombre de niveaux : " + levelCount);
                System.out.println(bat.toString());
            
                openRenseignementDevis();

                // Fermez la fenêtre si nécessaire
                //primaryStage.close();
                
             }
            
        });

         */
    }
    
    
}
