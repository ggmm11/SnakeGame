package com;

import java.util.LinkedList;
import java.util.Iterator;

public class Snake {

    private LinkedList<Node> body = new LinkedList();

    public Node move(Direction direction){
        // regarding the direction to change the body of snake
        // return the last movement of snake tail's node
        Node n;
        switch(direction) {

            case UP:	n = new Node(this.getHead().getX(),this.getHead().getY()-Settings.DEFAULT_NODE_SIZE); break;
            case DOWN: n = new Node(this.getHead().getX(),this.getHead().getY()+Settings.DEFAULT_NODE_SIZE); break;
            case RIGHT: n = new Node(this.getHead().getX()+Settings.DEFAULT_NODE_SIZE,this.getHead().getY()); break;
            default: n = new Node(this.getHead().getX()-Settings.DEFAULT_NODE_SIZE,this.getHead().getY());
        }

        Node r = this.body.getLast();
        this.body.addFirst(n);
        this.body.removeLast();
        //System.out.println(this.body.getFirst());
        //System.out.println(this.body.getLast());

        return r;
    }

    // Fetch the head's node
    public Node getHead(){
        return body.getFirst();
    }

    // Add the tail's node
    public Node addTail(Node area){
        this.body.addLast(area);
        return area;
    }

    // Return the body set
    public LinkedList<Node> getBody(){
        return body;
    }

    // Determine the node is on the snake's body or not
    public boolean hasNode(Node node){
        Iterator<Node> it = body.iterator();
        Node n = new Node(0, 0);
        while(it.hasNext()){
            n = it.next();
            if(n.getX() == node.getX() && n.getY() == node.getY()){
                return true;
            }
        }
        return false;
    }
}
