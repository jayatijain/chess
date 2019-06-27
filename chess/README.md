What does this do?

Scope:
1. Initialise board with initial state of chess game
2. Take one move from either black or white in form of json
2. Check validity of move
    1. Check if move isn't outside board
    2. Check if move is 'valid' for the given piece. e.g: soldier can move only 1 move in front direction
3. Actually make the move
    1. On the board, put piece in its final position
    2. Set null in previous position
    
Out of scope:
1. Player related State - (Active/Inactive) and validations
2. Not all pieces have been implemented
3. Kill functionality
4. Many other functionalities, thread safety, multiplayer scenarios, etc
