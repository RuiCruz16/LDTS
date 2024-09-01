package com.mrs.spaceship.model;

import com.mrs.spaceship.model.game.elements.BurstShot;
import com.mrs.spaceship.model.game.elements.DefaultShot;
import com.mrs.spaceship.model.game.elements.DoubleShot;
import com.mrs.spaceship.model.game.elements.TripleShot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpaceshipShotsTest {
    private BurstShot burstShot;
    private DefaultShot defaultShot;
    private DoubleShot doubleShot;
    private TripleShot tripleShot;

    @BeforeEach
    void setUp() {
        burstShot = new BurstShot(10, 10);
        defaultShot = new DefaultShot(10, 10);
        doubleShot = new DoubleShot(10, 10);
        tripleShot = new TripleShot(10, 10);
    }

    @Test
    void positionBurstShot() {
        Position position = new Position(10, 9);
        burstShot.setPosition(position);
        assertEquals(10, burstShot.getPosition().getX());
        assertEquals(9, burstShot.getPosition().getY());
    }

    @Test
    void positionDefaultShot() {
        Position position = new Position(10, 9);
        defaultShot.setPosition(position);
        assertEquals(10, defaultShot.getPosition().getX());
        assertEquals(9, defaultShot.getPosition().getY());
    }

    @Test
    void positionDoubleShot() {
        Position position = new Position(10, 9);
        doubleShot.setPosition(position);
        assertEquals(10, doubleShot.getPosition().getX());
        assertEquals(9, doubleShot.getPosition().getY());
    }

    @Test
    void positionTripleShot() {
        Position position = new Position(10, 9);
        tripleShot.setPosition(position);
        assertEquals(10, tripleShot.getPosition().getX());
        assertEquals(9, tripleShot.getPosition().getY());
    }

    @Test
    void damageBurstShot() {
        assertEquals(1, burstShot.getDamage());
    }

    @Test
    void damageDefaultShot() {
        assertEquals(1, defaultShot.getDamage());
    }

    @Test
    void damageDoubleShot() {
        assertEquals(2, doubleShot.getDamage());
    }

    @Test
    void damageTripleShot() {
        assertEquals(1, tripleShot.getDamage());
    }
}
