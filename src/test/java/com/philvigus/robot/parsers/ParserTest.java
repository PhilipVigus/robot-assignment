package com.philvigus.robot.parsers;

import com.philvigus.robot.world.Direction;
import com.philvigus.robot.world.Room;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {
  @Test
  void parseDirectionShouldReturnTheDirection() {
    Parser parser = new Parser();

    assertEquals(Direction.E, parser.parseDirection("1 1 E"));
  }

  @Test
  void parsePositionShouldReturnThePosition() {
    Parser parser = new Parser();

    Map<String, Integer> position = parser.parsePosition("1 2 E");

    assertEquals(1, position.get("x"));
    assertEquals(2, position.get("y"));
  }

  @Test
  void parseReturnsARoom() {
    Parser parser = new Parser();
    Room room = parser.parseRoom("1 1");

    // TODO: Don't like the way I'm testing this. Would probably be better with getters
    assertTrue(room.isValidField(1, 1));
  }
}
