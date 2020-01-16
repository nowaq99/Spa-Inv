package view;

import javafx.scene.paint.ImagePattern;
import textures.Textures;

public class MySpaceshipView extends CharacterView{

    public MySpaceshipView(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
        setTexture1(Textures.mySpaceshipTexture);
        getDrawable().setFill(new ImagePattern(getTexture1()));
    }

}
