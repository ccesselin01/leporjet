package com.insa.ccesselin.interfacegraphique;


import com.insa.ccesselin.calcul.Mur;
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
public class AjoutSol extends Application {

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
        Label m1 = new Label("Choisir un Mur");

        Label m2 = new Label("Choisir un Mur");

        Label m3 = new Label("Choisir un Mur ");

        Label m4 = new Label("Choisir un Mur");

        Label rev = new Label("Choisir un revetement");

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

        ComboBox<Revetement> cbRevetement = new ComboBox<>();

        // Ajoute les objets Revêtement à la liste déroulante
        for (Revetement revetement : Revetement.getRevPourSolMap().values()) {
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
        gridPane.add(m2, 0, 2);
        gridPane.add(cbM2, 1, 2);
        gridPane.add(m3, 0, 3);
        gridPane.add(cbM3, 1, 3);
        gridPane.add(m4, 0, 4);
        gridPane.add(cbM4, 1, 4);
        gridPane.add(rev, 0, 5);
        gridPane.add(cbRevetement, 1, 5);
        gridPane.add(bAnnuler, 0, 6);
        gridPane.add(bSuivant, 2, 6);
        gridPane.add(succes, 1, 0);
        gridPane.add(lCoutMur, 2, 3);

        // Ajustement des tailles des polices
        Font labelFont = Font.font("Arial", 14);
        m1.setFont(labelFont);
        m2.setFont(labelFont);
        m4.setFont(labelFont);
        m3.setFont(labelFont);
        lCoutMur.setFont(labelFont);
        rev.setFont(labelFont);

        // Ajustement des composants avec la fenêtre
        Scene scene = new Scene(gridPane, 500, 250);

        m1.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        m2.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        m4.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        m3.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        rev.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));

        lCoutMur.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbM1.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbM2.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbM3.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbM4.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));
        cbRevetement.prefHeightProperty().bind(scene.heightProperty().multiply(0.1));

        bAnnuler.prefHeightProperty().bind(scene.heightProperty().multiply(0.05));
        bSuivant.prefHeightProperty().bind(scene.heightProperty().multiply(0.05));

        lCoutMur.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        m1.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        m2.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        m4.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        m3.prefWidthProperty().bind(scene.widthProperty().multiply(0.25));
        rev.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));

        cbM1.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        cbM2.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        cbM3.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        cbM4.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));
        cbRevetement.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));

        bSuivant.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));
        bSuivant.setAlignment(Pos.CENTER);
        bAnnuler.prefWidthProperty().bind(scene.widthProperty().multiply(0.2));
        bAnnuler.setAlignment(Pos.CENTER);
        
        

        cbRevetement.setOnAction(e -> {
            
            if(cbM1.getValue() != null && cbM2.getValue() != null && cbM3.getValue() != null && cbM4.getValue() != null && cbRevetement.getValue() != null ){
            int selectedKey = cbM1.getValue();
            Mur mur1 = Mur.getMur(selectedKey);

            int selectedKey1 = cbM2.getValue();
            Mur mur2 = Mur.getMur(selectedKey1);

            int selectedKey2 = cbM3.getValue();
            Mur mur3 = Mur.getMur(selectedKey2);

            int selectedKey3 = cbM4.getValue();
            Mur mur4 = Mur.getMur(selectedKey3);

            Revetement revetement = cbRevetement.getValue();

            
            double surface ;
            
            if (mur1.longueur()==mur2.longueur()) {
                surface  = mur1.surface()*mur3.surface();
            } else {
            
                surface = mur1.surface()*mur2.surface();
            }

            double cout = surface * revetement.getPrixunitaire();
            System.out.println(surface + " m2 " + " cout : " + cout);
            
            String valeurFormat = decimalFormat.format(cout);
            lCoutMur.setText(valeurFormat + " \u20AC");
            } else {
                lCoutMur.setText("");
            }

        });
        

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

                Revetement revetement = cbRevetement.getValue();

                Sol s = new Sol(mur1, mur2, mur3, mur4, revetement);
                System.out.println("nouveau Sol " + " " + revetement.getDesignation());

                cbM1.setValue(null);
                cbM2.setValue(null);
                cbM3.setValue(null);
                cbM4.setValue(null);
                cbRevetement.setValue(null);

                succes.setText("Sol " + s.getIdSol() + " ajouté !");
                succes.setTextFill(Color.GREEN);

            }

        });

        bAnnuler.setOnAction(event -> primaryStage.close());

        
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
