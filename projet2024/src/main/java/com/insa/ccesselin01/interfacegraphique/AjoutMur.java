package com.insa.ccesselin01.interfacegraphique;

import com.insa.ccesselin01.calcul.Coin;
import com.insa.ccesselin01.calcul.Mur;
import com.insa.ccesselin01.calcul.Revetement;
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
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author ccesselin01
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
        primaryStage.setTitle("Ajouter un mur");

        // Création des composants
        
        Label Debut = new Label("Choisir un coin Début");

        Label Fin = new Label("Choisir un coin Fin");
        
        Label hauteur = new Label("Hauteur ");
        
        Label lRevetement = new Label("Choisir un Revêtement");
        
        // modifié :
        
        Label nbFenetres = new Label("Choisir le nombre de fenêtres");
        
        Label nbPortes = new Label("Choisir le nombre de portes");
        
        //TextField spinnerX = new TextField();
        //TextField spinnerY = new TextField();
        
        TextField tfh = new TextField(); // hauteur
        // Modifié
        TextField tfporte = new TextField();
        TextField tffenetre = new TextField();
        
        tfh.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Code pour passer au champ suivant
                tffenetre.requestFocus();
            }
        });
        tffenetre.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Code pour passer au champ suivant
                tfporte.requestFocus();
            }
        });
        
        
        ComboBox<Integer> cbDebut = new ComboBox<>();
        // Ajoute les clés de la HashMap à la liste déroulante
        cbDebut.getItems().addAll(Coin.getCoinMap().keySet());
        
        
        ComboBox<Integer> cbFin = new ComboBox<>();
        // Ajoute les clés de la HashMap à la liste déroulante
        cbFin.getItems().addAll(Coin.getCoinMap().keySet());
        
        
        ComboBox<Revetement> cbRevetement = new ComboBox<>();
        
        tfporte.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Code pour passer au champ suivant
                cbRevetement.requestFocus();
            }
        });
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
        gridPane.add(bAnnuler, 0, 7); // 5 modifié en 7
        gridPane.add(bSuivant, 2, 7); // 5 modifié en 7
        gridPane.add(succes, 1, 0);
        gridPane.add(lCoutMur, 2, 3);
        gridPane.add(lRevetement, 0, 6);
        gridPane.add(cbRevetement, 1, 6);
        // Modifié
        gridPane.add(nbFenetres, 0, 4);
        gridPane.add(nbPortes, 0, 5);
        gridPane.add(tfporte, 1, 5);
        gridPane.add(tffenetre, 1, 4);
        
        // Ajustement des tailles des polices
        Font labelFont = Font.font("Arial", 14);
        Debut.setFont(labelFont);
        Fin.setFont(labelFont);
        lRevetement.setFont(labelFont);
        lCoutMur.setFont(labelFont);
        tfh.setFont(labelFont);
        hauteur.setFont(labelFont);
        // Modifié
        nbFenetres.setFont(labelFont);
        nbPortes.setFont(labelFont);
        tfporte.setFont(labelFont);
        tffenetre.setFont(labelFont);
        
        
        // Ajustement des composants avec la fenêtre
        Scene scene = new Scene(gridPane, 700, 290);
        
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
        // Modifié
        cbRevetement.setOnAction(e -> {
            
            if (cbDebut.getValue() != null && cbFin != null && cbRevetement != null && tfh.getText() != null && tffenetre.getText()!=null && tfporte.getText()!=null ){
            int selectedKey = cbDebut.getValue();
            Coin debut = Coin.getCoin(selectedKey);
                 
            int selectedKey1 = cbFin.getValue();
            Coin fin = Coin.getCoin(selectedKey1);
            // Modifié
            int porteTexte = Integer.parseInt(tfporte.getText()); // parse int sert à mettre le txt en int
            int fenetreTexte = Integer.parseInt(tffenetre.getText());
            // fin Modifié
            Revetement revetement = cbRevetement.getValue();
            
            double hauteurmur = Double.parseDouble(tfh.getText());
            
            // double surface = hauteurmur * Math.sqrt(Math.pow((debut.getX()-fin.getX()),2)+Math.pow(debut.getY()-fin.getY(), 2));
            // Modifié :
            double surface = hauteurmur * Math.sqrt(Math.pow((debut.getX()-fin.getX()),2)+Math.pow(debut.getY()-fin.getY(), 2))-porteTexte*2.1*0.9-fenetreTexte*1.2*1.2;
           
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
                 
                 int porteTexte = Integer.parseInt(tfporte.getText()); // parse int sert à mettre le txt en int
                 int fenetreTexte = Integer.parseInt(tffenetre.getText());
                 double hauteurmurad = Double.parseDouble(tfh.getText());
                 
                 Revetement revetement = cbRevetement.getValue();
                 
                 Mur m = new Mur(coin,coin1,revetement,hauteurmurad, fenetreTexte, porteTexte);
                 System.out.println("nouveau Mur "+ coin.getIdCoin() + " "+coin1.getIdCoin()+" "+revetement.getDesignation());
                 
                 cbDebut.setValue(null);
                 cbFin.setValue(null);
                 cbRevetement.setValue(null);
                 tffenetre.setText("");
                 tfporte.setText("");
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
