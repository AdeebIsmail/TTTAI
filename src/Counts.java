public class Counts {
    private int my4s=0,my3s=0,my2s=0,my1s=0,opp4s=0,opp3s=0,opp2s=0,opp1s=0;
    private Board board;
    private Location loc;
    private char me, opp;

    public Counts(Board board,Location loc, char me){
        this.board=board;
        this.loc=loc;
        this.me=me;
        opp = (me=='X')?'O':'X';
        calculate();
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

    public Board getBoard() {
        return board;
    }

    public Location getLoc() {
        return loc;
    }

  /*public void gameCalculate(){
      int c = loc.getCol();
      int r = loc.getRow();
      int s = loc.getSheet();
      char[][][] b = board.getData();
      //horizontals
      int count = 1;
      for(int cc=0;cc<4;cc++){
          if(b[s][r][cc]==me)
              count++;
          else if(b[s][r][cc]==opp){
              count=0;
              break;
          }
      }addMe(count);
      //opp code
      count = 1;
      for(int cc=0;cc<4;cc++){
          if(b[s][r][cc]==opp)
              count++;
          else if(b[s][r][cc]==me){
              count=0;
              break;
          }
      }addOpp(count);


      //vertical
      count = 1;
      for(int rr=0;rr<4;rr++){
          if(b[s][rr][c]==me)
              count++;
          else if(b[s][rr][c]==opp){
              count=0;
              break;
          }

      }addMe(count);
      //opp code
      count = 1;
      for(int rr=0;rr<4;rr++){
          if(b[s][rr][c]==opp)
              count++;
          else if(b[s][rr][c]==me){
              count=0;
              break;
          }
      }addOpp(count);


      //backwards
      count = 1;
      for(int ss=0;ss<4;ss++){
          if(b[ss][r][c]==me)
              count++;
          else if(b[ss][r][c]==opp){
              count=0;
              break;
          }
      }addMe(count);
      //opp code
      count = 1;
      for(int ss=0;ss<4;ss++){
          if(b[ss][r][c]==opp)
              count++;
          else if(b[ss][r][c]==me){
              count=0;
              break;
          }
      }addOpp(count);


      //Z sheet diagonal
      if(c==r) {
          count = 1;
          for (int aa = 0; aa < 4; aa++) {
              if (b[s][aa][aa] == me)
                  count++;
              else if (b[s][aa][aa] == opp) {
                  count = 0;
                  break;
              }
          }
          addMe(count);
          //opp code
          count = 1;
          for (int aa = 0; aa < 4; aa++) {
              if (b[s][aa][aa] == opp)
                  count++;
              else if (b[s][aa][aa] == me) {
                  count = 0;
                  break;
              }
          }
          addOpp(count);

      }
  }*/

    public void calculate() {
        int c = loc.getCol();
        int r = loc.getRow();
        int s = loc.getSheet();
        char[][][] b = board.getData();

        int count = 1;
        for (int x = 0; x < 4; x++) { // left to right
            if (b[s][r][x] == me) {
                count++;
            } else if (b[s][r][x] == opp) {
                count = 0;
                break;
            }
        }addMe(count);
        //opp code
        count = 1;
        for (int x = 0; x < 4; x++) {
            if (b[s][r][x] == opp) {
                count++;
            } else if (b[s][r][x] == me) {
                count = 0;
                break;
            }
        }addOpp(count);

        count=1;
        for (int x = 0; x < 4; x++) { // across the board, up to down
            if (b[s][x][c] == me) {
                count++;
            } else if (b[s][x][c] == opp) {
                count = 0;
                break;
            }
        }addMe(count);
        //opp code
        count=1;
        for (int x = 0; x < 4; x++) {
            if (b[s][x][c] == opp) {
                count++;
            } else if (b[s][x][c] == me) {
                count = 0;
                break;
            }
        }addOpp(count);

        count=1;
        for (int x = 0; x < 4; x++) { // sheet up to down,xrc
            if (b[x][r][c] == me) {
                count++;
            } else if (b[x][r][c] == opp) {
                count = 0;
                break;
            }
        }addMe(count);
        //opp code
        count=1;
        for (int x = 0; x < 4; x++) {
            if (b[x][r][c] == opp) {
                count++;
            } else if (b[x][r][c] == me) {
                count = 0;
                break;
            }
        }addOpp(count);


        count=1;
        for (int x = 0; x < 4; x++) {  // sheet left to right,xrx
            if (b[x][r][x] == me) {
                count++;
            } else if (b[x][r][x] == opp) {
                count = 0;
                break;
            }
        }addMe(count);
        //opp code
        count=1;
        for (int x = 0; x < 4; x++) {
            if (b[x][r][x] == opp) {
                count++;
            } else if (b[x][r][x] == me) {
                count = 0;
                break;
            }
        }addOpp(count);


        count=1;
        for (int x = 0; x < 4; x++) { // across the sheet, up to down,xxc
            if (b[x][x][c] == me) {
                count++;
            } else if (b[x][x][c] == opp) {
                count = 0;
                break;
            }
        }addMe(count);
        //opp code
        count=1;
        for (int x = 0; x < 4; x++) {
            if (b[x][x][c] == opp) {
                count++;
            } else if (b[x][x][c] == me) {
                count = 0;
                break;
            }
        }addOpp(count);

        //diagonals
        count=1;
        for (int x = 0; x < 4; x++) { //diagonal, l to r,sxx
            if (b[s][x][x] == me) {
                count++;
            } else if (b[s][x][x] == opp) {
                count = 0;
                break;
            }
        }addMe(count);
        //opp code
        count=1;
        for (int x = 0; x < 4; x++) {
            if (b[s][x][x] == opp) {
                count++;
            } else if (b[s][x][x] == me) {
                count = 0;
                break;
            }
        }addOpp(count);


        count=1;
        for (int x = 0; x < 4; x++) { //diagonal r to sxcol
            int col = 3;
            if (b[s][x][col] == me) {
                count++;
            } else if (b[s][x][col] == opp) {
                count = 0;
                break;
            }
            col--;
        }addMe(count);
        //opp code
        count=1;
        for (int x = 0; x < 4; x++) {
            int col=3;
            if (b[s][x][col] == opp) {
                count++;
            } else if (b[s][x][col] == me) {
                count = 0;
                break;
            }col--;
        }addOpp(count);


        //multisheet diagonals
        count=1;
        for (int x = 0; x < 4; x++) { //multi-sheet diagonal, top left to bottom right,xxx
            if (b[x][x][x] == me) {
                count++;
            } else if (b[x][x][x] == opp) {
                count = 0;
                break;
            }
        }addMe(count);
        //opp code
        count=1;
        for (int x = 0; x < 4; x++) {
            if (b[x][x][x] == opp) {
                count++;
            } else if (b[x][x][x] == me) {
                count = 0;
                break;
            }
        }addOpp(count);

        count=1;
        for (int x = 0; x < 4; x++) { //multi-sheet diagonal, bottom left to top right,xxcol
            int col = 3;
            if (b[x][x][col] == me) {
                count++;
            } else if (b[x][x][col] == opp) {
                count = 0;
                break;
            }col--;
        }addMe(count);
        //opp code
        count=1;
        for (int x = 0; x < 4; x++) {
            int col=3;
            if (b[x][x][col] == opp) {
                count++;
            } else if (b[x][x][col] == me) {
                count = 0;
                break;
            }col--;
        }addOpp(count);

        count=1;
        for (int x = 0; x < 4; x++) { //multi-sheet diagonal, top bottom left to bottom top right,xxrow
            int row = 3;
            if (b[x][x][row] == me) {
                count++;
            } else if (b[x][x][row] == opp) {
                count = 0;
                break;
            }row--;
        }addMe(count);
        //opp code
        count=1;
        for (int x = 0; x < 4; x++) {
            int row=3;
            if (b[x][x][row] == opp) {
                count++;
            } else if (b[x][x][row] == me) {
                count = 0;
                break;
            }row--;
        }addOpp(count);

        count=1;
        for (int x = 0; x < 4; x++) { //multi-sheet diagonal, top bottom right to bottom top left,xrowrow
            int row = 3;
            if (b[x][row][row] == me) {
                count++;
            } else if (b[x][row][row] == opp) {
                count = 0;
                break;
            }row--;
        }addMe(count);
        //opp code
        count=1;
        for (int x = 0; x < 4; x++) {
            int row=3;
            if (b[x][row][row] == opp) {
                count++;
            } else if (b[x][row][row] == me) {
                count = 0;
                break;
            }row--;
        }addOpp(count);
        if (c ==r) {
            count = 1;
            for (int x = 0; x < 4; x++) {
                if (b[s][x][x] == me) {
                    count++;
                } else {
                    count = 0;
                    break;
                }
            }

        }addMe(count);
        if (c ==r) {
            count = 1;
            for (int x = 0; x < 4; x++) {
                if (b[s][x][x] == opp) {
                    count++;
                } else {
                    count = 0;
                    break;
                }
            }

        }addOpp(count);
        if (c == s) {
            count = 1;
            for (int x = 0; x < 4; x++) {
                if (b[x][r][x] == me) {
                    count++;
                } else {

                    break;
                }
            }
        }addMe(count);
        if (c == s) {
            count = 1;
            for (int x = 0; x < 4; x++) {
                if (b[x][r][x] == opp) {
                    count++;
                } else {

                    break;
                }
            }
        }addOpp(count);

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
}



