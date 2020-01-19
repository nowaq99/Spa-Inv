package model;

import java.util.List;

public class Level {

    private MySpaceship user = new MySpaceship();
    private AlienPack aliens = new AlienPack();
    private int time = 0;
    private List<Projectile> myProjectiles;
    private List<Projectile> alienProjectiles;

    public Level(){

    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public MySpaceship getUser() {
        return user;
    }

    public AlienPack getAliens() {
        return aliens;
    }

    public List<Projectile> getMyProjectiles() {
        return myProjectiles;
    }

    public List<Projectile> getAlienProjectiles() {
        return alienProjectiles;
    }
}
