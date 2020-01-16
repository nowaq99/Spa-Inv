package view;

import javafx.scene.paint.Color;

public class AlienProjectileView extends DrawableView{

    public AlienProjectileView(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
        getDrawable().setFill(Color.RED);
    }

}
