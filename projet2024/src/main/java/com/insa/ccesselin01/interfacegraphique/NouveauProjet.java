package com.insa.ccesselin01.interfacegraphique;



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
import com.insa.ccesselin01.calcul.Batiment;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;


public class NouveauProjet extends Application {
    
    private String nomProjet;
    private Stage primaryStage;
    public static String idBat;
    public static String nomProj;
    public static int nbNiveaux;
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Formulaire de bâtiment");

        // Création des composants
        Label nameLabel = new Label("ID du bâtiment:");
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

        // Ajustement des composants avec la fenêtre
        Scene scene = new Scene(gridPane, 900, 600);

        nameLabel.prefWidthProperty().bind(scene.widthProperty().multiply(0.3));
        nameField.prefWidthProperty().bind(scene.widthProperty().multiply(0.6));
        projectLabel.prefWidthProperty().bind(scene.widthProperty().multiply(0.3));
        projectField.prefWidthProperty().bind(scene.widthProperty().multiply(0.6));
        levelLabel.prefWidthProperty().bind(scene.widthProperty().multiply(0.3));
        levelSpinner.prefWidthProperty().bind(scene.widthProperty().multiply(0.6));
        confirmButton.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));
        confirmButton.setAlignment(Pos.CENTER_RIGHT);
        
        nameField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Code pour passer au champ suivant
                projectField.requestFocus();
            }
        });

        projectField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Code pour passer au champ suivant
                
                levelSpinner.requestFocus();
            }
        });
        
        levelSpinner.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Code pour passer au champ suivant
                
                confirmButton.requestFocus();
            }
        });
        
        confirmButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Code pour passer au champ suivant
                idBat = nameField.getText();
                nomProj = projectField.getText();
                nbNiveaux = levelSpinner.getValue();

                // Utilisez les valeurs récupérées comme vous le souhaitez
                //Batiment bat =new Batiment(buildingName,projectName,levelCount);
                System.out.println("Nom du bâtiment : " + idBat);
                System.out.println("Nom du projet : " + nomProj);
                System.out.println("Nombre de niveaux : " + nbNiveaux);
                //System.out.println(bat.toString());
            
                openRenseignementDevis();

                // Fermez la fenêtre si nécessaire
            }
        });
        
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent t) {
                idBat = nameField.getText();
                nomProj = projectField.getText();
                nbNiveaux = levelSpinner.getValue();

                // Utilisez les valeurs récupérées comme vous le souhaitez
                //Batiment bat =new Batiment(buildingName,projectName,levelCount);
                System.out.println("Nom du bâtiment : " + idBat);
                System.out.println("Nom du projet : " + nomProj);
                System.out.println("Nombre de niveaux : " + nbNiveaux);
                //System.out.println(bat.toString());
            
                openRenseignementDevis();

                // Fermez la fenêtre si nécessaire
                
                
             }
            
        });
      /*  
        confirmButton.setOnAction(e -> {
            String buildingName = nameField.getText();
            String projectName = projectField.getText();
            int levelCount = levelSpinner.getValue();

            // Utilisez les valeurs récupérées comme vous le souhaitez
            Batiment bat =new Batiment(buildingName,projectName,levelCount);
            System.out.println("Nom du bâtiment : " + buildingName);
            System.out.println("Nom du projet : " + projectName);
            System.out.println("Nombre de niveaux : " + levelCount);
            System.out.println(bat.toString());
            
            openRenseignementDevis();

            // Fermez la fenêtre si nécessaire
            primaryStage.close();
            
            
        });
*/
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void openRenseignementDevis() {
        RenseignementDevis remplir = new RenseignementDevis();
        //Stage stageCoin = new Stage();
        remplir.start(primaryStage);
        
    }
}
/**
 *
 * @author ccesselin01
 */

