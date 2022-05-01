package com.philvigus.robot;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Direction {
  N(0),
  E(1),
  S(2),
  W(3);

  private static final Map<Integer, Direction> BY_POSITION = new ConcurrentHashMap<>();

  static {
    for (Direction d : values()) {
      BY_POSITION.put(d.position, d);
    }
  }

  private final Integer position;

  Direction(final Integer position) {
    this.position = position;
  }

  public Direction turnRight() {
    return BY_POSITION.get(this.position + 1);
  }
}
