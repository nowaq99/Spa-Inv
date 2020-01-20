package tests;

import model.Projectile;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectileTest {

    @Test
    void move() {
        Projectile projectile = new Projectile(30,20);
        int posY = projectile.getPositionY();
        projectile.move();
        int newPosY = projectile.getPositionY();
        Assert.assertTrue(posY > newPosY);
    }
}