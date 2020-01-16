package view;

import javafx.scene.paint.Color;

public class AlienProjectileView extends DrawableView{

    int id;

    public AlienProjectileView(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
        getDrawable().setFill(Color.RED);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
