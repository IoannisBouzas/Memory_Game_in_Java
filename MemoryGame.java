//IOANNIS MPOUZAS AM:5025

import java.lang.*;
import java.util.Scanner;

public class MemoryGame {
    public static void main(String[] args) {
        int numberOfPairs = Integer.parseInt(args[0]);
        Board board = new Board(numberOfPairs);
        System.out.println("Please select a game mode: HumanVsHuman or HumanVsAI");
        Scanner scanner = new Scanner(System.in);
        String gamemode = scanner.next();
        if (gamemode.equals("HumanVsHuman")) {
            System.out.print("Please give the names of the players:");
            String humanPlayer1 = scanner.next();
            String humanPlayer2 = scanner.next();
            HumanPlayer player1 = new HumanPlayer(humanPlayer1);
            HumanPlayer player2 = new HumanPlayer(humanPlayer2);
            while (!board.allPairsFound()) {
                player1.play(board);
                player2.play(board);
                System.out.println(player1.toString() + " has scored " + player1.getScore());
                System.out.println(player2.toString() + " has scored " + player2.getScore());
            }
            if (player1.getScore() > player2.getScore()) {
                System.out.println(player1.toString() + " has won the game");
            } else if (player1.getScore() < player2.getScore()) {
                System.out.println(player2.toString() + " has won the game");
            } else {
                System.out.println("It's a draw");
            }

        } else {
            System.out.print("Please give the name of the player:");
            String humanPlayer = scanner.next();
            ComputerPlayer computerPlayer = new ComputerPlayer("HAL", 3);
            HumanPlayer player1 = new HumanPlayer(humanPlayer);
            while (!board.allPairsFound()) {
                computerPlayer.play(board);
                player1.play(board);
                System.out.println(player1.toString() + " has scored " + player1.getScore());
                System.out.println(computerPlayer.toString() + " has scored " + computerPlayer.getScore());
            }
            if (player1.getScore() > computerPlayer.getScore()) {
                System.out.println(player1.toString() + " has won the game");
            } else if (player1.getScore() < computerPlayer.getScore()) {
                System.out.println(computerPlayer.toString() + " has won the game");
            } else {
                System.out.println("It's a draw");
            }
        }
    }
}
