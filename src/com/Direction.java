package com;
/*
 * Control the snake's direction
 */
public enum Direction {
    UP(0),
    RIGHT(1),
    DOWN(2),
    LEFT(3); // Call the constructor to initialize the direction enumeration instance

    private final int directionCode;

    public int directionCode (){
        return directionCode;
    }

    //Constructor
    Direction(int directionCode){
        this.directionCode = directionCode;
    }
}
