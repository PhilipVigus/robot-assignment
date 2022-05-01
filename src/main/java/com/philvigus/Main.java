package com.philvigus;

import com.philvigus.robot.controller.Controller;
import com.philvigus.robot.parsers.Parser;
import com.philvigus.robot.ui.ConsoleUi;
import com.philvigus.robot.ui.Ui;

public class Main {
  public static void main(String[] args) {
    Ui ui = new ConsoleUi(System.in, System.out);
    Parser parser = new Parser();

    Controller controller = new Controller(ui, parser);
    controller.start();
  }
}
