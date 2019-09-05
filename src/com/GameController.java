package com;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener, Runnable{

    private Grid grid;
    private boolean running;
    private boolean over = false;

    GameController(Grid g){
        this.grid = g;
        this.running = true;
    }

    @Override
    public void keyPressed(KeyEvent e){
        int KeyCode = e.getKeyCode();

        switch(KeyCode){
            case KeyEvent.VK_UP: grid.changeDirection(Direction.UP); break;
            case KeyEvent.VK_DOWN: grid.changeDirection(Direction.DOWN); break;
            case KeyEvent.VK_LEFT: grid.changeDirection(Direction.LEFT); break;
            case KeyEvent.VK_RIGHT: grid.changeDirection(Direction.RIGHT); break;
        }

        isOver(grid.nextRound());
        GameView.draw();
    }

    @Override
    public void keyReleased(KeyEvent e){

    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    // after game over process
    public void isOver(boolean o){
        if(!o){
            this.running = false;
            GameView.showGameOverMessage();
            System.exit(0);
        }
    }

    @Override
    public void run(){
        while (running) {
            try {
                Thread.sleep(Settings.DEFAULT_MOVE_INTERVAL);
                isOver(grid.nextRound());
                GameView.draw();
            } catch (InterruptedException e) {
                break;
            }
            // If the game is over, then quit the game
            // If the game is continue, then draw the new board of the game
        }

        running = false;
    }
}
