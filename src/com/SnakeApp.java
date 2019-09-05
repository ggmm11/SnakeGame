package com;

import java.awt.Dimension;
import java.awt.event.ContainerListener;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;

import javax.swing.*;

public class SnakeApp {

    public void init(){
        JFrame window = new JFrame("Snake Game");
        Grid myGrid = new Grid(50*Settings.DEFAULT_NODE_SIZE,50*Settings.DEFAULT_NODE_SIZE);
        GameView gameView = new GameView(myGrid);
        gameView.init();
        GameController gameController = new GameController(myGrid);

        window.setPreferredSize(new Dimension(500,500)); // set up the window's size

        window.add(gameView.getCanvas(), BorderLayout.CENTER); // add the component into the window

        gameView.draw(); // draw the board and the snake

        window.setResizable(false); // the window's size can not be changed

        window.addKeyListener((KeyListener)gameController);

        new Thread(gameController).start(); // start the new thread

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // The action of exit the window

        // Rendering and display the window
        window.pack();
        window.setVisible(true);
    }

    public static void main(String[] args){
        SnakeApp snakeApp = new SnakeApp();
        snakeApp.init();
    }
}
