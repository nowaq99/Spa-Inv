package tests;


import model.Alien;
import model.Projectile;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class AlienTest {

    @Test
    void shot() {
        Alien alien = new Alien(0,0,30,20);
        Projectile projectile = alien.shot();

        Assert.assertEquals(projectile.getPositionX(), alien.getPositionX()/2);
    }
}