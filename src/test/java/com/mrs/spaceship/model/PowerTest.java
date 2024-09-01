package com.mrs.spaceship.model;

import com.mrs.spaceship.model.game.elements.Power;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerTest {
    private Power power;

    @BeforeEach
    void setUp() {
        power = new Power(10, 10);
    }

    @Test
    void powerPosition() {
        Position position = new Position(10, 11);
        power.setPosition(position);
        assertEquals(10, power.getPosition().getX());
        assertEquals(11, power.getPosition().getY());
    }
}
