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

import com.insa.ccesselin01.calcul.Batiment;
import com.insa.ccesselin01.calcul.Coin;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.function.UnaryOperator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author ccesselin01
 */
public class AjoutCoin extends Application {

    private String nomProjet;
    private Stage primaryStage;
    Label succes = new Label();

    //private Textfield spin
    TextField spinnerX = new TextField();
    TextField spinnerY = new TextField();

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        primaryStage.setTitle("Ajouter un coin par coodonnées");

        // Création des composants
        Label X = new Label(" X : (en m)");

        Label Y = new Label(" Y : (en m)");

        spinnerX.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Code pour passer au champ suivant
                spinnerY.requestFocus();
            }
        });

        spinnerY.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Code pour passer au champ suivant
                suivant();
                spinnerX.requestFocus();
            }
        });

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
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Ajout des composants à la grille
        gridPane.add(X, 0, 1);
        gridPane.add(spinnerX, 1, 1);
        gridPane.add(Y, 0, 2);
        gridPane.add(spinnerY, 1, 2);
        gridPane.add(bAnnuler, 0, 3);
        gridPane.add(bSuivant, 2, 3);
        gridPane.add(succes, 1, 0);
        //gridPane.add(bSuivant, 1, 2);
        //gridPane.add(bClose, 2, 2);

        // Ajustement des tailles des polices
        Font labelFont = Font.font("Arial", 14);
        X.setFont(labelFont);
        Y.setFont(labelFont);

        // Ajustement des composants avec la fenêtre
        Scene scene = new Scene(gridPane, 350, 150);

        X.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        Y.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        spinnerX.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        spinnerY.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        bAnnuler.prefHeightProperty().bind(scene.heightProperty().multiply(0.05));
        bSuivant.prefHeightProperty().bind(scene.heightProperty().multiply(0.05));

        X.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        Y.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        spinnerX.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        spinnerX.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        bSuivant.prefWidthProperty().bind(scene.widthProperty().multiply(0.31));
        bSuivant.setAlignment(Pos.CENTER_RIGHT);
        bAnnuler.prefWidthProperty().bind(scene.widthProperty().multiply(0.3));
        bAnnuler.setAlignment(Pos.CENTER);

        bSuivant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               suivant();
            }

        });

        bAnnuler.setOnAction(event -> primaryStage.close());

        //primaryStage.close();
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }

    private void suivant() {
        succes.setText("");
        double x = Double.parseDouble(spinnerX.getText());
        double y = Double.parseDouble(spinnerY.getText());
        Coin c = new Coin(x, y);
        System.out.println("nouveau coin " + x + " " + y);

        spinnerX.clear();
        spinnerY.clear();

        succes.setText("Coin " + c.getIdCoin() + " ajouté !");
        succes.setTextFill(Color.GREEN);
    }

}
