package com.philvigus;

import com.philvigus.robot.ui.ConsoleUi;
import com.philvigus.robot.ui.RoomSizeReader;

public class Main {
  public static void main(String[] args) {
    ConsoleUi ui = new ConsoleUi(System.in, System.out);
    RoomSizeReader reader = new RoomSizeReader(ui);
    String prompt = reader.readInput();
    ui.displayMessage(prompt);
  }
}
