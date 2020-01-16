package view;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class ZdzichuView extends AlienView {

    public ZdzichuView(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
        Image texture1 = new Image("textures/a1_1.png");
        setTexture1(texture1);
        Image texture2 = new Image("textures/a1_2.png");
        setTexture2(texture2);
        getDrawable().setFill(new ImagePattern(getTexture1()));
    }

}
