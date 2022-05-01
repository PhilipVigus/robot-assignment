# Robot Assignment

## General issues/areas for improvement

In addition to the comments I've written against the code itself, this is a summary of the main points:

* Change use of 'Moves' to 'Commands' to match language used in task spec. This would involve renaming classes and
  instance variables as appropriate
* Rework the Controller class (see comments in the class itself for details)
* Introduce a Position class to encapsulate positions in the room. This would clean a lot of code up and remove a fair
  amount of code duplication
* Introduce interfaces for the Parser and Robot to implement. At the moment, consumers of these classes are using
  concrete instances, which is not great. By using interfaces instead it would be possible to easily swap out different
  implementations
* Encapsulate input and output streams so that they can be more easily mocked. This should allow me to solve the issue
  with testing the different Reader classes. When I tried to mock the ConsoleUi class, it errored. I spent some time
  trying to work out why but eventually moved on.
* I noticed while running manual tests that there was an issue with the coordinate system I had used. I had incorrectly
  assumed that the origin was in the bottom left, whereas the task specs imply the top left. The fix I put in place for
  this works, but unfortunately has made some tests that use coordinates in their asserts look really strange. Introduce
  a position class will help fix this, as I can convert between the internal and task-required coordinate systems within
  it