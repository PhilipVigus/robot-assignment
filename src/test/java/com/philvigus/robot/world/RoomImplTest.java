package com.philvigus.robot.world;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoomImplTest {
  @Test
  void isValidFieldShouldReturnTrueIfTheFieldIsValid() {
    RoomImpl room = new RoomImpl(3, 4);

    assertTrue(room.isValidField(1, 1));
  }

  @Test
  void isValidFieldShouldReturnFalseIfXIsLessThanZero() {
    RoomImpl room = new RoomImpl(3, 4);

    assertFalse(room.isValidField(-1, 1));
  }

  @Test
  void isValidFieldShouldReturnFalseIfYIsLessThanZero() {
    RoomImpl room = new RoomImpl(3, 4);

    assertFalse(room.isValidField(1, -1));
  }

  @Test
  void isValidFieldShouldReturnFalseIfXIsMoreThanWidth() {
    RoomImpl room = new RoomImpl(3, 4);

    assertFalse(room.isValidField(4, 1));
  }

  @Test
  void isValidFieldShouldReturnFalseIfYIsMoreThanWidth() {
    RoomImpl room = new RoomImpl(3, 4);

    assertFalse(room.isValidField(5, -1));
  }
}
