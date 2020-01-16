package view;

import javafx.scene.shape.Rectangle;

public class DrawableView {

    private Rectangle drawable = new Rectangle();

    public DrawableView(int posX, int posY, int width, int height){

        drawable.setLayoutX(-(double)width/2);
        drawable.setLayoutY(-(double)height/2);

        drawable.setHeight(height);
        drawable.setWidth(width);

        drawable.setX(posX);
        drawable.setY(posY);

    }

    public void update(int posX, int posY){

        drawable.setX(posX);
        drawable.setY(posY);

    }

    public Rectangle getDrawable() {
        return drawable;
    }

}
