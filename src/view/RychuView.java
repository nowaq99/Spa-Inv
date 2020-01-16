package view;

import javafx.scene.paint.ImagePattern;
import textures.Textures;

public class RychuView extends AlienView {

    public RychuView(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
        setTexture1(Textures.RychuTexture1);
        setTexture2(Textures.RychuTexture2);
        getDrawable().setFill(new ImagePattern(getTexture1()));
    }

}
