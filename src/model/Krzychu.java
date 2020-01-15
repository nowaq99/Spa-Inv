package model;

import game.LevelConst;
import game.MainConst;

public class Krzychu extends Alien{

    public Krzychu(int posX, int posY) {
        super(posX, posY, MainConst.KrzychuWidth, MainConst.KrzychuHeight);
        setPoints(LevelConst.KrzychuPoints);
    }

}
