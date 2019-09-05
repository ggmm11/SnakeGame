package com;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

//import javax.swing.JOptionPane;
//import javax.swing.JPanel;

public class GameView {

    private final Grid grid;

    private static JPanel canvas;

    public void init(){
        canvas = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                drawGridBackground(graphics);
                drawSnake(graphics, grid.getSnake());
                drawFood(graphics, grid.getFood());
            }
        };
    }

    public static void draw(){
        canvas.repaint();
    }

    public JPanel getCanvas(){
        return canvas;
    }

    // constructor
    public GameView(Grid grid){ this.grid = grid; }

    public void drawSnake(Graphics graphics, Snake snake){
        Iterator<Node> it = snake.getBody().iterator();
        Node n = new Node(0, 0);
        n = it.next();
        this.drawSquare(graphics, n, Color.red); // color of snake head
        while(it.hasNext()){
            n = it.next();
            this.drawSquare(graphics, n, Color.green);
        }
    }

    public void drawFood(Graphics graphics, Node squareArea){
        this.drawCircle(graphics, squareArea, Color.black);
    }

    public static void showGameOverMessage(){
        JOptionPane.showMessageDialog(null, "Game Over", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    // draw the background for located the snake movement
    public void drawGridBackground(Graphics graphics){
        graphics.setColor(Color.gray);
        for(int i = 0; i< 50; i++){
            graphics.drawLine(0, i*Settings.DEFAULT_NODE_SIZE, this.grid.getWidth(),i*Settings.DEFAULT_NODE_SIZE);
        }

        for (int i = 0; i < 50; i++) {
            graphics.drawLine(i*Settings.DEFAULT_NODE_SIZE, 0, i*Settings.DEFAULT_NODE_SIZE, this.grid.getHeight());
        }
    }

    private void drawSquare(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = Settings.DEFAULT_NODE_SIZE;
        graphics.fillRect(squareArea.getX() , squareArea.getY(), size, size );

    }

    private void drawCircle(Graphics graphics, Node squareArea, Color color){
        graphics.setColor(color);
        int size = Settings.DEFAULT_NODE_SIZE;
        graphics.fillOval(squareArea.getX(), squareArea.getY(), size, size);
    }
}
