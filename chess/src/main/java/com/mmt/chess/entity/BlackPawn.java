package com.mmt.chess.entity;

import com.mmt.chess.ChessBoard;

public class BlackPawn extends Entity {

    @Override
    public boolean isMoveValid(Integer[] move, ChessBoard chessBoard) {
        int currX = move[0];
        int currY = move[1];
        int finalX = move[2];
        int finalY = move[3];
        return currY == finalY && currX == finalX - 1;
    }

}
