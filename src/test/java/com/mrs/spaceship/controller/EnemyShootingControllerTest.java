package com.mrs.spaceship.controller;

import com.mrs.spaceship.controller.game.EnemyShootingController;
import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.game.arena.Arena;
import com.mrs.spaceship.model.game.arena.ArenaBuilder;
import com.mrs.spaceship.model.game.elements.DefaultEnemy;
import com.mrs.spaceship.model.game.elements.EnemyShot;
import com.mrs.spaceship.model.game.elements.Meteor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyShootingControllerTest {
    Arena arena;
    ArenaBuilder arenaBuilder;
    DefaultEnemy defaultEnemy1;
    EnemyShootingController enemyShootingController;
    DefaultEnemy defaultEnemy2;

    @BeforeEach
    void setUp() {
        arenaBuilder = new ArenaBuilder(20, 20);
        arena = arenaBuilder.createArena();
        enemyShootingController = new EnemyShootingController(arena, arena.getDefaultEnemies());
        defaultEnemy1 = arena.getDefaultEnemies().get(0);
    }

    @Test
    void addShot() {
        assertEquals(2, arena.getDefaultEnemies().size());
        assertEquals(0, arena.getEnemyShots().size());
        enemyShootingController.DefaultEnemyShots();
        assertEquals(2, arena.getEnemyShots().size());
    }

    @Test
    void moveEnemyShots() {
        enemyShootingController.DefaultEnemyShots();
        assertEquals(2, arena.getEnemyShots().size());
        assertEquals(defaultEnemy1.getPosition().getY()+1, arena.getEnemyShots().get(0).getPosition().getY());
        enemyShootingController.moveEnemyShots();
        assertEquals(defaultEnemy1.getPosition().getY()+2, arena.getEnemyShots().get(0).getPosition().getY());

    }

    @Test
    void hitMeteor() {
        enemyShootingController.DefaultEnemyShots();
        assertEquals(defaultEnemy1.getPosition().getY()+1, arena.getEnemyShots().get(0).getPosition().getY());
        arena.getMeteors().add(new Meteor(defaultEnemy1.getPosition().getX(), defaultEnemy1.getPosition().getY()+2));
        enemyShootingController.moveEnemyShots();
        assertEquals(0, arena.getEnemyShots().get(0).getPosition().getX());
        assertEquals(arena.getHeight(), arena.getEnemyShots().get(0).getPosition().getY());
    }

    @Test
    void hitSpaceShip() {
        enemyShootingController.DefaultEnemyShots();
        assertEquals(3, arena.getSpaceship().getEnergy());
        assertEquals(defaultEnemy1.getPosition().getY()+1, arena.getEnemyShots().get(0).getPosition().getY());
        arena.getSpaceship().setPosition(new Position(defaultEnemy1.getPosition().getX(), defaultEnemy1.getPosition().getY()+2));
        enemyShootingController.moveEnemyShots();
        assertEquals(0, arena.getEnemyShots().get(0).getPosition().getX());
        assertEquals(arena.getHeight(), arena.getEnemyShots().get(0).getPosition().getY());
        assertEquals(2, arena.getSpaceship().getEnergy());
    }

    @Test
    void cleanShots() {
        enemyShootingController.DefaultEnemyShots();
        arena.getEnemyShots().add(new EnemyShot(0, 20));
        assertEquals(3, arena.getEnemyShots().size());
        enemyShootingController.moveEnemyShots();
        assertEquals(2, arena.getEnemyShots().size());
    }
}
