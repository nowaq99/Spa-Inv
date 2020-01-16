package view;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;


public class MySpaceshipView extends CharacterView{

    public MySpaceshipView(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
        Image texture = new Image("textures/aaa1.png");
        setTexture1(texture);
        getDrawable().setFill(new ImagePattern(getTexture1()));
    }

}
