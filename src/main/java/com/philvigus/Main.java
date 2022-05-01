package com.philvigus;

import com.philvigus.robot.ui.ConsoleUi;
import com.philvigus.robot.ui.ValidatedStringReader;

public class Main {
  public static void main(String[] args) {
    ConsoleUi ui = new ConsoleUi(System.in, System.out);
    ValidatedStringReader reader = new ValidatedStringReader(ui, "prompt", "test", "error");
    String prompt = reader.readInput();
    ui.displayMessage(prompt);
  }
}
