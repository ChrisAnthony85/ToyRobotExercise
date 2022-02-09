### How to run:
You can check this out from github https://github.com/ChrisAnthony85/ToyRobotExercise.git then build it and run. A jar file 
will also be provided via Google drive link that can be launched using java -jar.

### How to use:
The app will keep on asking for a new command <"WHAT IS YOUR COMMAND?"> after each previous command has been
successfully accomplished or successfully ignored.  The app will only exit if an unknown edge case of uncaught exception
occurs.  All inputs are from standard input and are CASE-INSENSITIVE.  In case of Left and Right Commands it can
be shortened to just 'L' or 'R'.  Otherwise all the other commands have to be spelled correctly.  The PLACE command has to
have a spaces or commas as delimiters to separate each argument. e.g.< PLACE,x,y,North >; or < place x y NORTH > or 
combinations are acceptable. Extra Whitespaces in commands are trimmed.
 
Appropriate Invalid Command and other error messages are displayed when the Robot Ignores
commands.  Successful Move, Place and Turn commands will not display any message and instead continue to ask for the next
command.

As a bonus a simple draw method was added for terminal graphical representation of the play area whenever
**REPORT** command is called while the toy is already in place.  

Have fun calling **REPORT** after placing the toy for the graphical updates.

Enjoy!




### Description and requirements:

The application is a simulation of a toy robot moving on a square table top, of dimensions 5 units x 5 units. There are no
other obstructions on the table surface. The robot is free to roam around the surface of the table, but must be prevented
from falling to destruction. Any movement that would result in the robot falling from the table must be prevented,
however further valid movement commands must still be allowed.
Create a console application that can read in commands of the following form -
 **PLACE** X,Y,F
 **MOVE**
 **LEFT**
 **RIGHT**
 **REPORT**

**PLACE** will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST. The origin (0,0)
can be considered to be the SOUTH WEST most corner. It is required that the first command to the robot is a PLACE
command, after that, any sequence of commands may be issued, in any order, including another PLACE command. The
application should discard all commands in the sequence until a valid PLACE command has been executed.

**MOVE** will move the toy robot one unit forward in the direction it is currently facing.

**LEFT** and **RIGHT** will rotate the robot 90 degrees in the specified direction without changing the position of the robot.

**REPORT** will announce the X,Y and F of the robot. This can be in any form, but standard output is sufficient.

A robot that is not on the table can choose to ignore the **MOVE**, **LEFT**, **RIGHT** and **REPORT** commands.

Input can be from a file, or from standard input, as the developer chooses.

Provide test data to exercise the application.

It is not required to provide any graphical output showing the movement of the toy robot.

The application should handle error states appropriately and be robust to user input.


**Constraints:**
The toy robot must not fall off the table during movement. This also includes the initial placement of the toy robot. Any
move that would cause the robot to fall must be ignored.