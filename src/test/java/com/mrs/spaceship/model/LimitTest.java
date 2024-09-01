package com.mrs.spaceship.model;

import com.mrs.spaceship.model.game.elements.Limit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LimitTest {
    private Limit limit;

    @BeforeEach
    void setUp() {
        limit = new Limit(10, 10);
    }

    @Test
    void limitPosition() {
        Position position = new Position(10, 11);
        limit.setPosition(position);
        assertEquals(10, limit.getPosition().getX());
        assertEquals(11, limit.getPosition().getY());
    }
}
