package view;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class KrzychuView extends AlienView{

    public KrzychuView(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
        Image texture1 = new Image("textures/a3_1.png");
        setTexture1(texture1);
        Image texture2 = new Image("textures/a3_2.png");
        setTexture2(texture2);
        getDrawable().setFill(new ImagePattern(getTexture1()));
    }

}