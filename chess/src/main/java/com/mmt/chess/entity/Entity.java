package com.mmt.chess.entity;

import com.mmt.chess.ChessBoard;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {

    public abstract boolean isMoveValid(Integer[] move, ChessBoard chessBoard);

    boolean isPathClear(Integer[] move, ChessBoard chessBoard) {
        List<Integer[]> pts = getPathBetweenTwoPoints(move);
        for (Integer[] pt : pts) {
            if (chessBoard.board[pt[0]][pt[1]] != null)
                return false;
        }
        return true;
    }

    private List<Integer[]> getPathBetweenTwoPoints(Integer[] points) {
        List<Integer[]> pts = new ArrayList<>();
        int x = points[0] == points[2] ? 0 : (points[0] < points[2] ? 1 : -1);
        int y = points[1] == points[3] ? 0 : (points[1] < points[3]) ? 1 : -1;
        int currx = points[0] + x;
        int curry = points[1] + y;
        int finx = points[2];
        int finy = points[3];
        while (currx != finx || curry != finy) {
            pts.add(new Integer[]{currx, curry});
            currx += x;
            curry += y;
        }

        return pts;
    }
}
