package com.philvigus.robot.controller;

import com.philvigus.robot.Robot;
import com.philvigus.robot.exceptions.InvalidFieldException;
import com.philvigus.robot.parsers.Parser;
import com.philvigus.robot.ui.MovesReader;
import com.philvigus.robot.ui.PositionAndDirectionReader;
import com.philvigus.robot.ui.RoomSizeReader;
import com.philvigus.robot.ui.Ui;
import com.philvigus.robot.world.Direction;
import com.philvigus.robot.world.Room;

import java.util.Map;

/**
 * The Controller class.
 */
public class Controller {
  private final Parser parser;
  private final Ui ui;
  private Robot robot;

  /**
   * Instantiates a new Controller.
   *
   * @param ui the ui
   * @param parser the parser
   */
public Controller(final Ui ui, final Parser parser) {
    this.ui = ui;
    this.parser = parser;
  }

  /**
   * Start.
   */
public void start() {
    initialiseRobot();
    moveRobot();
  }

  private void initialiseRobot() {
    final RoomSizeReader roomSizeReader = new RoomSizeReader(ui);
    final String roomSize = roomSizeReader.readInput();
    final Room room = parser.parseRoom(roomSize);

    final PositionAndDirectionReader positionAndDirectionReader =
        new PositionAndDirectionReader(ui, room);
    final String positionAndDirection = positionAndDirectionReader.readInput();

    final Map<String, Integer> position = parser.parsePosition(positionAndDirection);
    final Direction direction = parser.parseDirection(positionAndDirection);

    this.robot = new Robot(direction, position.get("x"), position.get("y"), room);
  }

  private void moveRobot() {
    final MovesReader movesReader = new MovesReader(ui);
    final String movesString = movesReader.readInput();

    final String[] moves = movesString.split("");

    for (final String move : moves) {
      try {
        switch (move) {
          case "F" -> robot.moveForward();
          case "L" -> robot.turnLeft();
          case "R" -> robot.turnRight();
        }
      } catch (InvalidFieldException e) {
        ui.displayMessage(e.getMessage());
      }
    }

    ui.displayMessage(robot.getReport());

    moveRobot();
  }
}
