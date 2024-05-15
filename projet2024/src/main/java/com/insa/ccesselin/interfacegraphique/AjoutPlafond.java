package com.insa.ccesselin.interfacegraphique;


import com.insa.ccesselin.calcul.Plafond;
import com.insa.ccesselin.calcul.Revetement;
import com.insa.ccesselin.calcul.Sol;
import java.text.DecimalFormat;
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
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author 
 */
public class AjoutPlafond extends Application{
    
    private Stage primaryStage;
    Label succes = new Label();
    Label lCoutMur = new Label();
    //private Textfield spin
    
    DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        primaryStage.setTitle("Ajouter un Sol");

        // Création des composants
        Label m1 = new Label("Choisir le sol");

        Label rev = new Label("Choisir un revetement");

        //TextField spinnerX = new TextField();
        //TextField spinnerY = new TextField();
        //TextField tfh = new TextField();
        ComboBox<Integer> cbM1 = new ComboBox<>();
        // Ajoute les clés de la HashMap à la liste déroulante
        cbM1.getItems().addAll(Sol.getSolMap().keySet());

        ComboBox<Revetement> cbRevetement = new ComboBox<>();

        // Ajoute les objets Revêtement à la liste déroulante
        for (Revetement revetement : Revetement.getRevPourPlafondMap().values()) {
            cbRevetement.getItems().add(revetement);
        }

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
        gridPane.add(m1, 0, 1);
        gridPane.add(cbM1, 1, 1);
        gridPane.add(rev, 0, 2);
        gridPane.add(cbRevetement, 1, 2);
        gridPane.add(bAnnuler, 0, 3);
        gridPane.add(bSuivant, 2, 3);
        gridPane.add(succes, 1, 0);
        gridPane.add(lCoutMur, 2, 2);

        //gridPane.add(bSuivant, 1, 2);
        //gridPane.add(bClose, 2, 2);
        // Ajustement des tailles des polices
        Font labelFont = Font.font("Arial", 14);
        m1.setFont(labelFont);
        lCoutMur.setFont(labelFont);
        rev.setFont(labelFont);

        
        Scene scene = new Scene(gridPane, 450, 200);
        
        // Ajustement des composants avec la fenêtre
        //hauteur
        m1.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbM1.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        //largeur
        m1.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        cbM1.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        
        
        //de meme pour les autres composants
        rev.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        lCoutMur.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbRevetement.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        bAnnuler.prefHeightProperty().bind(scene.heightProperty().multiply(0.05));
        bSuivant.prefHeightProperty().bind(scene.heightProperty().multiply(0.05));
        lCoutMur.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        rev.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        cbRevetement.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        bSuivant.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));
        bSuivant.setAlignment(Pos.CENTER);
        bAnnuler.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));
        bAnnuler.setAlignment(Pos.CENTER);
        
        //afficher le devis provisoir une fois le revetement créé
        cbRevetement.setOnAction(e -> {
            
            if(cbM1.getValue()!= null && cbRevetement.getValue() != null){
            int selectedKey = cbM1.getValue();
            Sol s = Sol.getSol(selectedKey);
            

            Revetement revetement = cbRevetement.getValue();

            //double hauteurmur = Double.parseDouble(rev.getText());
            double surface = s.surface();

            double cout = surface * revetement.getPrixunitaire();
            System.out.println(surface + " m2 " + " cout : " + cout);
            
            String valeurFormat = decimalFormat.format(cout);
            lCoutMur.setText(valeurFormat + " \u20AC");
            } else {
                lCoutMur.setText("");
            }

        });
        
        
        //créer le plafond avec les atribus selectionnés
        bSuivant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                succes.setText("");

                int selectedKey = cbM1.getValue();
                Sol s = Sol.getSol(selectedKey);

                Revetement revetement = cbRevetement.getValue();

                Plafond p = new Plafond(s.getM1(), s.getM2(), s.getM3(), s.getM4(), revetement);
                System.out.println("nouveau Sol " + " " + revetement.getDesignation());

                cbM1.setValue(null);
                
                cbRevetement.setValue(null);

                succes.setText("Sol " + s.getIdSol() + " ajouté !");
                succes.setTextFill(Color.GREEN);

            }

        });
        
        //Fermer la fenêtre lors du clic
        bAnnuler.setOnAction(event -> primaryStage.close());

        //primaryStage.close();
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
}
