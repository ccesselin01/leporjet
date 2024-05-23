package com.insa.ccesselin01.interfacegraphique;


import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application{

    
    
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        WelcomeWindow sceneWelcome = new WelcomeWindow(primaryStage);
        sceneWelcome.setupWelcomeWindow();

    }

        
    }
    