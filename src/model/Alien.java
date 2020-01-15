package model;

public class Alien extends Character{

    private boolean texture1;
    private int points;
    private Type type;


    public enum Type {Rick, Morty, Summer, NULL}

    public Alien(int posX, int posY, int width, int height){
        super(posX, posY, width, height);
        setType(Type.NULL);
    }

    public Projectile shot(){
        Projectile projectile = super.shot();
        projectile.setProperty(Projectile.Property.Alien);

        return projectile;
    }



    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
