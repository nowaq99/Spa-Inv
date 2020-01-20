package tests;

import model.Character;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void updateBorders() {

        Character character = new Character(100,200,50,60);
        int rightBorder = character.getRightBorder();
        character.setWidth(10);
        character.updateBorders();
        int newRightBorder = character.getRightBorder();
        assertNotEquals(rightBorder, newRightBorder);

    }
}