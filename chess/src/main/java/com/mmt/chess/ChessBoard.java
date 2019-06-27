package com.mmt.chess;

import com.mmt.chess.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
public class ChessBoard {
    @Getter
    public volatile String[][] board;
    private Player white;
    private Player black;

    private Entity blackPawn;
    private Entity whitePawn;
    private Entity camel;
    private Entity elephant;
    private Entity king;
    private Entity queen;
    private Entity horse;

    public ChessBoard() {
        this.board = new String[8][8];
        white = new ChessPlayer();
        black = new ChessPlayer();

        blackPawn = new BlackPawn();
        whitePawn = new WhitePawn();
        camel = new Camel();
        elephant = new Elephant();
        horse = new Horse();
        king = new King();
        queen = new Queen();

        initialise();
    }

    void putPieceAtPlace(Integer[] piecePosition) {
        synchronized (this) {
            String curr = this.board[piecePosition[0]][piecePosition[1]];
            this.board[piecePosition[2]][piecePosition[3]] = curr;
            this.board[piecePosition[0]][piecePosition[1]] = null;
        }
    }

    public void initialise() { //initial state of board

        board[0][0] = Constants.BLACK_ELEPHANT_1;
        board[0][1] = Constants.BLACK_HORSE_1;
        board[0][2] = Constants.BLACK_CAMEL_1;
        board[0][3] = Constants.BLACK_QUEEN;
        board[0][4] = Constants.BLACK_KING;
        board[0][5] = Constants.BLACK_CAMEL_2;
        board[0][6] = Constants.BLACK_HORSE_2;
        board[0][7] = Constants.BLACK_ELEPHANT_2;

        board[1][0] = Constants.BLACK_PAWN_1;
        board[1][1] = Constants.BLACK_PAWN_2;
        board[1][2] = Constants.BLACK_PAWN_3;
        board[1][3] = Constants.BLACK_PAWN_4;
        board[1][4] = Constants.BLACK_PAWN_5;
        board[1][5] = Constants.BLACK_PAWN_6;
        board[1][6] = Constants.BLACK_PAWN_7;
        board[1][7] = Constants.BLACK_PAWN_8;

        board[7][0] = Constants.WHITE_ELEPHANT_1;
        board[7][1] = Constants.WHITE_HORSE_1;
        board[7][2] = Constants.WHITE_CAMEL_1;
        board[7][3] = Constants.WHITE_QUEEN;
        board[7][4] = Constants.WHITE_KING;
        board[7][5] = Constants.WHITE_CAMEL_2;
        board[7][6] = Constants.WHITE_HORSE_2;
        board[7][7] = Constants.WHITE_ELEPHANT_2;

        board[6][0] = Constants.WHITE_PAWN_1;
        board[6][1] = Constants.WHITE_PAWN_2;
        board[6][2] = Constants.WHITE_PAWN_3;
        board[6][3] = Constants.WHITE_PAWN_4;
        board[6][4] = Constants.WHITE_PAWN_5;
        board[6][5] = Constants.WHITE_PAWN_6;
        board[6][6] = Constants.WHITE_PAWN_7;
        board[6][7] = Constants.WHITE_PAWN_8;

    }

    Entity getEntityAtPosition(int x, int y) {
        String curr = this.board[x][y];
        if (null == curr)
            return null;
        if (curr.contains("H")) {
            return horse;
        } else if (curr.contains("C")) {
            return camel;
        } else if (curr.contains("E")) {
            return elephant;
        } else if (curr.contains("BP")) {
            return blackPawn;
        } else if (curr.contains("WP")) {
            return whitePawn;
        } else if (curr.contains("K")) {
            return king;
        } else if (curr.contains("Q")) {
            return queen;
        }
        return null;//redundant safe check
    }

    String getTeamAtPosition(int x, int y) {
        String curr = this.board[x][y];
        if (null == curr)
            return null;
        if (curr.contains("B")) {
            return "B";
        } else if (curr.contains("W")) {
            return "W";
        }
        return null;
    }

    boolean isMoveOutsideBoard(int x, int y) {
        return (x < 0 || x >= board.length || y < 0 || y >= board[0].length);
    }

    void displayBoard() {
        for (String[] aBoard : board) {
            System.out.println(Arrays.toString(aBoard));
        }
    }
}
