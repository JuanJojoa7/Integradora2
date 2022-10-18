package model;

public class Player{

    private String nickname;
    private String name;
    private int score;
    private int lives;

    private static final int INITIAL_SCORE = 10;
    private static final int INITIAL_LIVES = 5;

    private Level level;

    public Player(String nickName, String name, Level level) {
        this.nickname = nickName;
        this.name = name;
        this.level = level;
        score = INITIAL_SCORE;
        lives = INITIAL_LIVES;
    }

    public String getNickname() {
        return nickname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
