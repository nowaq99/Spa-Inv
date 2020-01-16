package view;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import view.DrawableView;

public class CharacterView extends DrawableView{

    private Rectangle drawable = new Rectangle();
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