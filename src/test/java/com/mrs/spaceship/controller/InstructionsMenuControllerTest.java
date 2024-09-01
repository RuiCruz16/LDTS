package com.mrs.spaceship.controller;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.controller.menu.InstructionsMenuController;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.menu.InstructionsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionsMenuControllerTest {
    InstructionsMenu instructionsMenu;
    InstructionsMenuController instructionsMenuController;
    Application application;

    @BeforeEach
    void setUp() {
        application = Mockito.mock(Application.class);
        instructionsMenu = Mockito.mock(InstructionsMenu.class);
        instructionsMenuController = new InstructionsMenuController(instructionsMenu);
    }

    @Test
    public void stepRight() throws IOException {
        Mockito.when(instructionsMenu.isSelectedStay()).thenReturn(true);
        instructionsMenuController.step(application, GUI.Action.RIGHT, 1000);
        Mockito.verify(instructionsMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(instructionsMenuController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(instructionsMenuController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepLeft() throws IOException {
        Mockito.when(instructionsMenu.isSelectedStay()).thenReturn(true);
        instructionsMenuController.step(application, GUI.Action.LEFT, 1000);
        Mockito.verify(instructionsMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(instructionsMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(instructionsMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepSelectStart() throws IOException {
        Mockito.when(instructionsMenu.isSelectedStay()).thenReturn(true);
        instructionsMenuController.step(application, GUI.Action.SELECT, 1000);
        Mockito.verify(instructionsMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(instructionsMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(instructionsMenuController.getModel(), Mockito.times(0)).isSelectedStay();
        Mockito.verify(instructionsMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepSelectExit() throws IOException {
        Mockito.when(instructionsMenu.isSelectedExit()).thenReturn(true);
        instructionsMenuController.step(application, GUI.Action.SELECT, 1000);
        Mockito.verify(instructionsMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(instructionsMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(instructionsMenuController.getModel(), Mockito.times(0)).isSelectedStay();
        Mockito.verify(instructionsMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }
}
