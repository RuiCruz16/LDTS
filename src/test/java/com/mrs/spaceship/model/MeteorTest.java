package com.mrs.spaceship.model;

import com.mrs.spaceship.model.game.elements.Meteor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeteorTest {
    private Meteor meteor;

    @BeforeEach
    void setUp() {
        meteor = new Meteor(10, 10);
    }

    @Test
    void meteorPosition() {
        Position position = new Position(10, 11);
        meteor.setPosition(position);
        assertEquals(10, meteor.getPosition().getX());
        assertEquals(11, meteor.getPosition().getY());
    }

    @Test
    void SpawnTime() {
        meteor.setLastSpawnTime(1000);
        assertEquals(1000, meteor.getLastSpawnTime());
    }
}
