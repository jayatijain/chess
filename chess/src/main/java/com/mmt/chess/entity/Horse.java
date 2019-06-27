package com.mmt.chess.entity;

import com.mmt.chess.ChessBoard;

public class Horse extends Entity {

    @Override
    public boolean isMoveValid(Integer[] move, ChessBoard chessBoard) {
        return false;
    }

    @Override
    public boolean isPathClear(Integer[] move, ChessBoard chessBoard) {
        return true; //horse's path is always clear
    }
}
