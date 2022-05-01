package com.philvigus.robot.parsers;

import com.philvigus.robot.world.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoomSizeParserTest {
  @Test
  void parseReturnsARoom() {
    RoomSizeParser parser = new RoomSizeParser();
    Room room = parser.parse("1 1");

    // TODO: Don't like the way I'm testing this. Would probably be better with getters
    assertTrue(room.isValidField(1, 1));
    assertFalse(room.isValidField(2, 1));
    assertFalse(room.isValidField(1, 2));
  }
}
