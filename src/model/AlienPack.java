package model;

import game.LevelConst;
import game.MainConst;

import java.util.List;

public class AlienPack {

    private List<Alien> aliens;

    public AlienPack(){

        int width = MainConst.paneWidth;
        int startX = width/2 - ((LevelConst.columns-1) * MainConst.packInterspaceX)/2;
        int startY = LevelConst.packStartY;
        int currentX = startX;
        int currentY = startY;

    }




}
