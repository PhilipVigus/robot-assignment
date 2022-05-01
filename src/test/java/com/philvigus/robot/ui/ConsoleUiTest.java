package com.philvigus.robot.ui;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleUiTest {
  @Test
  void displaysMessage() {
    ByteArrayInputStream inputStream = new ByteArrayInputStream("".getBytes());

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream outputStream = new PrintStream(byteArrayOutputStream);

    ConsoleUi consoleUi = new ConsoleUi(inputStream, outputStream);
    consoleUi.displayMessage("Test");

    String outputText = byteArrayOutputStream.toString();

    assertEquals("Test\n", outputText);
  }

  @Test
  void getsInput() {
    ByteArrayInputStream inputStream = new ByteArrayInputStream("Response\n".getBytes());
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    PrintStream outputStream = new PrintStream(byteArrayOutputStream);

    ConsoleUi consoleUiImpl = new ConsoleUi(inputStream, outputStream);
    String response = consoleUiImpl.getInput("Prompt");

    assertEquals("Response", response);
  }
}
