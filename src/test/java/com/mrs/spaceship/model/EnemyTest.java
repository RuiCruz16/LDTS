package com.mrs.spaceship.model;

import com.mrs.spaceship.model.game.elements.DefaultEnemy;
import com.mrs.spaceship.model.game.elements.SpecialEnemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyTest {
    private DefaultEnemy defaultEnemy;
    private SpecialEnemy specialEnemy;

    @BeforeEach
    void setUp() {
        defaultEnemy = new DefaultEnemy(15,5, 3);
        specialEnemy = new SpecialEnemy(15, 1, 5);
    }

    @Test
    void reduceHealthDefaultEnemy() {
        defaultEnemy.reduceHealth(2);
        assertEquals(1, defaultEnemy.getHealth());
    }

    @Test
    void reduceHealthSpecialEnemy() {
        specialEnemy.reduceHealth(2);
        assertEquals(3, specialEnemy.getHealth());
    }

    @Test
    void defaultEnemyPosition() {
        Position position = new Position(16, 5);
        defaultEnemy.setPosition(position);
        assertEquals(16, defaultEnemy.getPosition().getX());
        assertEquals(5, defaultEnemy.getPosition().getY());
    }

    @Test
    void specialEnemyPosition() {
        Position position = new Position(16, 1);
        specialEnemy.setPosition(position);
        assertEquals(16, specialEnemy.getPosition().getX());
        assertEquals(1, specialEnemy.getPosition().getY());
    }
}
