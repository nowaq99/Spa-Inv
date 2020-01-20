package model;

import game.LevelConst;
import game.MainConst;

public class Rychu extends Alien{
    Rychu(int posX, int posY) {
        super(posX, posY, MainConst.RychuWidth, MainConst.RychuHeight);
        setPoints(LevelConst.RychuPoints);
    }
}
