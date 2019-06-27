package com.mmt.chess.entity;

import com.mmt.chess.ChessBoard;

public class Elephant extends Entity {

    @Override
    public boolean isMoveValid(Integer[] move, ChessBoard chessBoard) {
        int currX = move[0];
        int currY = move[1];
        int finalX = move[2];
        int finalY = move[3];
        boolean isFinalValid = false;
        if (currX == finalX) {
            isFinalValid = currY != finalY;
        } else if (currY == finalY) {
            isFinalValid = true;
        }

        boolean isPathClear = isPathClear(move, chessBoard);
        return isFinalValid && isPathClear;
    }
}
