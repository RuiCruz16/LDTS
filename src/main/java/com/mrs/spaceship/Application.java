package com.mrs.spaceship;

import com.mrs.spaceship.gui.Interface;
import com.mrs.spaceship.model.menu.Initial;
import com.mrs.spaceship.states.InitialState;
import com.mrs.spaceship.states.State;

import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Application {

    private Interface gui;
    private State state;
    private int highestScore;
    private int credits;
    private static final String SCORE_FILE = "highest_score.txt";


    public Application() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new Interface(30, 30);
        this.state = new InitialState(new Initial());
        this.highestScore = loadHighestScore();
        this.credits = 0;
    }
    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException, InterruptedException {
        new Application().start();
    }

    public void setHighestScore(int highestScore) throws IOException {
        this.highestScore = highestScore;
        saveHighestScore(highestScore);

    }
    public int getHishestScore() { return highestScore; }

    public int getCredits() { return credits; }

    public void addCredit() { this.credits++; }

    public void useCredit() { this.credits--; }

    public boolean hasCredits() {
        return credits > 0;
    }

    public void setState(State state) { this.state = state; }

    public State getState() { return this.state; }

    private int loadHighestScore() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(SCORE_FILE), UTF_8)) {
            String line = reader.readLine();
            return Integer.parseInt(line);
        } catch (IOException | NumberFormatException e) {
            return 0;
        }
    }

    private void saveHighestScore(int score) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(SCORE_FILE), UTF_8)) {
            writer.write(Integer.toString(score));
        }
    }

    public void start() throws IOException, InterruptedException {
        int FPS = 10;
        int frameTime = 100/ FPS;
        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            if (sleepTime > 0) Thread.sleep(sleepTime);
        }
        gui.close();
    }

}
