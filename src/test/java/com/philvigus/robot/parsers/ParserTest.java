package com.philvigus.robot.parsers;

import com.philvigus.robot.world.Direction;
import com.philvigus.robot.world.Position;
import com.philvigus.robot.world.Room;
import com.philvigus.robot.world.RoomImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    final Position position = parser.parsePosition("1 2 E", room);

    assertEquals(1, position.getX());
    assertEquals(7, position.getY());
  }

  @Test
  void parseRoomReturnsARoom() {
    final Parser parser = new Parser();
    final Room room = parser.parseRoom("1 2");

    assertEquals(1, room.getWidth());
    assertEquals(2, room.getLength());
  }
}
