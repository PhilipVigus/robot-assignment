package com.philvigus.robot.parsers;

import com.philvigus.robot.world.Direction;
import com.philvigus.robot.world.Room;
import com.philvigus.robot.world.RoomImpl;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {
  @Test
  void parseDirectionShouldReturnTheDirection() {
    final Parser parser = new Parser();

    assertEquals(Direction.E, parser.parseDirection("1 1 E"));
  }

  @Test
  void parsePositionShouldReturnThePosition() {
    final Parser parser = new Parser();
    final Room room = new RoomImpl(10, 10);

    final Map<String, Integer> position = parser.parsePosition("1 2 E", room);

    assertEquals(1, position.get("x"));
    assertEquals(7, position.get("y"));
  }

  @Test
  void parseReturnsARoom() {
    final Parser parser = new Parser();
    final Room room = parser.parseRoom("1 1");

    // TODO: Don't like the way I'm testing this. Would probably be better with getters
    assertTrue(room.isValidField(1, 1));
  }
}
