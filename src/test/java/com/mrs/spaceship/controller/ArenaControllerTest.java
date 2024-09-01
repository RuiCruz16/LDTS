package com.mrs.spaceship.controller;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.controller.game.*;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.Position;
import com.mrs.spaceship.model.game.arena.Arena;
import com.mrs.spaceship.model.game.arena.ArenaBuilder;
import com.mrs.spaceship.model.game.elements.*;
import com.mrs.spaceship.model.menu.Initial;
import com.mrs.spaceship.states.InitialState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaControllerTest {
    Application application;
    ArenaController arenaController;
    Arena arena;
    ArenaBuilder arenaBuilder;
    SpaceshipController spaceshipController;
    MeteorController meteorController;
    PowerController powerController;
    SpecialEnemyController specialEnemyController;
    DefaultEnemyController defaultEnemyController;
    Spaceship spaceship;
    InitialState initialState;

    @BeforeEach
    public void setUp() {
        application = Mockito.mock(Application.class);
        arenaBuilder = new ArenaBuilder(20, 20);
        arena = arenaBuilder.createArena();
        arenaController = new ArenaController(arena);
        spaceshipController = new SpaceshipController(arena);
        meteorController = new MeteorController(arena);
        powerController = new PowerController(arena);
        specialEnemyController = new SpecialEnemyController(arena);
        defaultEnemyController = new DefaultEnemyController(arena);
        spaceship = arena.getSpaceship();
        initialState = new InitialState(new Initial());
    }

    @Test
    public void stepMoveSpaceship() throws IOException {
        int x = spaceship.getPosition().getX();
        int y = spaceship.getPosition().getY();
        assertEquals(x, spaceship.getPosition().getX());
        assertEquals(y, spaceship.getPosition().getY());
        arenaController.step(application, GUI.Action.DOWN, 1000);
        assertEquals(x, spaceship.getPosition().getX());
        assertEquals(y+1, spaceship.getPosition().getY());
        arenaController.step(application, GUI.Action.UP, 1000);
        assertEquals(x, spaceship.getPosition().getX());
        assertEquals(y, spaceship.getPosition().getY());
        arenaController.step(application, GUI.Action.LEFT, 1000);
        assertEquals(x-1, spaceship.getPosition().getX());
        assertEquals(y, spaceship.getPosition().getY());
        arenaController.step(application, GUI.Action.RIGHT, 1000);
        assertEquals(x, spaceship.getPosition().getX());
        assertEquals(y, spaceship.getPosition().getY());
    }

    @Test
    public void stepMoveMeteor() throws IOException {
        Meteor meteor = arena.getMeteors().get(0);
        int y = meteor.getPosition().getY();
        assertEquals(4, arena.getMeteors().size());
        assertEquals(y, meteor.getPosition().getY());
        meteorController.moveMeteor(meteor, new Position(meteor.getPosition().getX(), meteor.getPosition().getY()+1), 1000);
        assertEquals(y+1, meteor.getPosition().getY());
        meteorController.moveMeteor(meteor, new Position(meteor.getPosition().getX(), meteor.getPosition().getY()+1), 1000);
        assertEquals(y+2, meteor.getPosition().getY());
        arenaController.step(application, GUI.Action.DOWN, 1000);
        assertEquals(y+3, meteor.getPosition().getY());
    }

    @Test
    public void stepMoveDefaultEnemy() throws IOException {
        DefaultEnemy defaultEnemy = arena.getDefaultEnemies().get(0);
        Position position = defaultEnemy.getPosition();
        assertEquals(position, defaultEnemy.getPosition());
        defaultEnemyController.moveDefaultEnemy(defaultEnemy, new Position(defaultEnemy.getPosition().getX(), defaultEnemy.getPosition().getY()+1));
        assertEquals(position.moveDown(), defaultEnemy.getPosition());
        defaultEnemyController.moveDefaultEnemy(defaultEnemy, new Position(defaultEnemy.getPosition().getX(), defaultEnemy.getPosition().getY()-1));
        assertEquals(position, defaultEnemy.getPosition());
        arenaController.step(application, GUI.Action.LEFT, 1000);
        assertNotEquals(position, defaultEnemy.getPosition());
    }

    @Test
    public void stepSpecialEnemy() throws IOException {
        SpecialEnemy specialEnemy = arena.getSpecialEnemies().get(0);
        Position position = specialEnemy.getPosition();
        arenaController.step(application, GUI.Action.UP, 1000);
        assertNotEquals(position, specialEnemy.getPosition());
    }

    @Test
    public void stepPower() throws IOException {
        Power power = new Power(5, 5);
        assertEquals(0, arena.getPowers().size());
        arena.getPowers().add(power);
        assertEquals(1, arena.getPowers().size());
        arenaController.step(application, GUI.Action.RIGHT, 1000);
        assertEquals(new Position(5, 6), power.getPosition());
    }

}