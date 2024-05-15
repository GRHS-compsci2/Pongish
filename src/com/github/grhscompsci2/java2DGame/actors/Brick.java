package com.github.grhscompsci2.java2DGame.actors;

public class Brick extends Actor {

    public Brick(double x, double y) {
        super("BlueBrick.png", x, y, 0, Type.enemy);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void hitEdge() {
    }

    @Override
    public void hitActor(Actor actor) {
    }

}
