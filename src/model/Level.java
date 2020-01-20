package model;

import java.util.List;

public class Level {

    private MySpaceship user = new MySpaceship();
    private AlienPack aliens = new AlienPack();
    private int time = 0;


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

}
