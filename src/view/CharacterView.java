package view;

import javafx.scene.image.Image;

public class CharacterView extends DrawableView{

    private Image texture1;

    public CharacterView(int posX, int posY, int width, int height){
        super(posX, posY, width, height);
    }


    public Image getTexture1() {
        return texture1;
    }

    public void setTexture1(Image texture1) {
        this.texture1 = texture1;
    }

}