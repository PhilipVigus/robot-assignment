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
   *
   *  TODO:
   *  Pass an instance of Robot in here, which would be an interface rather
   *  than a concrete class
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
    displayStatusReport();
  }

  /**
   * TODO:
   * Not happy with this function at all. You can tell I rushed it at the
   * end to get the project working within the given time.
   *
   * As a minimum I would extract private functions to get the different parsed variables
   * and use them to initialise the robot
   */
  private void initialiseRobot() {
    final RoomSizeReader roomSizeReader = new RoomSizeReader(ui);
    final String roomSize = roomSizeReader.readInput();
    final Room room = parser.parseRoom(roomSize);

    final PositionAndDirectionReader positionAndDirectionReader =
        new PositionAndDirectionReader(ui, room);
    final String positionAndDirection = positionAndDirectionReader.readInput();

    final Map<String, Integer> position = parser.parsePosition(positionAndDirection, room);
    final Direction direction = parser.parseDirection(positionAndDirection);

    /**
     * TODO:
     * It doesn't make sense to create the robot here. What I would do instead
     * is to add a no-args constructor to the Robot class, pass an instance of Robot
     * into the constructor of this class and just set the values of that here.
     */
    this.robot = new Robot(direction, position.get("x"), position.get("y"), room);
  }

  /**
   * TODO:
   * This function is at the wrong level of abstraction compared to others in this
   * class. It is missing a MovesParser class, which would pass the String into a
   * sequence of moves and return those as a list. All this class would need to
   * do then would be to execute the moves.
   *
   * I'd also like to make it so the program doesn't automatically finish after
   * one set of movements. I'd have to have an elegant way of allowing the
   * user to exit with a command though, which would significantly change
   * the way the parsers are written.
   *
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
