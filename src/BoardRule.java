import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: Tony_Zhang
 * Date: 14-6-3
 * Time: 下午5:24
 * To change this template use File | Settings | File Templates.
 */
public class BoardRule implements Comparator {
    public int compare(Object arg1, Object arg2) {
        Team teamA = (Team) arg1;
        Team teamB = (Team) arg2;
        if (teamA.getScore() != teamB.getScore()) return teamA.getScore() - teamB.getScore();
        else if (teamA.getGd() != teamB.getGd()) return teamA.getGd() - teamB.getGd();
        else if (teamA.getGoals() != teamB.getGoals()) return teamA.getGoals() - teamB.getGoals();
        else if (teamA.compareScore(teamB) != 0) return teamA.compareScore(teamB);
        else if (teamA.compareGd(teamB) != 0) return teamA.compareGd(teamB);
        else if (teamA.compareGoals(teamB) != 0) return teamA.compareGoals(teamB);
        else {
            int num = (int) (Math.random() * 2);
            if (num == 0) return 1;
            else return -1;
        }
    }
}
