package com.insa.ccesselin01.interfacegraphique;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.util.Duration;



public class WelcomeWindow {

    private Stage primaryStage;

    public WelcomeWindow(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setupWelcomeWindow() {
        
        primaryStage.setTitle("");

        Sceneoutil.setAppIcon(primaryStage);

        //Label welcomeLabel = new Label("Bonjour ! Cliquez pour démarrer");
        //welcomeLabel.getStyleClass().add("welcome-label");

        Button startButton = new Button("Cliquez pour démarrer");
        startButton.getStyleClass().add("start-button");
        startButton.setOnAction(e -> {
            Stage secondStage = new Stage();
            Ouverture ouverture =new Ouverture(secondStage);
            ouverture.debut(secondStage);
            primaryStage.close();
        });

        Image image = new Image(getClass().getResource("/logo_porjet.png").toExternalForm());
        ImageView logoView = new ImageView(image);
        logoView.setFitWidth(500);
        logoView.setPreserveRatio(true);
       
        
        logoView.setOpacity(0); // Commencez avec une opacité de 0 (invisible)
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), logoView);
        fadeTransition.setToValue(1.0); // Opacité finale = 1 (complètement opaque)
        fadeTransition.play(); 

        VBox welcomeLayout = new VBox(20);
        welcomeLayout.getStyleClass().add("welcome-layout");
        welcomeLayout.getChildren().addAll(logoView, /* welcomeLabel,*/ startButton);

        Scene welcomeScene = new Scene(welcomeLayout, 900, 600);
        welcomeScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setScene(welcomeScene);
        primaryStage.show();
    }

}