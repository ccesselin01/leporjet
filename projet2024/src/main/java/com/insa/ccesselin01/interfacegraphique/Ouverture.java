package com.insa.ccesselin01.interfacegraphique;

/**
 *
 * @author jjuif01
 */
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.insa.ccesselin01.calcul.Revetement;
import com.insa.ccesselin01.calcul.RevetementDatabase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;


public class Ouverture {
   
    private Stage secondStage;

    public Ouverture(Stage secondStage) {
        this.secondStage = secondStage;
    }

    
    
    public void debut(Stage secondStage)  {
        
        
      
       secondStage.setTitle("Sélection des options");
       Sceneoutil.setAppIcon(secondStage);
        
        Button bNouveau = new Button("Créer un Nouveau projet");
        
        bNouveau.setOnAction(new EventHandler<ActionEvent>()  {
             @Override
             public void handle(ActionEvent t)  {
                 
                 try {
                    openNouveauProjet();
                    System.out.println("Nouveau Projet");
                    
                 } 
                 catch(FileNotFoundException err){
                 System.out.println( "Erreur :le fichier n’existe pas!\n "+err);}
                 catch (IOException err){
                 System.out.println(" Erreur :\n "+err);}
                 
                
                
             }
            
        });
        
        Button bOuvrir = new Button("Ouvrir un projet existant");
        
        bOuvrir.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent t) {
                System.out.println("nouveau");
                openProjetAncien(t);
                
             }
            
        });
        

        // Création d'un conteneur HBox pour les boutons
        HBox buttonContainer = new HBox();
        buttonContainer.setSpacing(30); // Espacement entre les boutons
        buttonContainer.setAlignment(Pos.CENTER); // Centrage horizontal des boutons
        buttonContainer.getChildren().addAll(bNouveau, bOuvrir);

        // Création du conteneur principal VBox
        VBox root = new VBox();
        root.setSpacing(20); // Espacement vertical entre les boutons et les bords de la fenêtre
        root.setPadding(new Insets(100)); // Marge intérieure de la fenêtre
        root.setAlignment(Pos.CENTER); // Centrage vertical des boutons
        root.getChildren().add(buttonContainer);
        Scene scene = new Scene(root, 900, 600);
        // Lier la largeur des boutons à la largeur de la fenêtre
        bNouveau.prefWidthProperty().bind(scene.widthProperty().divide(2));
        bOuvrir.prefWidthProperty().bind(scene.widthProperty().divide(2));

        // Lier la hauteur des boutons à la hauteur de la fenêtre
        bNouveau.prefHeightProperty().bind(scene.heightProperty().divide(6));
        bOuvrir.prefHeightProperty().bind(scene.heightProperty().divide(6));

        // Configuration de la scène et affichage de la fenêtre
        
        bNouveau.styleProperty().bind(Bindings.concat("-fx-font-size: ", bNouveau.widthProperty().divide(15)));
        bOuvrir.styleProperty().bind(Bindings.concat("-fx-font-size: ", bOuvrir.widthProperty().divide(15)));
        

        // Création de la scène
        
        secondStage.setScene(scene);
        showStage();
        
    }
    
     public void showStage() {
        secondStage.show();
    }
    
    private void openNouveauProjet() throws IOException {
        NouveauProjet newproj = new NouveauProjet();
        newproj.start(secondStage);
        Revetement.loadRevetement();
        
    }

    public void openProjetAncien(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(this.secondStage);
        if (f != null) {
            try {
                
                
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Problème durant la sauvegarde");
                alert.setContentText(ex.getLocalizedMessage());

                alert.showAndWait();
            } finally {
                //
            }
        }
    }
    
    
    
}
