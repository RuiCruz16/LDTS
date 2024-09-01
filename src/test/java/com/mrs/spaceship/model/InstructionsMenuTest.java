package com.mrs.spaceship.model;

import com.mrs.spaceship.model.menu.InstructionsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionsMenuTest {
    InstructionsMenu instructionsMenu;

    @BeforeEach
    void stepUp() {
        instructionsMenu = new InstructionsMenu();
    }

    @Test
    void instructionsMenuEntries() {
        instructionsMenu.nextEntry();
        assertEquals(true, instructionsMenu.isSelectedExit());
        instructionsMenu.previousEntry();
        assertEquals(true, instructionsMenu.isSelectedStay());
        assertEquals("⬤", instructionsMenu.getEntry(0));
        assertEquals("⬤", instructionsMenu.getEntry(1));
        assertEquals(0, instructionsMenu.getCurrentEntry());
        assertEquals(true, instructionsMenu.isSelected(0));
        assertEquals(2, instructionsMenu.getNumberEntries());

    }
}