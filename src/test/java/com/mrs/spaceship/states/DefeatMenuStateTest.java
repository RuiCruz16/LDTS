package com.mrs.spaceship.states;

import com.mrs.spaceship.Application;
import com.mrs.spaceship.gui.GUI;
import com.mrs.spaceship.model.game.arena.ArenaBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefeatMenuStateTest {
    DefeatMenuState defeatMenuState;
    GUI gui;
    Application application;

    @BeforeEach
    void setUp() {
        application = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);
        defeatMenuState = Mockito.mock(DefeatMenuState.class);
    }

    @Test
    void selectRematch() {
        GameState gameState = new GameState(new ArenaBuilder(30, 30).createArena());
        application.setState(gameState);
        assertEquals(null, application.getState());
    }

    @Test
    void selectExit() {
        application.setState(null);
        assertEquals(null, application.getState());
    }
}
