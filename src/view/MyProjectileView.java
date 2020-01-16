package view;

import javafx.scene.paint.Color;

public class MyProjectileView extends DrawableView{

    public MyProjectileView(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
        getDrawable().setFill(Color.GREEN);
    }

}
