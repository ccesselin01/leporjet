package com.insa.ccesselin01.interfacegraphique;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author cesselin01
 */
public class Welcome extends Application {

    private Stage primaryStage;

    public Welcome(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Welcome() {
    }
    
@Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Bienvenue");
        Sceneoutil.setAppIcon(primaryStage);
        Label welcomeLabel = new Label("Bonjour ! Cliquez pour démarrer");
        welcomeLabel.getStyleClass().add("welcome-label");
        Button startButton = new Button("Start");
        startButton.getStyleClass().add("start-button");
        startButton.setOnAction(e -> {
            Ouverture ouverture = new Ouverture();
            try {
                ouverture.start(primaryStage);
            } catch (IOException ex) {
                ex.printStackTrace(); // ou gérer l'erreur de manière appropriée
            }
        });
          
            //primaryStage.close();
        //});

        Image image = new Image(getClass().getResource("/logo_porjet.png").toExternalForm());
        ImageView logoView = new ImageView(image);
        logoView.setFitWidth(300);
        logoView.setPreserveRatio(true);

        VBox welcomeLayout = new VBox(20);
        welcomeLayout.getStyleClass().add("welcome-layout");
        welcomeLayout.getChildren().addAll(logoView, welcomeLabel, startButton);

        Scene welcomeScene = new Scene(welcomeLayout, 600, 400);
        welcomeScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setScene(welcomeScene);
        primaryStage.show();
    }
    
}
