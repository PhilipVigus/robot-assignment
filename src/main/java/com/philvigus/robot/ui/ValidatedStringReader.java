package com.philvigus.robot.ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatedStringReader {
  private final Ui ui;

  private final String prompt;

  private final Pattern pattern;

  private final String error;

  public ValidatedStringReader(Ui ui, String prompt, String regex, String error) {
    this.ui = ui;
    this.prompt = prompt;
    this.pattern = Pattern.compile(regex);
    this.error = error;
  }

  public String readInput() {
    String input = ui.getInput(prompt);
    Matcher matcher = pattern.matcher(input);

    if (!matcher.matches()) {
      ui.displayMessage(error);
      return readInput();
    }

    return input;
  }
}
