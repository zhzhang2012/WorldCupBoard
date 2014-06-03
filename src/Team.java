import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Tony_Zhang
 * Date: 14-6-3
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 */
public class Team {
    private String name;
    private int score;
    private int gd;
    private int goals;
    private ArrayList<String> opponents;
    private ArrayList<Integer> matchesScore;
    private ArrayList<Integer> matchesGd;
    private ArrayList<Integer> matchesGoals;

    public Team() {
        opponents = new ArrayList<String>();
        matchesScore = new ArrayList<Integer>();
        matchesGd = new ArrayList<Integer>();
        matchesGoals = new ArrayList<Integer>();
    }

    public Team(String aName) {
        name = aName;
        opponents = new ArrayList<String>();
        matchesScore = new ArrayList<Integer>();
        matchesGd = new ArrayList<Integer>();
        matchesGoals = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getGd() {
        return gd;
    }

    public int getGoals() {
        return goals;
    }

    public int compareScore(Team t) {
        for (int i = 0; i < 3; i++)
            if (opponents.get(i).equals(t.name))
                return score - matchesScore.get(i);
        return 0;
    }

    public int compareGd(Team t) {
        for (int i = 0; i < 3; i++)
            if (opponents.get(i).equals(t.name))
                return gd - matchesGd.get(i);
        return 0;
    }

    public int compareGoals(Team t) {
        for (int i = 0; i < 3; i++)
            if (opponents.get(i).equals(t.name))
                return goals - matchesGoals.get(i);
        return 0;
    }

    public void setMatchResult(int matchGD, int matchGoals, String opponent) {
        if (matchGD > 0) {
            score += 3;
            matchesScore.add(3);
        } else if (matchGD == 0) {
            score += 1;
            matchesScore.add(1);
        } else
            matchesScore.add(0);
        gd += matchGD;
        goals += matchGoals;
        opponents.add(opponent);

        matchesGd.add(matchGD);
        matchesGoals.add(matchGoals);
    }
}
