import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Pruning {

    public Location predictMove(Board b, char me, char opp) {
        ArrayList<PointScore> ME;
        ArrayList<PointScore> OPP;
        PointScore THEYhighestScore;
        PointScore MEhighestScore;
        Location highScore = null;
        Board z = (Board) b.clone();
        if(me == 'X')
        {
            ME = possiableMove(z, me, opp);
            MEhighestScore = scoreCompare(ME);
            if (MEhighestScore.getScore() == 4) {
                highScore = MEhighestScore.getL();
                System.out.println("WIN");
                return highScore;
            }

            highScore = MEhighestScore.getL();
            z.setLocation(MEhighestScore.getL(), me);
            OPP = possiableMove(z, opp, me);
            THEYhighestScore = scoreCompare(OPP);
            if (THEYhighestScore.getScore() == 4) {
                highScore = THEYhighestScore.getL();
                System.out.println("BLOCK THREE");
                return highScore;
            }
            z.setLocation(THEYhighestScore.getL(), opp);
            z.reset();
        }
        else
        {
            OPP = possiableMove(z, opp, opp);
            THEYhighestScore = scoreCompare(OPP);
            if (THEYhighestScore.getScore() == 4) {

                highScore = THEYhighestScore.getL();
                System.out.println("BLOCK THREE");
                return highScore;
            }
            z.setLocation(THEYhighestScore.getL(), opp);
            ME = possiableMove(z, me, me);
            MEhighestScore = scoreCompare(ME);
            if (MEhighestScore.getScore() == 4) {
                highScore = MEhighestScore.getL();
                return highScore;
            }
            if (MEhighestScore.getScore() == 3) {
                highScore = MEhighestScore.getL();
                return highScore;
            }
            highScore = MEhighestScore.getL();
            z.setLocation(MEhighestScore.getL(), me);
            z.reset();
        }
        return highScore;


    }

    public PointScore scoreCompare(ArrayList<PointScore> p) {
        PointScore maxP = p.get(p.size() - 1);
        for (PointScore point : p) {
            if ((point.getScore() >= maxP.getScore())) {
                maxP = point;

            }


        }
        return maxP;
    }


    public ArrayList<PointScore> possiableMove(Board b, char me, char opp) {
        //GameScore S = new GameScore();
        ArrayList<PointScore> M = new ArrayList<>();
        Location l;
        int i = 0;
        for (int s = 0; s < 4; s++) { // col row sheet sheet row col
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    l = new Location(s, r, c);
                    if (b.isEmpty(l)) {
                        //S.gameCalculate(b, l, me);// col row sheet sheet rwo col
                        //M.add(S.getIndex(i));
                        i++;

                    }


                }
            }
        }
        return M;
    }

    public String toStringh(ArrayList<PointScore> p) {
        String z = " ";
        for (int i = 0; i < p.size(); i++) {
            int s = p.get(i).getScore();
            z += Integer.toString(s);
            z+= " ";
        }
        return z;
    }

    public Board copy(Board b) {
        Board z = b;
        return z;
    }
}