

public class PointScore {
    Location l;
    int Score;
    public PointScore(int Score,Location l) {
        this.Score = Score;
        this.l = l;
    }

    public Location getL() {
        return l;
    }

    public int getScore() {
        return Score;
    }

    public void setL(Location l) {
        this.l = l;
    }

    public void setScore(int score) {
        Score = score;
    }
}
