package model;

import game.LevelConst;
import game.MainConst;

import java.util.ArrayList;

public class AlienPack {

    private ArrayList<Alien> list = new ArrayList<>();

    private boolean movingRight;
    private boolean movingLeft;
    private int animationTime;
    private int shotTime;

    public AlienPack(){

        int width = MainConst.paneWidth;
        int startX = width/2 - ((LevelConst.columns-1) * MainConst.packInterspaceX)/2;
        int startY = LevelConst.packStartY;
        int currentX = startX;
        int currentY = startY;

        setMovingLeft(false);
        setMovingRight(true);

        setAnimationTime(LevelConst.packAnimTime);
        setShotTime(LevelConst.packShotTimePerUnit);

        for (int i = LevelConst.columns; i > 0; i--){

            for (int j = LevelConst.KrzychuRows; j > 0; j--){

                Alien newAlien = new Krzychu(currentX, currentY);
                list.add(newAlien);
                currentY += MainConst.packInterspaceY;

            }
            for (int j = LevelConst.RychuRows; j > 0; j--){

                Alien newAlien = new Rychu(currentX, currentY);
                list.add(newAlien);
                currentY += MainConst.packInterspaceY;

            }
            for (int j = LevelConst.ZdzichuRows; j > 0; j--){

                Alien newAlien = new Zdzichu(currentX, currentY);
                list.add(newAlien);
                currentY += MainConst.packInterspaceY;

            }
            currentY = startY;
            currentX += MainConst.packInterspaceX;
        }

        for (Alien alien : list){
            alien.setMovingRight(true);
        }

    }

    public void moveDown(){

        int newPosY;
        for (Alien alien : list) {
            newPosY = alien.getPositionY() + LevelConst.movePackDown;
            alien.setPositionY(newPosY);
            alien.updateBorders();
        }

    }

    public void move(){

        boolean possibilityRight = true;
        boolean possibilityLeft = true;

        for (Alien alien : list){
            if (alien.getLeftBorder() - alien.getVelocity() < alien.getMaxLeft()){
                possibilityLeft = false;
            }
            if (alien.getRightBorder() + alien.getVelocity() > alien.getMaxRight()){
                possibilityRight = false;
            }
        }

        if(possibilityLeft && movingLeft){
            for (Alien alien : list) {
                alien.move();
            }
        }

        if(!possibilityLeft && movingLeft){
            moveDown();
            for (Alien alien : list) {
                alien.setMovingRight(true);
                alien.setMovingLeft(false);
            }
            setMovingRight(true);
            setMovingLeft(false);
            setAnimationTime((int) (getAnimationTime() * 0.85));
        }

        if(possibilityRight && movingRight){
            for (Alien alien : list) {
                alien.move();
            }
        }

        if(!possibilityRight && movingRight){
            moveDown();
            for (Alien alien : list) {
                alien.setMovingRight(false);
                alien.setMovingLeft(true);
            }
            setMovingRight(false);
            setMovingLeft(true);
            setAnimationTime((int) (getAnimationTime() * 0.85));
        }

    }

    public int getShotTime() {
        return shotTime;
    }

    public void setShotTime(int shotTime) {
        this.shotTime = shotTime;
    }

    public int getAnimationTime() {
        return animationTime;
    }

    public void setAnimationTime(int animationTime) {
        this.animationTime = animationTime;
    }

    public ArrayList<Alien> getList() {
        return list;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }
}
