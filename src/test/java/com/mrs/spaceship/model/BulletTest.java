package com.mrs.spaceship.model;

import com.mrs.spaceship.model.game.elements.Bullet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulletTest {
    private Bullet bullet;

    @BeforeEach
    void setUp() {
        bullet = new Bullet(10, 10);
    }

    @Test
    void bulletPosition() {
        Position position = new Position(10, 9);
        bullet.setPosition(position);
        assertEquals(10, bullet.getPosition().getX());
        assertEquals(9, bullet.getPosition().getY());
    }

    @Test
    void bulletUp() {
        bullet.moveBulletUp();
        assertEquals(10, bullet.getPosition().getX());
        assertEquals(9, bullet.getPosition().getY());
    }

    @Test
    void bulletDown() {
        bullet.moveBulletDown();
        assertEquals(10, bullet.getPosition().getX());
        assertEquals(11, bullet.getPosition().getY());
    }
}
