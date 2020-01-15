package view;

import game.MainConst;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class LevelView {

    private Pane pane = new Pane();
    private Scene scene;

    public LevelView(){
        setPane();
        scene = new Scene(pane);
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
