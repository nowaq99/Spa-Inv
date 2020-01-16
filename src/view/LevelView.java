package view;

import game.MainConst;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.ArrayList;


public class LevelView {

    private Pane pane = new Pane();
    private Scene scene;
    private ArrayList<AlienView> alienViews;

    public LevelView(){
        setPane();
        scene = new Scene(pane);
    }

    public ArrayList<AlienView> getAlienViews() {
        return alienViews;
    }

    public void setPane (){
        pane.setPrefSize(MainConst.paneWidth, MainConst.paneHeight);
    }

    public Pane getPane() {
        return pane;
    }

    public Scene getScene() {
        return scene;
    }

}
