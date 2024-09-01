package com.mrs.spaceship.controller;

import com.mrs.spaceship.controller.game.ShootingController;
import com.mrs.spaceship.model.game.arena.Arena;
import com.mrs.spaceship.model.game.arena.ArenaBuilder;
import com.mrs.spaceship.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShootingControllerTest {
    Arena arena;
    ArenaBuilder arenaBuilder;
    Spaceship spaceship;
    DefaultShot defaultShot;
    BurstShot burstShot;
    TripleShot tripleShot;
    DoubleShot doubleShot;
    ShootingController shootingController;

    @BeforeEach
    void setUp() {
        arenaBuilder = new ArenaBuilder(20, 20);
        arena = arenaBuilder.createArena();
        spaceship = arena.getSpaceship();
        shootingController = new ShootingController(arena, spaceship);
    }

    @Test
    void addShots() {
        assertEquals(0, arena.getDefaultShots().size());
        assertEquals(0, arena.getDoubleShots().size());
        assertEquals(0, arena.getTripleShots().size());
        assertEquals(0, arena.getBurstShots().size());
        shootingController.defaultShots();
        shootingController.doubleShots();
        shootingController.burstShots();
        shootingController.tripleShots();
        assertEquals(1, arena.getDefaultShots().size());
        assertEquals(1, arena.getDoubleShots().size());
        assertEquals(3, arena.getTripleShots().size());
        assertEquals(1, arena.getBurstShots().size());
    }

    @Test
    void moveDefaultShots() {
        shootingController.defaultShots();
        assertEquals(spaceship.getPosition().moveUp(), arena.getDefaultShots().get(0).getPosition());
        shootingController.moveDefaultShots();
        assertEquals(spaceship.getPosition().moveUp().moveUp(), arena.getDefaultShots().get(0).getPosition());
        arena.getMeteors().add(new Meteor(spaceship.getPosition().getX(), spaceship.getPosition().getY() - 3));
        shootingController.moveDefaultShots();
        assertEquals(0, arena.getDefaultShots().size());
    }

    @Test
    void moveDoubleShots() {
        shootingController.doubleShots();
        assertEquals(spaceship.getPosition().moveUp(), arena.getDoubleShots().get(0).getPosition());
        shootingController.moveDoubletShots();
        assertEquals(spaceship.getPosition().moveUp().moveUp(), arena.getDoubleShots().get(0).getPosition());
        arena.getMeteors().add(new Meteor(spaceship.getPosition().getX(), spaceship.getPosition().getY() - 3));
        shootingController.moveDoubletShots();
        assertEquals(0, arena.getDoubleShots().size());
    }

    @Test
    void moveBurstShots() {
        shootingController.burstShots();
        assertEquals(spaceship.getPosition().moveUp(), arena.getBurstShots().get(0).getPosition());
        shootingController.moveBurstShots();
        assertEquals(spaceship.getPosition().moveUp().moveUp(), arena.getBurstShots().get(0).getPosition());
        arena.getMeteors().add(new Meteor(spaceship.getPosition().getX(), spaceship.getPosition().getY() - 3));
        shootingController.moveBurstShots();
        assertEquals(0, arena.getBurstShots().size());
    }

    @Test
    void moveTripleShots() {
        shootingController.tripleShots();
        assertEquals(spaceship.getPosition().moveUp(), arena.getTripleShots().get(0).getPosition());
        shootingController.moveTripleShots();
        assertEquals(spaceship.getPosition().moveUp().moveUp(), arena.getTripleShots().get(0).getPosition());
        arena.getMeteors().add(new Meteor(spaceship.getPosition().getX(), spaceship.getPosition().getY() - 3));
        shootingController.moveTripleShots();
        assertEquals(2, arena.getTripleShots().size());
    }
}
