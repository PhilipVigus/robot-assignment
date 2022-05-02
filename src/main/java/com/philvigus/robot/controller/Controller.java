package com.philvigus.robot.controller;

import com.philvigus.robot.Robot;
import com.philvigus.robot.exceptions.InvalidFieldException;
import com.philvigus.robot.parsers.Parser;
import com.philvigus.robot.ui.MovesReader;
import com.philvigus.robot.ui.PositionAndDirectionReader;
import com.philvigus.robot.ui.RoomSizeReader;
import com.philvigus.robot.ui.Ui;
import com.philvigus.robot.world.Direction;
import com.philvigus.robot.world.Position;
import com.philvigus.robot.world.Room;

/**
 * The Controller class.
 */
public class Controller {
  // TODO: should be an interface
  private final Parser parser;
  private final Ui ui;

  // TODO: should be an interface
  private final Robot robot;

  /**
   * Instantiates a new Controller.
   *
   * @param ui the ui
   * @param parser the parser
   *
   */
  // TODO: all arguments should be interfaces
  public Controller(final Ui ui, final Parser parser, Robot robot) {
    this.ui = ui;
    this.parser = parser;
    this.robot = robot;
  }

  /**
   * Start.
   */
public void start() {
    initialiseRobot();
    moveRobot();
    displayStatusReport();
  }

  private void initialiseRobot() {
    final Room room = initialiseRoom();

    final String positionAndDirection =
        new PositionAndDirectionReader(ui, room).readInput();

    final Position position = parser.parsePosition(positionAndDirection, room);
    final Direction direction = parser.parseDirection(positionAndDirection);

    robot.initialise(position, direction, room);
  }

  private Room initialiseRoom() {
    final String roomSize =  new RoomSizeReader(ui).readInput();

    return parser.parseRoom(roomSize);
  }

  /**
   * TODO:
   * This function is at the wrong level of abstraction compared to others in this
   * class. It is missing a MovesParser class, which would pass the String into a
   * sequence of moves and return those as a list of Command instances. The Command instances
   * would have execute methods which would call the respective methods on the robot.
   *
   * I'd also like to make it so the program doesn't automatically finish after
   * one set of movements. I'd have to have an elegant way of allowing the
   * user to exit with a command though, which would significantly change
   * the way the parsers are written.
   */
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
  }

  private void displayStatusReport() {
    ui.displayMessage(robot.getReport());
  }
}
