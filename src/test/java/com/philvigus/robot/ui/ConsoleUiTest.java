package com.philvigus.robot.ui;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleUiTest {
  @Test
  void displaysMessage() {
    final ByteArrayInputStream inputStream = new ByteArrayInputStream("".getBytes());

    final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    final PrintStream outputStream = new PrintStream(byteArrayOutputStream);

    final ConsoleUi consoleUi = new ConsoleUi(inputStream, outputStream);
    consoleUi.displayMessage("Test");

    final String outputText = byteArrayOutputStream.toString();

    assertEquals("Test\n", outputText);
  }

  @Test
  void getsInput() {
    final ByteArrayInputStream inputStream = new ByteArrayInputStream("Response\n".getBytes());
    final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    final PrintStream outputStream = new PrintStream(byteArrayOutputStream);

    final ConsoleUi consoleUiImpl = new ConsoleUi(inputStream, outputStream);
    final String response = consoleUiImpl.getInput("Prompt");

    assertEquals("Response", response);
  }
}
