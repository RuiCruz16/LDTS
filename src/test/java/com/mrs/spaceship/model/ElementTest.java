package com.mrs.spaceship.model;

import com.mrs.spaceship.model.game.elements.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementTest {
    private Element element;

    @BeforeEach
    void setUp() {
        element = new Element(10, 10);
    }

    @Test
    void elementPosition() {
        Position position = new Position(11, 11);
        element.setPosition(position);
        Assertions.assertEquals(11, element.getPosition().getX());
        Assertions.assertEquals(11, element.getPosition().getY());
    }
}
