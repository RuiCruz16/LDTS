package com.mrs.spaceship.controller;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.controller.menu.InitialController;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.menu.Initial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class InitialControllerTest {
    Initial initial;
    Application application;
    InitialController initialController;
    @BeforeEach
    void setUp() {
        initial = Mockito.mock(Initial.class);
        application = Mockito.mock(Application.class);
        initialController = new InitialController(initial);
    }

    @Test
    public void stepSelect() throws IOException {
        initialController.step(application, GUI.Action.SELECT, 1000);
        assertNull(application.getState());
    }

    @Test
    public void stepCoin() throws IOException {
        assertEquals(0, application.getCredits());
        initialController.step(application, GUI.Action.COIN, 1000);
        assertNull(application.getState());
    }
}