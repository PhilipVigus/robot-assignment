package com.philvigus.robot.ui;

// TODO: Write tests

public class MovesReader extends ValidatedStringReader {
  public MovesReader(Ui ui) {
    super(
        ui,
        "Please enter the robot's moves",
        "^[LRF]+$",
        "Moves must be a string consisting of L, R or F");
  }
}
