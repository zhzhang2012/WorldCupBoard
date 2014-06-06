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

    private int getMatchScore(Team t) {
        int i;
        for (i = 0; i < 3; i++)
            if (opponents.get(i).equals(t.name)) break;
        return matchesScore.get(i);
    }

    private int getMatchGd(Team t) {
        int i;
        for (i = 0; i < 3; i++)
            if (opponents.get(i).equals(t.name)) break;
        return matchesGd.get(i);
    }

    private int getMatchGoals(Team t) {
        int i;
        for (i = 0; i < 3; i++)
            if (opponents.get(i).equals(t.name)) break;
        return matchesGoals.get(i);
    }

    public int compareScore(Team t) {
        return this.getMatchScore(t) - t.getMatchScore(this);
    }

    public int compareGd(Team t) {
        return this.getMatchGd(t) - t.getMatchGd(this);
    }

    public int compareGoals(Team t) {
        return this.getMatchGoals(t) - t.getMatchGoals(this);
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
