package view;

import javafx.scene.paint.Color;

public class MyProjectileView extends DrawableView{

    int id;

    public MyProjectileView(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
        getDrawable().setFill(Color.GREEN);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
