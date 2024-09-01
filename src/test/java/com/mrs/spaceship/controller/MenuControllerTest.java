package com.mrs.spaceship.controller;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.controller.menu.MenuController;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.menu.InstructionsMenu;
import com.mrs.spaceship.model.menu.Menu;
import com.mrs.spaceship.states.InstructionsMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MenuControllerTest {
    Application application;
    MenuController menuController;
    Menu menu;


    @BeforeEach
    void setUp() {
        menu = Mockito.mock(Menu.class);
        application = Mockito.mock(Application.class);
        menuController = new MenuController(menu);
    }

    @Test
    public void stepUp() {
        menuController.step(application, GUI.Action.UP, 1000);
        Mockito.verify(menuController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).isSelectedInstructions();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).isSelectedStart();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepDown() {
        menuController.step(application, GUI.Action.DOWN, 1000);
        Mockito.verify(menuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).isSelectedInstructions();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).isSelectedStart();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepSelectStart() {

        Mockito.when(menuController.getModel().isSelectedStart()).thenReturn(true);
        menuController.step(application, GUI.Action.SELECT, 1000);

        Mockito.verify(menuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedInstructions();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedStart();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepSelectSettings() {

        Mockito.when(menuController.getModel().isSelectedInstructions()).thenReturn(true);
        menuController.step(application, GUI.Action.SELECT, 1000);

        Mockito.verify(menuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedInstructions();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedStart();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepSelectExit() {

        Mockito.when(menuController.getModel().isSelectedExit()).thenReturn(true);
        menuController.step(application, GUI.Action.SELECT, 1000);

        Mockito.verify(menuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedInstructions();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedStart();
        Mockito.verify(application, Mockito.times(1)).setState(null);
    }

    @Test
    public void selectSettings() {
        menuController.step(application, GUI.Action.DOWN, 1000);
        menuController.step(application, GUI.Action.SELECT, 1000);
        InstructionsMenuState s=new InstructionsMenuState(new InstructionsMenu());
        application.setState(s);
        assertNull(application.getState());
    }
}
