package model;

import game.LevelConst;
import game.MainConst;

public class MySpaceship extends Character{

    private int lives;
    private int score;

    public MySpaceship() {
        super(MainConst.mySpaceshipX, MainConst.mySpaceshipY, MainConst.mySpaceshipWidth, MainConst.mySpaceshipHeight);
        setLives(LevelConst.startLives);
        setScore(0);
        setVelocity(LevelConst.mySpaceshipStartVelocity);
    }

    public Projectile shot(){
        Projectile projectile = super.shot();
        projectile.setProperty(Projectile.Property.My);
        projectile.setMovingDown(true);
        projectile.setPositionY(getTopBorder());
        return projectile;
    }


    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
