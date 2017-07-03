/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainHandler;

import objects.Player;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Amr
 */
public class Game {

    public static Scanner sc = new Scanner(System.in);
    public static Player player1 = new Player(0, 6, 1);
    public static Player player2 = new Player(0, 6, 2);
    public static int playerTurn = 0;

    // player1 is the one who initiated the move
    // pit is the index of the selected pit zero based
    public static void move() {
        int[] pits1 = player1.getPits();
        int[] pits2 = player2.getPits();
        int pit = sc.nextInt();
        int pebbles = pits1[pit];
        pits1[pit] = 0;
        int index = 0;
        int side = playerTurn;
        int endIndex = pits1.length;
        int[] pits = new int[pits1.length];
        while (pebbles > 0) {
            if (side == player1.getIndex()) {
                pits = pits1;
            } else if (side == player2.getIndex()) {
                pits = pits2;
            }
            index = pit;
            endIndex = pits.length;
            while (index != endIndex && pebbles != 0) {
                pits[index] = pits[index] + 1;
                pebbles--;
                if (index > endIndex) {
                    index--;
                } else {
                    index++;
                }
            }
            if (side == player1.getIndex()) {
                pits1 = pits;
                side = player2.getIndex();
            } else if (side == player2.getIndex()) {
                pits2 = pits;
                side = player1.getIndex();
            }
        }
        if (side == playerTurn && pits1[index] == 1) {
            player1.setKalah(pits2[pits2.length - 1 - index] + 1);
            pits1[index] = 0;
            pits2[pits2.length - 1 - index] = 0;
        } else if (side != playerTurn) {
            playerTurn = side;
        }

        player1.setPits(pits1);

        player2.setPits(pits2);

        int[] zerosArray = new int[pits1.length];

        Arrays.fill(zerosArray,
                0);

        if (Arrays.equals(player1.getPits(), zerosArray) || Arrays.equals(player2.getPits(), zerosArray)) {
            playerTurn = 0;
        }
    }

    public static boolean playGame() {
        playerTurn = player1.getIndex();
        while (playerTurn == player1.getIndex() || playerTurn == player2.getIndex()) {
            move();
            System.out.println("Player " + playerTurn + " turn");
            return true;
        }
        return false;
    }

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        while (playGame());
        int winner = (player1.getKalah() > player2.getKalah()) ? player1.getIndex() : player2.getIndex();
        System.out.println("Player " + winner + " won");
    }
}
