package view;

import javafx.scene.paint.ImagePattern;
import textures.Textures;

public class KrzychuView extends AlienView{

    public KrzychuView(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
        setTexture1(Textures.KrzychuTexture1);
        setTexture2(Textures.KrzychuTexture2);
        getDrawable().setFill(new ImagePattern(getTexture1()));
    }

}