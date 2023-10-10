//IOANNIS MPOUZAS AM:5025

import java.util.*;

public class ComputerPlayer {

    private String nameOfComputer;
    private Integer[] arrayOfIndexes;
    private int scoreOfComputer;

    public ComputerPlayer(String nameGiven, int NumberOfPairs) {
        this.nameOfComputer = nameGiven;
        arrayOfIndexes = new Integer[NumberOfPairs];
        for (int i = 0; i < NumberOfPairs; i++) {
            arrayOfIndexes[i] = -1;
        }
        this.scoreOfComputer = 0;
    }

    public void play(Board a) {
        int position1 = a.getRandomPosition();
        int position2 = 0;
        for (int i = 0; i < arrayOfIndexes.length; i++) {
            if (arrayOfIndexes[i] == -1) {
                arrayOfIndexes[i] = a.getCard(position1);
            }
            break;
        }
        for (int i = 0; i < arrayOfIndexes.length; i++) {
            if (arrayOfIndexes[i] == a.getCard(position1)) {
                position2 = arrayOfIndexes[i];
            } else {
                position2 = a.getRandomPosition();
            }
        }
        while (true) {
            if (position1 == position2) {
                for (int i = 0; i < arrayOfIndexes.length; i++) {
                    if (arrayOfIndexes[i] == a.getCard(position1)) {
                        position2 = arrayOfIndexes[i];
                    } else {
                        position2 = a.getRandomPosition();
                    }
                }
            }
            break;
        }
        System.out.println(
                "\n" + nameOfComputer + ": Please select two positions to open: " + position1 + " " + position2);
        if (a.openPositions(position1, position2)) {
            this.scoreOfComputer++;
        }
    }

    public int getScore() {
        return this.scoreOfComputer;
    }

    public String toString() {
        return this.nameOfComputer;
    }

    public static void main(String[] args) {
        ComputerPlayer a = new ComputerPlayer("HAL", 3);
        Board board = new Board(3);
        a.play(board);
        System.out.println("\n" + a.toString() + " has scored " + a.getScore());
        a.play(board);
        System.out.println("\n" + a.toString() + " has scored " + a.getScore());
        a.play(board);
        System.out.println("\n" + a.toString() + " has scored " + a.getScore());
    }

}
