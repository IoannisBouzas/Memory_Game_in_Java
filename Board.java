//IOANNIS MPOUZAS AM:5025

import java.util.*;

public class Board {

    private Integer[] board;
    private int sizeOfBoard;
    private ArrayList<Integer> listWithTheIndexesThatHaveCard;
    private ArrayList<Integer> listWithTheIndexesThatHaveNotCard;
    private Random rndGenerator;

    public Board(int N) {
        this.sizeOfBoard = 2 * N;
        listWithTheIndexesThatHaveCard = new ArrayList<Integer>();
        listWithTheIndexesThatHaveNotCard = new ArrayList<Integer>();
        board = new Integer[sizeOfBoard];
        for (int i = 0; i < sizeOfBoard; i++) {
            board[i] = i / 2;
            listWithTheIndexesThatHaveCard.add(i);
        }
        rndGenerator = new Random();
        for (int i = 0; i < sizeOfBoard; i++) {
            int randomIndexToSwap = rndGenerator.nextInt(this.sizeOfBoard);
            int temp = board[randomIndexToSwap];
            board[randomIndexToSwap] = board[i];
            board[i] = temp;
        }
    }

    public void print() {
        System.out.println("\n");
        for (int i = 0; i < sizeOfBoard; i++) {
            System.out.print(i + "  ");
        }
        System.out.print("\n");
        for (int i = 0; i < sizeOfBoard; i++) {
            System.out.print("----");
        }
        System.out.print("\n");
        for (int j = 0; j < sizeOfBoard; j++) {
            if (!(board[j] == null)) {
                if (j > 9)
                    System.out.print("*" + "   ");
                else
                    System.out.print("*" + "  ");
            } else if (j > 9) {
                System.out.print("    ");
            } else {
                System.out.print("   ");
            }
        }
    }

    public void flash(int index1, int index2) {
        System.out.print("\r");
        for (int j = 0; j < sizeOfBoard; j++) {
            if (j == index1 && j > 9) {
                System.out.print(board[index1] + "   ");
            } else if (j == index2 && j > 9) {
                System.out.print(board[index2] + "  ");
            } else if (j == index1) {
                System.out.print(board[index1] + "  ");
            } else if (j == index2) {
                System.out.print(board[index2] + "  ");
            } else if (!(board[j] == null)) {
                if (j > 9)
                    System.out.print("*" + "   ");
                else
                    System.out.print("*" + "  ");
            } else
                System.out.print(" ");

        }

        System.out.print("\r");
        System.out.print("\r");
        System.out.print("\n");
        System.out.print("\n");
        delay(2);
        System.out.print("\r");
        print();
    }

    private void delay(int sec) {
        try {
            Thread.currentThread().sleep(1000 * sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean openPositions(int position1, int position2) {
        System.out.print("\n");
        if (board[position1] == board[position2]) {
            System.out.println("Pair Found!");
            board[position1] = null;
            board[position2] = null;
            print();
            System.out.print("\n");
            return true;
        } else {
            flash(position1, position2);
            return false;
        }
    }

    public int getRandomPosition() {
        int rndIndex = rndGenerator.nextInt(sizeOfBoard);
        while (true) {
            if (board[rndIndex] == null) {
                rndIndex = rndGenerator.nextInt(sizeOfBoard);
            } else {
                return rndIndex;
            }
        }
    }

    public int getRandomPosition(int position) {
        int rndIndex = rndGenerator.nextInt(sizeOfBoard);
        while (true) {
            if (board[rndIndex] == null) {
                rndIndex = rndGenerator.nextInt(sizeOfBoard);
            } else {
                return rndIndex;
            }
        }
    }

    public boolean containsCard(int position) {
        if (board[position] != null) {
            return true;
        } else {
            return false;
        }
    }

    public int getCard(int position) {
        return board[position];
    }

    public boolean allPairsFound() {
        for (int i = 0; i < sizeOfBoard; i++) {
            if (board[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Board game = new Board(3);
        game.print();
        System.out.println("\n");
        for (int i = 0; i < 2 * 3; i++) {
            System.out.print(game.getCard(i) + " ");
        }
        int index1 = game.getRandomPosition();
        int index2 = game.getRandomPosition();
        while (index1 == index2) {
            index2 = game.getRandomPosition();
        }
        game.flash(index1, index2);
        game.openPositions(0, 2);
        game.openPositions(3, 4);
        game.containsCard(4);
        game.openPositions(1, 5);
        System.out.println(game.allPairsFound());

    }

}
