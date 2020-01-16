package view;

import javafx.scene.image.Image;

public class AlienView extends CharacterView {

    private Image texture2;

    public AlienView(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
    }

    public Image getTexture2() {
        return texture2;
    }

    public void setTexture2(Image texture2) {
        this.texture2 = texture2;
    }
}
