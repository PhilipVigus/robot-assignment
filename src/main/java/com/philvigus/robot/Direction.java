package com.philvigus.robot;

public enum Direction {
  N(0), E(1), S(2), W(3);

  private final Integer position;

  Direction(final Integer position) {
    this.position = position;
  }
}
