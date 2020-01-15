package model;

import game.LevelConst;
import game.MainConst;

public class Zdzichu extends Alien {
    public Zdzichu(int posX, int posY) {
        super(posX, posY, MainConst.ZdzichuWidth, MainConst.ZdzichuHeight);
        setPoints(LevelConst.ZdzichuPoints);
    }
}
