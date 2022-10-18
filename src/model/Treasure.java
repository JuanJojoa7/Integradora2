package model;
import java.util.Random;

public class Treasure{

    private String name;
    private String urlShowImage;
    private Level level;
    private int scoreToPlayer;
    private int resPosX;
    private int resPosY;

    public Treasure(String name, String imageUrl, int scoreTR, int posx, int posy) {
        Random random = new Random();
        this.name = name;
        this.urlShowImage = imageUrl;
        this.scoreToPlayer = scoreTR;
        resPosX = random.nextInt(posy); 
        resPosY = random.nextInt(posx);
    }

    public int getScore() {
        return scoreToPlayer;
    }

    public String getName() {
        return name;
    }

    public Level getLevel(){
        return level;
    }
}