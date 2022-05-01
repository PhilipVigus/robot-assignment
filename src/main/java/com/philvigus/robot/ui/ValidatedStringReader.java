package com.philvigus.robot.ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** The validated string reader class. */
public class ValidatedStringReader {
  /** The UI used by the reader. */
  protected final Ui ui;

  /** The prompt displayed. */
  protected final String prompt;

  /** The regex pattern the input must match. */
  protected final Pattern pattern;

  /** The error displayed if the input doesn't match. */
  protected final String error;

  /**
   * Instantiates a new Validated string reader.
   *
   * @param ui the ui
   * @param prompt the prompt seen before input is requested
   * @param regex the regex to match the input against
   * @param error the error seen if the input does not match
   */
  public ValidatedStringReader(
      final Ui ui, final String prompt, final String regex, final String error) {
    this.ui = ui;
    this.prompt = prompt;
    this.pattern = Pattern.compile(regex);
    this.error = error;
  }

  /**
   * Read the input string.
   *
   * @return the validated string
   */
  public String readInput() {
    final String input = ui.getInput(prompt);
    final Matcher matcher = pattern.matcher(input);

    if (!matcher.matches()) {
      ui.displayMessage(error);
      return readInput();
    }

    return input;
  }
}
