package view;

import javafx.scene.paint.ImagePattern;
import textures.Textures;

public class ZdzichuView extends AlienView {

    public ZdzichuView(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
        setTexture1(Textures.ZdzichuTexture1);
        setTexture2(Textures.ZdzichuTexture2);
        getDrawable().setFill(new ImagePattern(getTexture1()));
    }

}
