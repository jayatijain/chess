package com.mmt.chess.entity;

import com.mmt.chess.ChessBoard;

public class WhitePawn extends Entity {

    @Override
    public boolean isMoveValid(Integer[] move, ChessBoard chessBoard) {
        int currX = move[0];
        int currY = move[1];
        int finalX = move[2];
        int finalY = move[3];

        return currX == finalX && currY == finalY + 1;

    }

}
