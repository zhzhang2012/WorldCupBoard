import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Tony_Zhang
 * Date: 14-6-3
 * Time: 下午4:51
 * To change this template use File | Settings | File Templates.
 */
public class Board {
    private ArrayList<Team> group;

    public Board() {
        group = new ArrayList<Team>();
    }

    public void addTeam(String name) {
        Team newTeam = new Team(name);
        group.add(newTeam);
    }

    public Team getTeam(int num) {
        return group.get(num);
    }

    public void addMatch(Team teamA, Team teamB, int teamAGoals, int teamBGoals) {
        int gd = teamAGoals - teamBGoals;
        teamA.setMatchResult(gd, teamAGoals, teamB);
        teamB.setMatchResult(-gd, teamBGoals, teamA);
    }

    public void sortBoard() {
        BoardRule rule = new BoardRule();
        Collections.sort(group, rule);
    }

    public void printBoard() {
        for (int i = 3; i >= 0; i--) {
            System.out.print(4 - i);
            System.out.println(": " + group.get(i).getName() + " - " + group.get(i).getScore());
        }
        System.out.println("Teams that survive are: " + group.get(3).getName() + ", " + group.get(2).getName() + ".");
    }

    public static void main(String[] args) {
        Board b = new Board();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.print("Please enter a new team's name: ");
            String teamName = in.nextLine();
            b.addTeam(teamName);
        }
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                System.out.println("Now enter the result for " + b.getTeam(i).getName() +
                        " versus " + b.getTeam(j).getName() + ":");
                System.out.print("Please enter the goals of " + b.getTeam(i).getName() + ": ");
                int teamAGoals = in.nextInt();
                System.out.print("Please enter the goals of " + b.getTeam(j).getName() + ": ");
                int teamBGoals = in.nextInt();
                b.addMatch(b.getTeam(i), b.getTeam(j), teamAGoals, teamBGoals);
            }
        }
        b.sortBoard();
        b.printBoard();
    }
}
