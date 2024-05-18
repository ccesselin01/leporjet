package com.insa.ccesselin01.interfacegraphique;

import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author cesse
 */
public class Sceneoutil {
 
    public static void setAppIcon(Stage stage) {
        stage.getIcons().add(new Image(Sceneoutil.class.getResourceAsStream("/petit_porjet.png")));
    }
}

