package com.mrs.spaceship.model;

import com.mrs.spaceship.model.game.elements.Spaceship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpaceshipTest {
    private Spaceship spaceship;

    @BeforeEach
    void setUp() {
        spaceship = new Spaceship(10, 10);
    }

    @Test
    void reduceEnergy() {
        spaceship.reduceEnergy();
        assertEquals(2, spaceship.getEnergy());
    }

    @Test
    void increaseEnergy() {
        spaceship.increaseEnergy();
        assertEquals(4, spaceship.getEnergy());
    }

    @Test
    void addScore() {
        spaceship.addScore(100);
        assertEquals(100, spaceship.getScore());
    }

    @Test
    void spaceshipPosition() {
        Position position = new Position(15, 15);
        spaceship.setPosition(position);
        assertEquals(15, spaceship.getPosition().getX());
        assertEquals(15, spaceship.getPosition().getY());
    }

    @Test
    void spaceshipShot() {
        spaceship.setShot("defaultShot");
        assertEquals("defaultShot", spaceship.getShot());
    }
}
