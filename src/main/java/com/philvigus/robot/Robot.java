package com.philvigus.robot;

public class Robot {
  private Direction direction;

  public Robot(Direction direction) {
    this.direction = direction;
  }

  public Direction getDirection() {
    return direction;
  }

  public void turnLeft() {
    direction = direction.turnLeft();
  }

  public void turnRight() {
    direction = direction.turnRight();
  }
}
