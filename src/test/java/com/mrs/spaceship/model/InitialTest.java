package com.mrs.spaceship.model;

import com.mrs.spaceship.model.menu.Initial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InitialTest {
    private Initial initialMenu;

    @BeforeEach
    void setUp() {
        initialMenu = new Initial();
    }

    @Test
    void initialCredits() {
        assertEquals(0, initialMenu.getCredits());
    }
}
