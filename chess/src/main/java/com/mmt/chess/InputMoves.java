package com.mmt.chess;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class InputMoves {
    Map<String, Integer[]> move; //First 2 integers of array are current position and last 2 are final position

    public void readMove() throws IOException {
        String data = new String(Files.readAllBytes(Paths.get(Constants.inputMove)));
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Map<String, Integer[]>>() {
        }.getType();
        this.move = gson.fromJson(data, collectionType);
    }

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        InputMoves inputMoves = new InputMoves();
        inputMoves.move = new HashMap<>();
        inputMoves.move.put("white", new Integer[]{3, 4, 3, 5});
        inputMoves.move.put("black", new Integer[]{1, 2, -1, 5});
        String s = gson.toJson(inputMoves);
        System.out.println(s);

        inputMoves.readMove();
        System.out.println(inputMoves.move);
    }

}
