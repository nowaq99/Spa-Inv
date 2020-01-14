package view;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class CharacterView {

    private Rectangle character = new Rectangle();
    private Pane pane = new Pane();

    public Rectangle getCharacter() {
        return character;
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

}
