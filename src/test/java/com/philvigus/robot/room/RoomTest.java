package com.philvigus.robot.room;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
