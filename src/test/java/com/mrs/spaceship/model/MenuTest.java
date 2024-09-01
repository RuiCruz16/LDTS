package com.mrs.spaceship.model;

import com.mrs.spaceship.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MenuTest {
    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
    }

    @Test
    void menuEntries() {
        menu.nextEntry();
        assertEquals(true, menu.isSelectedInstructions());
        menu.previousEntry();
        assertEquals(true, menu.isSelectedStart());
        menu.nextEntry();
        menu.nextEntry();
        assertEquals(true, menu.isSelectedExit());
        menu.nextEntry();
        menu.previousEntry();
        assertEquals("Start", menu.getEntry(0));
        assertEquals("Instructions", menu.getEntry(1));
        assertEquals("Exit", menu.getEntry(2));
        assertEquals(2, menu.getCurrentEntry());
        assertEquals(true, menu.isSelected(2));
        assertEquals(3, menu.getNumberEntries());
    }
}
