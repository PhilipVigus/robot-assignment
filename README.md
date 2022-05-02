# Robot Assignment

The project was written using IntelliJ IDEA and Maven targeting JDK 14. Building the project generates a JAR in the out
directory that can be run directly, or the project can be run from within the IDE itself.

## Issues/areas for improvement

In addition to the comments I've written against the code itself, this is a summary of the main points:

* The main unfinished area is around parsing the command string from the user. At the moment the Controller class does
  everything itself, which means the MoveRobot function is doing too much and is at the wrong level of abstraction. I
  would address this in the following way (which is basically an implementation of the Command pattern).
    * Introduce a parseCommands method on the Parser class. This would parse the command string into a list of Command
      instances.
    * There would be three Command classes (Forward, Left and Right), each implementing a Command interface with a
      single execute method.
    * The robot instance would be passed into each command's constructor, and the execute method would call the
      respective method on the robot to complete the command.
* Very late on in the project I identified an error in my coordinate system due to an incorrect assumption. This was
  fixed, but led to me having to spend a couple more hours on the project than intended.
* Parser, Robot and Direction should all be implementing interfaces to make it easier to swap in and out
  alternate implementations in consumer classes.
* 'Moves' needs to be changed to 'Commands' to match language used in task spec. This would involve renaming classes and
  instance variables as appropriate.
* I need to either work out why Mockito won't mock ConsoleUi, or write a mock of the UI interface (the latter is
  probably easier, but in the long run it's better to understand why mocking ConsoleUI is failing). This would
  allow me to add missing tests for the Reader classes.
* Create Input and Output interfaces and create implementations of these for System input and output and pass these into
  UI constructors. This would make it much easier to swap out different types of input and output, eg voice, joystick
  etc.
* All display strings need to be moved to a resource bundle.
* I need to validate numbers entered by users to prevent integer overflows.
* I initially started the project targeting JDK version 17. However, this caused a clash with Maven when I tried to
  build the project artifact from the command line with Maven. Downgrading to 14 fixed this so that I could progress
  with the project, but I need to work out what the problem is, as 17 should not have caused a problem.