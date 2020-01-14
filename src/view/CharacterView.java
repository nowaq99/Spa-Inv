package view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CharacterView {

    private Rectangle character = new Rectangle();
    private Pane pane = new Pane();
    private Color color = new Color(0,0,0, 1);

    public Color getColor() {
        return color;
    }

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
