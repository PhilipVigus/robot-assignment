package com.philvigus;

import com.philvigus.robot.ui.ConsoleUi;
import com.philvigus.robot.ui.PositionAndDirectionReader;
import com.philvigus.robot.ui.RoomSizeReader;
import com.philvigus.robot.world.RoomImpl;

public class Main {
  public static void main(String[] args) {
    ConsoleUi ui = new ConsoleUi(System.in, System.out);
    RoomSizeReader reader = new RoomSizeReader(ui);

    PositionAndDirectionReader positionAndDirectionReader =
        new PositionAndDirectionReader(ui, new RoomImpl(10, 10));
    String prompt = positionAndDirectionReader.readInput();
    ui.displayMessage(prompt);
  }
}
