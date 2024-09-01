package com.mrs.spaceship.model;

import com.mrs.spaceship.model.menu.DefeatMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefeatMenuTest {
    private DefeatMenu defeatMenu;

    @BeforeEach
    void setUp() {
        defeatMenu = new DefeatMenu();
    }

    @Test
    void defeatMenuEntries() {
        defeatMenu.nextEntry();
        assertEquals(true, defeatMenu.isSelectedExit());
        defeatMenu.previousEntry();
        assertEquals(true, defeatMenu.isSelectedStart());
        assertEquals("Rematch", defeatMenu.getEntry(0));
        assertEquals("Exit", defeatMenu.getEntry(1));
        assertEquals(0, defeatMenu.getCurrentEntry());
        assertEquals(true, defeatMenu.isSelected(0));
        assertEquals(2, defeatMenu.getNumberEntries());
    }
}
