import java.awt.*;
import java.lang.annotation.ElementType;
import java.lang.reflect.Array;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.function.BinaryOperator;

public class TTaiFood implements PlayerInt {
    //ArrayList<PointScore> Point = new ArrayList<>();
    //GameScore S = new GameScore();
    private char letter;
    private String name;

    // Pre:       receives a char letter
    // Post:   sets the name to "Random AI" and the letter to the letter received
    TTaiFood(char letter) {
        name = "AdeebI";
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    // Pre:       method is called
    // Post:   returns the Location where the player wants to move
    public Location getMove(Board board) {

        return move(board);
    }

    // Pre:       method is called
    // Post:   returns the name of the player
    public String getName() {
        return name;
    }

    public PlayerInt freshCopy() {
        return new Test_AI_1(letter);
    }

    public char otherPlayer() {
        if (getLetter() == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }

    public PointScore scoreCompare(ArrayList<PointScore> p, Board b) {
        PointScore maxP = null;
        for (PointScore point : p) {
            if (maxP == null) {
                maxP = point;
            }
            if (maxP.getL() == point.getL()) {
                p.remove(point);
                break;
            }
            if (maxP.getScore() > point.getScore()) {
                maxP = point;
            }
        }
        return maxP;
    }

    /*public Location move(Board b){
        ArrayList<Location> my4s=new ArrayList<>(), my3s=new ArrayList<>(), my2s=new ArrayList<>(), my1s=new ArrayList<>(),
                opp4s=new ArrayList<>(), opp3s=new ArrayList<>(), opp2s=new ArrayList<>(), opp1s=new ArrayList<>();
        for(int s=0;s<4;s++){
            for(int r=0;r<4;r++){
                for(int c=0;c<4;c++) {
                    Location loc=new Location(c,r,s);
                    Counts counts=new Counts(b,loc,letter);
                    if(counts.getMy1s()>0)
                        my1s.add(loc);
                    if(counts.getMy2s()>0)
                        my2s.add(loc);
                    if(counts.getMy3s()>0)
                        my3s.add(loc);
                    if(counts.getMy4s()>0)
                        my4s.add(loc);
                    if(counts.getOpp1s()>0)
                        opp1s.add(loc);
                    if(counts.getOpp2s()>0)
                        opp2s.add(loc);
                    if(counts.getOpp3s()>0)
                        opp3s.add(loc);
                    if(counts.getOpp4s()>0)
                        opp4s.add(loc);
                }
            }
        }
        if(my4s.size()>0)
            return my4s.get((int)(Math.random()*my4s.size()-1));
        else if(opp4s.size()>0)
            return opp4s.get((int)(Math.random()*opp4s.size()-1));
        else if(my3s.size()>0)
            return my3s.get((int)(Math.random()*my3s.size()-1));
        else if(opp3s.size()>0)
            return opp3s.get((int)(Math.random()*opp3s.size()-1));
        else if(my2s.size()>0)
            return my2s.get((int)(Math.random()*my2s.size()-1));
        else if(opp2s.size()>0)
            return opp2s.get((int)(Math.random()*opp2s.size()-1));
        else if(my1s.size()>0)
            return my1s.get((int)(Math.random()*my1s.size()-1));
        else
            return opp1s.get((int)(Math.random()*opp1s.size()-1));

    }*/

    public Location move(Board b) {
        int max = -1;
        boolean opWin = false;
        Location best = null;
        Location oppWin = null;
        GameScore counts;

        for (int s = 0; s < 4; s++) {
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    Location loc = new Location(s, r, c);
                    if (b.isEmpty(loc)) {
                        counts = new GameScore(b, loc, letter);
                        int score = counts.getMy1s() * 50 + counts.getMy2s() * 600 + counts.getMy3s() * 1000 + counts.getMy4s() * 1100;
                        if (counts.getMy4s() > 0) {
                            best = loc;
                            return best;
                        } else if (counts.getOpp4s() > 0) {
                            oppWin = loc;
                            opWin = true;
                        }

                        if (score > max) {
                            max = score;
                            best = loc;
                        }


                    }
                }
            }
        }
        if (opWin) {
            return oppWin;
        }
        return best;
    }


}



