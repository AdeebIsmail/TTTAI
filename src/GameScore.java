import java.util.ArrayList;

public class GameScore {
    private int my4s=0,my3s=0,my2s=0,my1s=0,opp4s=0,opp3s=0,opp2s=0,opp1s=0;
    private Board board;
    private Location loc;
    private char me, opp;


    public GameScore(Board board,Location loc, char me){
        this.board=board;
        this.loc=loc;
        this.me=me;
        opp = (me=='X')?'O':'X';
        gameCalculate();
    }

    public void gameCalculate() {
        int c = loc.getCol();
        int r = loc.getRow();
        int s = loc.getSheet();
        char[][][] b = board.getData();
        int score = 1;

        for (int x = 0; x < 4; x++) {
            if (b[s][r][x] == me) {
                score++;
            } else if (b[s][r][x] == opp) {
                score = 0;
                break;
            }

        }
        addMe(score);
        score = 1;
        for (int x = 0; x < 4; x++) {
            if (b[s][r][x] == opp) {
                score++;
            } else if (b[s][r][x] == opp) {
                score = 0;
                break;
            }
        }
        addOpp(score);
        score = 1;
        for (int x = 0; x < 4; x++) {
            if (b[s][x][c] == me) {
                score++;

            } else if (b[s][x][c] == opp) {
                score = 0;
                break;
            }

        }
        addMe(score);
        score = 1;
        for (int x = 0; x < 4; x++) {
            if (b[s][x][c] == opp) {
                score++;

            } else if (b[s][x][c] == me) {
                score = 0;
                break;
            }

        }
        addOpp(score);
        score = 1;
        for (int x = 0; x < 4; x++) {
            if (b[x][r][c] == me) {
                score++;

            } else if (b[x][r][c] == opp) {
                score = 0;
                break;
            }
        }
        addMe(score);
        score = 1;
        for (int x = 0; x < 4; x++) {
            if (b[x][r][c] == opp) {
                score++;

            } else if (b[x][r][c] == me) {
                score = 0;
                break;
            }
        }
        addOpp(score);
        if (c == r) {
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[s][x][x] == me) {
                    score++;
                } else if (b[s][x][x] == opp) {
                    score = 0;
                    break;
                }
            }
            addMe(score);
            for (int x = 0; x < 4; x++) {
                if (b[s][x][x] == opp) {
                    score++;
                } else if (b[s][x][x] == me) {
                    score = 0;
                    break;
                }
            }
            addOpp(score);

        }

        if (c + r == 3) {
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[s][x][3 - x] == me) {
                    score++;
                } else if (b[s][x][3 - x] == opp) {
                    score = 0;
                    break;
                }
            }
            addMe(score);
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[s][x][3 - x] == opp) {
                    score++;
                } else if (b[s][x][3 - x] == me) {
                    score = 0;
                    break;
                }
            }
            addOpp(score);


        }
        if (c == s) {
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[x][r][x] == me) {
                    score++;
                } else if (b[x][r][x] == opp) {
                    score = 0;
                    break;
                }
            }
            addMe(score);
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[x][r][x] == opp) {
                    score++;
                } else if (b[x][r][x] == me) {
                    score = 0;
                    break;
                }
            }
            addOpp(score);
        }


        if (c + s == 3) {
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[x][r][3 - x] == me) {
                    score++;
                } else if (b[x][r][3 - x] == opp) {
                    score = 0;
                    break;
                }
            }
            addMe(score);
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[x][r][3 - x] == opp) {
                    score++;
                } else if (b[x][r][3 - x] == me) {
                    score = 0;
                    break;
                }
            }
            addOpp(score);

        }
        if (r + s == 3) {
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[x][3 - x][c] == me) {
                    score++;
                } else if (b[x][3 - x][c] == opp) {
                    score = 0;
                    break;
                }
            }
            addMe(score);
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[x][3 - x][c] == opp) {
                    score++;
                } else if (b[x][3 - x][c] == me) {
                    score = 0;
                    break;
                }
            }
            addOpp(score);

        }

        if (r == s) {
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[x][x][c] == me) {
                    score++;
                } else if (b[x][x][c] == opp) {
                    score = 0;
                    break;
                }
            }
            addMe(score);
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[x][x][c] == opp) {
                    score++;
                } else if (b[x][x][c] == me) {
                    score = 0;
                    break;
                }
            }
            addOpp(score);

        }

        if ((c == 0 && c == 0 && s == 0) || (c == 1 && c == 1 && s == 1) || (c == 2 && c == 2 && s == 2) || (c == 3 && c == 3 && s == 3)) {
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[3 - x][3 - x][3 - x] == me) {
                    score++;
                } else if (b[3 - x][3 - x][3 - x] == opp) {
                    score = 0;
                    break;
                }
            }
            addMe(score);
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[x][x][x] == opp) {
                    score++;
                } else if (b[x][x][x] == me) {
                    score = 0;
                    break;
                }
            }
            addOpp(score);


        }
        if ((c == 3 && r == 0 && s == 0) || (c == 2 && r == 1 && s == 1) || (c == 1 && r == 2 && s == 2) || (c == 0 && r == 3 && s == 3)) {
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[x][x][3 - x] == me) {
                    score++;
                } else if (b[x][x][3 - x] == opp) {
                    score = 0;
                    break;
                }
            }
            addMe(score);
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[x][x][3 - x] == opp) {
                    score++;
                } else if (b[x][x][3 - x] == me) {
                    score = 0;
                    break;
                }
            }
            addOpp(score);


        }
        if ((c == 0 && r == 0 && s == 3) || (c == 1 && r == 1 && s == 2) || (c == 2 && r == 2 && s == 1) || (c == 3 && r == 3 && s == 0)) {
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[3-x][x][x] == me) {
                    score++;
                } else if (b[3 - x][x][x] == opp) {
                    score = 0;
                    break;
                }
            }
            addMe(score);
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[3-x][x][x] == opp) {
                    score++;
                } else if (b[3 - x][x][x] == me) {
                    score = 0;
                    break;
                }
            }
            addOpp(score);


        }
        if ((c == 3 && r == 0 && s == 3) || (c == 2 && r == 1 && s == 2) || (c == 1 && r == 2 && s == 1) || (c == 0 && r == 3 && s == 0)) {
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[3-x][x][3-x] == me) {
                    score++;
                } else if (b[3 - x][x][3 - x] == opp) {
                    score = 0;
                    break;
                }
            }
            addMe(score);
            score = 1;
            for (int x = 0; x < 4; x++) {
                if (b[x][x][x] == opp) {
                    score++;
                } else if (b[3 - x][x][3 - x] == me) {
                    score = 0;
                    break;
                }
            }
            addOpp(score);


        }
    }

    public void addMe(int c){
        if(c==1){
            my1s++;
        }else if(c==2){
            my2s++;
        }else if(c==3){
            my3s++;
        }else if(c==4){
            my4s++;

        }
    }

    public void addOpp(int c){
        if(c==1){
            opp1s++;
        }else if(c==2){
            opp2s++;
        }else if(c==3){
            opp3s++;
        }else if(c==4){
            opp4s++;

        }
    }
    public int getMy1s() {
        return my1s;
    }

    public int getMy4s() {
        return my4s;
    }

    public int getMy3s() {
        return my3s;
    }

    public int getMy2s() {
        return my2s;
    }

    public int getOpp4s() {
        return opp4s;
    }

    public int getOpp3s() {
        return opp3s;
    }

    public int getOpp2s() {
        return opp2s;
    }

    public int getOpp1s() {
        return opp1s;
    }


}