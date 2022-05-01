package com.philvigus.robot.parsers;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionParserTest {
  @Test
  void parseShouldReturnThePosition() {
    PositionParser parser = new PositionParser();

    Map<String, Integer> position = parser.parse("1 2 E");

    assertEquals(1, position.get("x"));
    assertEquals(2, position.get("y"));
  }
}
