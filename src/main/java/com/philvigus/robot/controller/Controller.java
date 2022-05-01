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

public class Controller {
  private final Parser parser;
  private final Ui ui;
  private Robot robot;

  public Controller(Ui ui, Parser parser) {
    this.ui = ui;
    this.parser = parser;
  }

  public void start() {
    initialiseRobot();
    moveRobot();
  }

  private void initialiseRobot() {
    RoomSizeReader roomSizeReader = new RoomSizeReader(ui);
    String roomSize = roomSizeReader.readInput();
    Room room = parser.parseRoom(roomSize);

    PositionAndDirectionReader positionAndDirectionReader =
        new PositionAndDirectionReader(ui, room);
    String positionAndDirection = positionAndDirectionReader.readInput();

    Map<String, Integer> position = parser.parsePosition(positionAndDirection);
    Direction direction = parser.parseDirection(positionAndDirection);

    this.robot = new Robot(direction, position.get("x"), position.get("y"), room);
  }

  private void moveRobot() {
    MovesReader movesReader = new MovesReader(ui);
    String movesString = movesReader.readInput();

    String[] moves = movesString.split("");

    for (String move : moves) {
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
