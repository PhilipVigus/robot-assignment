package com.philvigus.robot.room;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
  @Test
  void getLengthShouldGetTheLength() {
    Room room = new Room(3, 4);

    assertEquals(4, room.getLength());
  }

  @Test
  void getWidthShouldGetTheWidth() {
    Room room = new Room(3, 4);

    assertEquals(3, room.getWidth());
  }

  @Test
  void isValidFieldShouldReturnTrueIfTheFieldIsValid() {
    Room room = new Room(3, 4);

    assertTrue(room.isValidField(1, 1));
  }

  @Test
  void isValidFieldShouldReturnFalseIfXIsLessThanZero() {
    Room room = new Room(3, 4);

    assertFalse(room.isValidField(-1, 1));
  }

  @Test
  void isValidFieldShouldReturnFalseIfYIsLessThanZero() {
    Room room = new Room(3, 4);

    assertFalse(room.isValidField(1, -1));
  }

  @Test
  void isValidFieldShouldReturnFalseIfXIsMoreThanWidth() {
    Room room = new Room(3, 4);

    assertFalse(room.isValidField(4, 1));
  }

  @Test
  void isValidFieldShouldReturnFalseIfYIsMoreThanWidth() {
    Room room = new Room(3, 4);

    assertFalse(room.isValidField(5, -1));
  }
}
