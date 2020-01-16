package model;

import game.MainConst;

public class Character {

    private int velocity;
    private int maxLeft;
    private int maxRight;
    private int maxTop;
    private int maxBottom;
    private int leftBorder;
    private int rightBorder;
    private int topBorder;
    private int bottomBorder;
    private int positionX;
    private int positionY;
    private int height;
    private int width;
    private boolean movingRight;
    private boolean movingLeft;
    private boolean shooting;


    public Character(int posX, int posY, int width, int height){

        setPositionX(posX);
        setPositionY(posY);
        setHeight(height);
        setWidth(width);

        updateBorders();
        setMaxLeft(0);
        setMaxRight(MainConst.paneWidth);
        setMaxBottom(MainConst.paneHeight);
        setMaxTop(0);
        setMovingLeft(false);
        setMovingRight(false);
        setShooting(false);

    }

    public Projectile shot(){

        int posX = this.getPositionX();
        int posY = this.getPositionY();

        return new Projectile(posX, posY);

    }

    public void move(){

        int posX = this.getPositionX();

        if(isMovingLeft() && !isMovingRight()){
            posX = getPositionX()-getVelocity();
            if (posX < getWidth()/2){
                posX = getWidth()/2;
            }
        } else if (isMovingRight() && !isMovingLeft()){
            posX = getPositionX()+getVelocity();
            if (posX > getMaxRight() - getWidth()/2){
                posX = getMaxRight() - getWidth()/2;
            }
        }

        setPositionX(posX);
        updateBorders();

    }

    public void updateBorders(){

        setBottomBorder(positionY + height/2);
        setTopBorder(positionY - height/2);
        setLeftBorder(positionX - width/2);
        setRightBorder(positionX + width/2);

    }

    public void setMaxTop(int maxTop) {
        this.maxTop = maxTop;
    }

    public void setMaxBottom(int maxBottom) {
        this.maxBottom = maxBottom;
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

    public int getMaxTop() {
        return maxTop;
    }

    public int getMaxBottom() {
        return maxBottom;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getMaxLeft() {
        return maxLeft;
    }

    public int getMaxRight() {
        return maxRight;
    }

    public int getLeftBorder() {
        return leftBorder;
    }

    public int getRightBorder() {
        return rightBorder;
    }

    public int getTopBorder() {
        return topBorder;
    }

    public int getBottomBorder() {
        return bottomBorder;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public boolean isShooting() {
        return shooting;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void setMaxLeft(int maxLeft) {
        this.maxLeft = maxLeft;
    }

    public void setMaxRight(int maxRight) {
        this.maxRight = maxRight;
    }

    public void setLeftBorder(int leftBorder) {
        this.leftBorder = leftBorder;
    }

    public void setRightBorder(int rightBorder) {
        this.rightBorder = rightBorder;
    }

    public void setTopBorder(int topBorder) {
        this.topBorder = topBorder;
    }

    public void setBottomBorder(int bottomBorder) {
        this.bottomBorder = bottomBorder;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }
}
