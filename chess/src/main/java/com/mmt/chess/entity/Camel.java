package com.mmt.chess.entity;

import com.mmt.chess.ChessBoard;

public class Camel extends Entity {

    @Override
    public boolean isMoveValid(Integer[] move, ChessBoard chessBoard) {
        int currX = move[0];
        int currY = move[1];
        int finalX = move[2];
        int finalY = move[3];

        boolean isFinalValid = currX != finalX && currY != finalY && Math.abs(currX - finalX) == Math.abs(currY - finalY);
        boolean isPathClear = isPathClear(move, chessBoard);

        return isFinalValid && isPathClear;
    }
}
