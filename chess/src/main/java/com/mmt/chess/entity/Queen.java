package com.mmt.chess.entity;

import com.mmt.chess.ChessBoard;

public class Queen extends Entity {

    @Override
    public boolean isMoveValid(Integer[] move, ChessBoard chessBoard) {
        return true;
    }

}
