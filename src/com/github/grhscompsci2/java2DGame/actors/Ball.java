package com.github.grhscompsci2.java2DGame.actors;

import com.github.grhscompsci2.java2DGame.Utility;

/**
 * This is an example bullet class that extends the Actor class. It only needs
 * to set the image, position and speed of the actor. The rest is handled in the
 * Board class.
 */
public class Ball extends Actor {
  public Ball(double bulX, double bulY, double vX, double vY) {
    super("ball.png", bulX, bulY, 300, Type.bullet);
    setDX(vX * getSpeed());
    setDY(vY * getSpeed());
  }

  /**
   * This method will remove bullets that have left the board area.
   */
  @Override
  public void hitEdge() {
    // TODO Auto-generated method stub
    if (getX() < 0 || getX() > Utility.gameWidth)
      setDX(getDX() * -1);
    if (getY() < 0)
      setDY(getDY() * -1);
    if (getY() > Utility.gameHeight)
      die();
  }

  /**
   * This method will remove bullets that have collided with another actor
   */
  @Override
  public void hitActor(Actor actor) {
    // if we did not hit another bullet
    int ballRight = getBounds().x + getBounds().width;
    int ballLeft = getBounds().x;
    int ballTop = getBounds().y;
    int ballBottom = getBounds().y + getBounds().height;

    int actorLeft = actor.getBounds().x;
    int actorRight = actor.getBounds().x + actor.getBounds().width;
    int actorTop = actor.getBounds().y;
    int actorBottom = actor.getBounds().y + actor.getBounds().height;

    if (ballLeft <= actorRight && ballRight > actorRight && ballTop < actorBottom && ballBottom > actorTop) {
      setDX(Math.abs(getDX()));
    } else if (ballRight >= actorLeft && ballLeft < actorLeft && ballTop < actorBottom && ballBottom > actorTop) {
      setDX(-1 * Math.abs(getDX()));
    } else {
      setDY(-1 * getDY());
    }
    // if (ballBottom >= actorTop && ballTop < actorTop){
    // setDY(-1*Math.abs(getDY()));
    // }else if(ballTop <= actorBottom && ballBottom > actorBottom) {
    // setDY(Math.abs(getDY()));
    // }

  }
}
