package model;

import javafx.scene.layout.Pane;

public class MySpaceship extends Character{

    private int lives;
    private int score;

    final static int startVelocity = 10;

    public MySpaceship(int posX, int posY, int width, int height, Pane pane) {
        super(posX, posY, width, height);
    }


}
