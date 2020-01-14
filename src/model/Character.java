package model;

import controller.CharacterController;
import javafx.scene.layout.Pane;

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
    private boolean movingRight;
    private boolean movingLeft;
    private boolean shooting;

    private CharacterController controller = new CharacterController(this);

    public Character(int posX, int posY, int width, int height, Pane pane){
        controller.firstSetup(posX, posY, width, height, pane);
    }

    public void setMaxTop(int maxTop) {
        this.maxTop = maxTop;
    }

    public void setMaxBottom(int maxBottom) {
        this.maxBottom = maxBottom;
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
