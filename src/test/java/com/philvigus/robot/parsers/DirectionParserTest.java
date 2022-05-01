package com.philvigus.robot.parsers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionParserTest {
  @Test
  void parseReturnsTheDirection() {
    DirectionParser parser = new DirectionParser();

    assertEquals("E", parser.parse("1 1 E"));
  }
}
