Release schedule plan *subject to change* 

Release 1 - 7 Nov
Implementation of card classes,
Functionality to add players,
Functionality to assign pawns (suspect) to each player,
Functionality to randomly pick the answer cards (susepect, room, weapon),
Functionality to distribute the remaining cards randomly amongst the players,
Notebook initial implemenatation.

Release 2 - 21 Nov
Game board initialisation,
Functionality for player movements around the board.

Release 3 - 5 Dec
Game turns functionality,
Accusations, 
Hypothesis,
Update notebook to include hypothesis etc.

Final sprint before 21 Dec release
GUI implementation hopefully,
Code refactor,
JUnit tests


KNOWN BUGS/MISSING FEATURES:
Skipping player turn after unsuccessful accusation,
Not updating other player's notebooks after hypothesis made,
Not checking room for hypothesis,
Player old icon remains on map after using secret passage,
Accusations not in notebook,
Fitting 2 players in 1 room,
Players with same first letter in name need new character

THINGS TO FIX/REFACTOR
Board scanner
Poor cohesion with movement in the cluedoboard class. Implement movement in a new Movement class.
Cluedo game should be implemented in a new class called Cluedo

