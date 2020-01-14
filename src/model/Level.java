package model;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Level {

    private Pane pane = new Pane();
    private Scene scene = new Scene(pane);

    public Level(){

    }

    public Pane getPane() {
        return pane;
    }

    public Scene getScene() {
        return scene;
    }
}
