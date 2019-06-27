package com.mmt.chess;

import com.mmt.chess.entity.Entity;

import java.io.IOException;
import java.util.Map;

public class Game {
    private ChessBoard chessBoard;
    private Player white;
    private Player black;

    public Game() {
        this.chessBoard = new ChessBoard();
        this.white = new ChessPlayer();
        this.black = new ChessPlayer();
    }

    void play(Map<String, Integer[]> move) throws IOException {
        System.out.println("Board Before Move: ");
        chessBoard.displayBoard();

        Integer[] firstMove = move.values().iterator().next();        //Only 1 move will be considered for 1 api call - the first move.
        if (isMoveValid(firstMove)) {
            chessBoard.putPieceAtPlace(firstMove);
        } else {
            throw new IOException("Move is Invalid. Please try again...");
        }

        System.out.println("Board After Move: ");
        chessBoard.displayBoard();
    }

    //Check validity
    private boolean isMoveValid(Integer[] move) {
        Entity currEntity = chessBoard.getEntityAtPosition(move[0], move[1]);
        String currentTeam = chessBoard.getTeamAtPosition(move[0], move[1]);
        String finalTeam = chessBoard.getTeamAtPosition(move[2], move[3]);
        return currentTeam != finalTeam
                && !chessBoard.isMoveOutsideBoard(move[2], move[3])
                && (null == currEntity || currEntity.isMoveValid(move, chessBoard));
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        InputMoves inputMoves = new InputMoves();
        inputMoves.readMove();
        game.play(inputMoves.move);


    }
}