# Robot Assignment

## Time spent

I noticed while running manual tests very late on that there was an issue with the coordinate system I had used. The
fix for this was not straightforward, and unfortunately led to me having to spend extra time on the project. In the
end I spent around 6-7 hours in total.

## Other issues/areas for improvement

In addition to the comments I've written against the code itself, this is a summary of the main points:

* Change use of 'Moves' to 'Commands' to match language used in task spec. This would involve renaming classes and
  instance variables as appropriate
* Rework the moveRobot function in the Controller class (see comments in the class itself for details)
* Introduce interfaces for the Parser and Robot to implement. At the moment, consumers of these classes are using
  concrete instances, which is not great. By using interfaces instead it would be possible to easily swap out different
  implementations
* Encapsulate input and output streams so that they can be more easily mocked. This should allow me to solve the issue
  with testing the different Reader classes. When I tried to mock the ConsoleUi class, it errored. I spent some time
  trying to work out why but eventually moved on.