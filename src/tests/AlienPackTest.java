package tests;

import model.Alien;
import model.AlienPack;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienPackTest {

    @Test
    void move() {

        AlienPack aliens = new AlienPack();

        for (Alien alien : aliens.getList()){

            int posX = alien.getPositionX();
            alien.move();
            int newPosX = alien.getPositionX();
            Assert.assertTrue(newPosX > posX);

        }

    }
}