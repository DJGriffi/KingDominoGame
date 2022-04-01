1. If testing in Windows: When starting a new game after entering player settings, the game board for each player opens completely minimized in the first round. Therefore, you will have to
maximize the game board for each player using the maximize symbol at the top right corner at the beginning of the game. The gameboards then stay maximized throughout the game. 
Please note that we are only facing this issue in Windows. The gameboards open completely maximized by default (as we intended them to) in MacOS and Linux. 

2. Load and Save: We were able to implement serialization and deserialization but we were unable to load the game into the state that it was saved in. Overall, 
we are able to save the game but unable to load it. The code for save and game is present in the 'Driver' class for your reference.

3. Color Vision Settings : We have added the option to change the color settings for labels, buttons, gameboard and most of the UI except for the dominoes as we believe
that there are enough symbols on the dominoes to differentiate between them.

4.  Playing With AI:  The human player has to press 'End Turn' after the AI has placed and selected its domino in each round.

5. We had originally mentioned a 'gameModeFrame' class in some of our early documention. We had planned to use that class for implementing different game modes but after
realizing that different game modes are not required for the project, we have excluded that class from our final jar file. However, the source code of that class is still present as it can be
used for future versions of the game.

6. The colourConfiguration.txt file must live in the same folder as the jar/java files.

7. Run the KingDomino.jar file via commandline interpreter (console/terminal) with command 'java -jar KingDomino.jar' (without the quotes)
If the jar file does not execute for some reason, download all .java files and the colourConfiguration.txt file into the same folder. Via a console/terminal
use the command 'javac *.java' (without quotes) and then use 'java Driver' (without quotes).

