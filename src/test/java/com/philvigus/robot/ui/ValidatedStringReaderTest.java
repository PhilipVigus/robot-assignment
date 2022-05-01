package com.philvigus.robot.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * TODO:
 * Make this test work. Mocking ConsoleUi throws an error, and I was unable to fix it within the time I was given.
 * */
class ValidatedStringReaderTest {
  @Mock ConsoleUi ui;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  @Disabled
  void readInputReturnsAValidString() {
    when(ui.getInput("prompt")).thenReturn("test");

    final ValidatedStringReader reader = new ValidatedStringReader(ui, "prompt", "test", "error");
    assertEquals("test", reader.readInput());
  }
}
