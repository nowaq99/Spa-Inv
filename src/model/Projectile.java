package model;

import game.MainConst;

public class Projectile {

    private int velocity;
    private int maxBottom;
    private int maxTop;
    private int positionX;
    private int positionY;
    private int height;
    private int width;
    private boolean movingUp;
    private boolean movingDown;
    private int id;
    private Property property;

    public enum Property {My, Alien, NULL}

    public Projectile(int posX, int posY){

        setPositionX(posX);
        setPositionY(posY);
        setHeight(MainConst.projectileHeight);
        setWidth(MainConst.projectileWidth);
        setMaxTop(0);
        setMaxBottom(MainConst.paneHeight);
        setMovingDown(false);
        setMovingUp(false);
        setVelocity(MainConst.projectileVelocity);
        setProperty(Property.NULL);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void move(){

        int posY = getPositionY();

        if (isMovingDown()){
            posY += getVelocity();
        } else {
            posY -= getVelocity();
        }

        setPositionY(posY);

    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getMaxBottom() {
        return maxBottom;
    }

    public void setMaxBottom(int maxBottom) {
        this.maxBottom = maxBottom;
    }

    public int getMaxTop() {
        return maxTop;
    }

    public void setMaxTop(int maxTop) {
        this.maxTop = maxTop;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }
}
