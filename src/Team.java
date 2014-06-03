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
    private ArrayList<Team> win;

    public Team() {
        win = new ArrayList<Team>();
    }

    public Team(String aName) {
        name = aName;
        win = new ArrayList<Team>();
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

    public ArrayList<Team> getWinTeams() {
        return win;
    }

    public void setMatchResult(int matchGD, int matchGoals, Team opponent) {
        if (matchGD > 0) {
            score += 3;
            win.add(opponent);
        } else if (matchGD == 0)
            score += 1;
        gd += matchGD;
        goals += matchGoals;
    }
}
