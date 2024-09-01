package com.mrs.spaceship.model;

import com.mrs.spaceship.model.game.elements.EnemyShot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyShotTest {
    private EnemyShot enemyShot;

    @BeforeEach
    void setUp() {
        enemyShot = new EnemyShot(10, 10);
    }

    @Test
    void enemyShotPosition() {
        Position position = new Position(10, 11);
        enemyShot.setPosition(position);
        assertEquals(10, enemyShot.getPosition().getX());
        assertEquals(11, enemyShot.getPosition().getY());
    }
}
