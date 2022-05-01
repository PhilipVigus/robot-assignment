package com.philvigus.robot;

public class Robot {
  private Direction direction;
  private int x;
  private int y;

  public Robot(Direction direction, int x, int y) {
    this.direction = direction;
    this.x = x;
    this.y = y;
  }

  public Direction getDirection() {
    return direction;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void turnLeft() {
    direction = direction.turnLeft();
  }

  public void turnRight() {
    direction = direction.turnRight();
  }

  public void moveForward() {
    switch(direction) {
      case N -> moveNorth();
      case E -> moveEast();
      case S -> moveSouth();
      case W -> moveWest();
    }
  }

  private void moveNorth() {
    y++;
  }

  private void moveEast() {
    x++;
  }

  private void moveSouth() {
    y--;
  }

  private void moveWest() {
    x--;
  }
}
