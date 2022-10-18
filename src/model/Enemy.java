package model;
import java.util.Random;

public class Enemy{

    private Level level;
    private String name;
    private EnemyType enemyType;
    private int defeatScore;
    private int playerDamage;
    private int resPosX;
    private int resPosY;

    public Enemy(String name, int enemyType, int defeatScore, int playerDamage, int resPixelX, int resPixelY){
        this.name = name;
        this.defeatScore = defeatScore;
        Random random = new Random();
        this.playerDamage = playerDamage;
        resPosX = random.nextInt(resPixelX);
        resPosY = random.nextInt(resPixelY);

        switch(enemyType){
            case 1:

                this.enemyType = EnemyType.OGRE;

                break;

            case 2:

                this.enemyType = EnemyType.ABSTRACT;

                break;

            case 3:

                this.enemyType = EnemyType.BOSS;

                break;

            case 4:

                this.enemyType = EnemyType.MAGIC;

                break;
        }
    }

    public String getName(){
        return name;
    }

    public int getPlayerDamage(){
        return playerDamage;
    }

    public int getDefeatScore(){
        return defeatScore;
    }

    public Level getLevel(){
        return level;
    }

    public int getType(){

        switch (enemyType){

            case OGRE:

                return 1;

            case ABSTRACT:

                return 2;

            case BOSS:

                return 3;

            case MAGIC:

                return 4;

            default:

                return 0;
        }
    }
}
