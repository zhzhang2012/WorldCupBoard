import java.util.ArrayList;
import java.util.Collections;

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

    public void addMatch(String teamAName, String teamBName, int teamAGoals, int teamBGoals) {
        int i = 0, j = 0;
        int gd = teamAGoals - teamBGoals;
        while (i < group.size()) {
            if (group.get(i).getName().equals(teamAName))
                break;
        }
        while (j < group.size()) {
            if (group.get(j).getName().equals(teamBName))
                break;
        }
        group.get(i).setMatchResult(gd, teamAGoals, group.get(j));
        group.get(j).setMatchResult(gd, teamBGoals, group.get(i));
    }

    public void sortBoard() {
        BoardRule rule = new BoardRule();
        Collections.sort(group, rule);
    }

    public Team get1stPlace() {
        return group.get(0);
    }

    public Team get2ndPlace() {
        return group.get(1);
    }
}
