package com.mrs.spaceship.viewer;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.model.game.arena.Arena;
import com.mrs.spaceship.model.game.elements.*;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameViewerTest {
    Spaceship spaceship;
    List<Meteor> meteors = new ArrayList<>();
    List<Power> powers = new ArrayList<>();
    List<Limit> limits = new ArrayList<>();
    List<DefaultEnemy> defaultEnemies = new ArrayList<>();
    List<SpecialEnemy> specialEnemies = new ArrayList<>();
    List<EnemyShot> enemyShots = new ArrayList<>();
    List<DefaultShot> defaultShots = new ArrayList<>();
    List<DoubleShot> doubleShots = new ArrayList<>();
    List<BurstShot> burstShots = new ArrayList<>();
    List<TripleShot> tripleShots = new ArrayList<>();

    private Application application = new Application();
    private GUI gui;
    private Arena arena = new Arena(30, 30);
    private GameViewer gameViewer = new GameViewer(arena);

    public GameViewerTest() throws IOException, URISyntaxException, FontFormatException {
    }

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        spaceship = new Spaceship(25, 20);
        spaceship.setShot("defaultShot");
        arena.setSpaceship(spaceship);
        arena.setMeteors(Arrays.asList());
        arena.setPowers(Arrays.asList());
        arena.setLimits(Arrays.asList());
        arena.setDefaultEnemies(Arrays.asList());
        arena.setSpecialEnemies(Arrays.asList());
        arena.setEnemyShots(Arrays.asList());
        arena.setDefaultShots(Arrays.asList());
        arena.setDoubleShots(Arrays.asList());
        arena.setBurstShots(Arrays.asList());
        arena.setTripleShots(Arrays.asList());
        meteors.add(new Meteor(20,3));
        arena.setMeteors(meteors);
        powers.add(new Power(20, 20));
        arena.setPowers(powers);
        limits.add(new Limit(8,0));
        arena.setLimits(limits);
        defaultEnemies.add(new DefaultEnemy(15, 7, 3));
        arena.setDefaultEnemies(defaultEnemies);
        specialEnemies.add(new SpecialEnemy(15,1, 5));
        arena.setSpecialEnemies(specialEnemies);
        enemyShots.add(new EnemyShot(15,8));
        arena.setEnemyShots(enemyShots);
        defaultShots.add(new DefaultShot(25, 19));
        arena.setDefaultShots(defaultShots);
        doubleShots.add(new DoubleShot(25, 18));
        arena.setDoubleShots(doubleShots);
        burstShots.add(new BurstShot(25, 17));
        arena.setBurstShots(burstShots);
        tripleShots.add(new TripleShot(25, 16));
        arena.setTripleShots(tripleShots);
    }

    @Test
    void drawElements() throws IOException {
        gameViewer.draw(application, gui);
        Mockito.verify(gui, Mockito.times(1)).drawSpaceship(arena.getSpaceship().getPosition());
        for (Meteor meteor : arena.getMeteors()) {
            Mockito.verify(gui, Mockito.times(1)).drawMeteor(meteor.getPosition());
        }
        for (Power power : arena.getPowers()) {
            Mockito.verify(gui, Mockito.times(1)).drawPower(power.getPosition());
        }
        for (Limit limit : arena.getLimits()) {
            Mockito.verify(gui, Mockito.times(1)).drawLimits(limit.getPosition());
        }
        for (DefaultEnemy defaultEnemy : arena.getDefaultEnemies()) {
            Mockito.verify(gui, Mockito.times(1)).drawDefaultEnemies(defaultEnemy.getPosition());
        }
        for (SpecialEnemy specialEnemy : arena.getSpecialEnemies()) {
            Mockito.verify(gui, Mockito.times(1)).drawSpecialEnemies(specialEnemy.getPosition());
        }
        for (EnemyShot enemyShot : arena.getEnemyShots()) {
            Mockito.verify(gui, Mockito.times(1)).drawEnemyShots(enemyShot.getPosition());
        }
        for (DefaultShot defaultShot : arena.getDefaultShots()) {
            Mockito.verify(gui, Mockito.times(1)).drawDefaultShots(defaultShot.getPosition());
        }
        for (DoubleShot doubleShot : arena.getDoubleShots()) {
            Mockito.verify(gui, Mockito.times(1)).drawDoubleShots(doubleShot.getPosition());
        }
        for (BurstShot burstShot : arena.getBurstShots()) {
            Mockito.verify(gui, Mockito.times(1)).drawBurstShots(burstShot.getPosition());
        }
        for (TripleShot tripleShot : arena.getTripleShots()) {
            Mockito.verify(gui, Mockito.times(1)).drawTripleShots(tripleShot.getPosition());
        }
    }
}