//IOANNIS MPOUZAS AM:5025

import java.util.*;

public class HumanPlayer {

    private String nameOfPlayer;
    private int humanScore;

    public HumanPlayer(String name) {
        this.nameOfPlayer = name;
    }

    public void play(Board a) {
        System.out.print(nameOfPlayer + " : Please select two positions to open: ");
        Scanner scanner = new Scanner(System.in);
        int position1 = scanner.nextInt();
        int position2 = scanner.nextInt();
        while (true) {
            if (position1 != position2 && a.containsCard(position1) && a.containsCard(position2)) {
                if (a.openPositions(position1, position2)) {
                    this.humanScore++;
                    System.out.println(nameOfPlayer + " points: " + humanScore);
                }
                break;
            } else {
                System.out.print(nameOfPlayer + " : Please select two positions to open: ");
                position1 = scanner.nextInt();
                position2 = scanner.nextInt();
            }
        }
    }

    public int getScore() {
        return humanScore;
    }

    public String toString() {
        return nameOfPlayer;
    }

    public static void main(String[] args) {
        HumanPlayer player = new HumanPlayer("Giannis");
        Board a = new Board(3);
        player.play(a);
        player.play(a);
        player.play(a);
    }

}