package com.philvigus.robot.world;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** The Direction enum. */
// TODO: should implement an interface
public enum Direction {
  /** N direction. */
  N(0),
  /** E direction. */
  E(1),
  /** S direction. */
  S(2),
  /** W direction. */
  W(3);

  // Used to get a Direction from a position
  private static final Map<Integer, Direction> BY_POSITION = new ConcurrentHashMap<>();

  static {
    for (final Direction d : values()) {
      BY_POSITION.put(d.position, d);
    }
  }

  private final Integer position;

  Direction(final Integer position) {
    this.position = position;
  }

  /**
   * Turn right.
   *
   * @return the new direction after turning right
   */
  public Direction turnRight() {
    if (this.position == 3) {
      return Direction.N;
    }

    return BY_POSITION.get(this.position + 1);
  }

  /**
   * Turn left.
   *
   * @return the new direction after turning left
   */
  public Direction turnLeft() {
    if (this.position == 0) {
      return Direction.W;
    }

    return BY_POSITION.get(this.position - 1);
  }
}
