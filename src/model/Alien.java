package model;

public class Alien extends Character{

    private boolean texture1;
    private int points;

    public Alien(int posX, int posY, int width, int height){
        super(posX, posY, width, height);

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isTexture1() {
        return texture1;
    }

    public void setTexture1(boolean texture1) {
        this.texture1 = texture1;
    }
}
