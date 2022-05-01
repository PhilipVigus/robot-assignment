package com.philvigus.robot.ui;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleUiTest {
  @Test
  void displaysMessage() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream outputStream = new PrintStream(byteArrayOutputStream);

    ConsoleUi consoleUi = new ConsoleUi(outputStream);
    consoleUi.displayMessage("Test");

    String outputText = byteArrayOutputStream.toString();

    assertEquals("Test\n", outputText);
  }
}
