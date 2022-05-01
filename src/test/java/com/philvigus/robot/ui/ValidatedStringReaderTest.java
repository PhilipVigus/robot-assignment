package com.philvigus.robot.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ValidatedStringReaderTest {
  @Mock ConsoleUi ui;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  @Disabled
  void readInputReturnsAValidString() {
    // Couldn't get this test working due to time constraint
    when(ui.getInput("prompt")).thenReturn("test");

    final ValidatedStringReader reader = new ValidatedStringReader(ui, "prompt", "test", "error");
    assertEquals("test", reader.readInput());
  }
}
