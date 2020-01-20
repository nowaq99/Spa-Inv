package model;

public class Alien extends Character{

    private boolean texture1;
    private int points;


    Alien(int posX, int posY, int width, int height) {

        super(posX, posY, width, height);
        setTexture1(true);

    }

    public Projectile shot(){
        Projectile projectile = super.shot();
        projectile.setProperty(Projectile.Property.Alien);
        projectile.setMovingDown(true);
        projectile.setPositionY(getBottomBorder());
        return projectile;
    }


    public int getPoints() {
        return points;
    }

    void setPoints(int points) {
        this.points = points;
    }

    public boolean isTexture1() {
        return texture1;
    }

    public void setTexture1(boolean texture1) {
        this.texture1 = texture1;
    }
}
