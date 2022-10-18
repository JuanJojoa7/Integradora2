package model;

public class Level{
    
    public static final int SIZE_OF_PLAYERS = 20;
    public static final int SIZE_OF_LEVELS = 10;
    public static final int SIZE_OF_TREASURES = 50;
    public static final int SIZE_OF_ENEMIES = 25;

    private int id;
    private int necessaryScore;
    private Enemy[] enemies;
    private Treasure[] treasures;

    public Level(int id, int scoreRequired){

        enemies = new Enemy[SIZE_OF_ENEMIES];
        treasures = new Treasure[SIZE_OF_TREASURES];
        this.id = id;
        this.necessaryScore = necessaryScore;
    }

    public String addEnemyToGame(String name, int enemyType, int defeatScore, int playerDamage, int resPixelX, int resPixelY){

        String msgConfirmation = "\nEl enemigo ha sido agregado al juego satisfactoriamente.";
        boolean flag = false;

        for(int i=0;i< SIZE_OF_ENEMIES && !flag; i++){

            if(enemies[i] == null){

                enemies[i] = new Enemy(name, enemyType, defeatScore, playerDamage, resPixelX, resPixelY);
                flag = true;
            }
            
        }
        return msgConfirmation;
    }

    public int getId(){
        return id;
    }
    
    public int getScoreRequired(){
        return necessaryScore;
    }

    public boolean isFoundSpaceEnemies(String name){

        boolean flag = false;
        
        for(int i=0; i<SIZE_OF_ENEMIES && !flag; i++){

            if(enemies[i] != null && enemies[i].getName().equals(name)){

                return false;

            }

            if(enemies[i] == null){

                flag = true;

            }
        }
        return flag;
    }

    public boolean isFoundSpaceFTreasures(){

        boolean flag = false;

        for(int i = 0; i < SIZE_OF_TREASURES && !flag; i++){

            if(treasures[i] == null){

                flag = true;

            }
        }
        return flag;
    }

    public String addTreasureToGame(String name, String urlShowImage, int scoreToPlayer, int qLevel, int resPixelX, int resPixelY){

        String msGConfirmation = "\nLos tesoros registrados han sido agregados correctamente.";
        boolean flag = false;
        int flagList = 0;

        for(int i = 0; i < SIZE_OF_TREASURES & !flag; i++){

            if(treasures[i] == null){

                if(i + qLevel <= SIZE_OF_TREASURES){

                    flagList = i;

                    for(int ifSearch = 0; ifSearch < qLevel; ifSearch++){

                        treasures[flagList] = new Treasure(name, urlShowImage, scoreToPlayer, resPixelX, resPixelY); flagList++;
                    }

                    flag = true;

                }else{

                    msGConfirmation = "\nLo sentimos, ha alcanzado el limite de tesoros.";

                    flag = true;
                }
            }
        }
        return msGConfirmation;
    }

    public String[] getEnemiesName(){

        String enemiesFounded[] = new String[SIZE_OF_ENEMIES];

        for(int i = 0; i < SIZE_OF_ENEMIES; i++){

           if(enemies[i] != null){

            enemiesFounded[i] = enemies[i].getName();

           }
        }

        return enemiesFounded;
    }

    public String[] getTreasuresName(){

        String treasuresFounded[] = new String[SIZE_OF_TREASURES];

        for(int i = 0; i < SIZE_OF_TREASURES; i++){

           if(treasures[i] != null){
            
            treasuresFounded[i] = treasures[i].getName();

           }
        }

        return treasuresFounded;
    }

    public int getAmountTypeTreasure(String name){

        int qTreasures = 0;
        for(int i = 0; i < SIZE_OF_TREASURES; i++){

            if(treasures[i] != null && treasures[i].getName().equals(name)){

                qTreasures++;
            }
        }

        return qTreasures;
    }

    public int getEnemiesType(int enemyType){

        int enemyAmount = 0;

        for(int i = 0; i < SIZE_OF_ENEMIES; i++){

            if(enemies[i] != null && enemies[i].getType() == enemyType){ enemyAmount++;

            }
        }

        return enemyAmount;
    }

    public int getMaxTreasures(){
        return SIZE_OF_TREASURES;
    }

    public int getConsonants(){

        int countedConsonants = 0;

        for(int i = 0; i < SIZE_OF_ENEMIES; i++){

            if(enemies[i] != null){

                int wordsByConsonants = enemies[i].getName().length();
                boolean ifContinue = false;
                for(int j = 0; j < wordsByConsonants; j++){

                    if(enemies[i].getName().toLowerCase().charAt(j) != 'a' 

                    && enemies[i].getName().toLowerCase().charAt(j) != 'e'

                    && enemies[i].getName().toLowerCase().charAt(j) != 'i'

                    && enemies[i].getName().toLowerCase().charAt(j) != 'o'

                    && enemies[i].getName().toLowerCase().charAt(j) != 'u'){

                        countedConsonants++;
                    }
                }
            }
        }

        return countedConsonants;
    }

    public String getBestEnemyName(){

        int topScore = 0;
        boolean ifSelected = true;
        String name = null;
        double selected = 0.0;
        for(int i=0; i<SIZE_OF_ENEMIES; i++){

            if(enemies[i] != null && enemies[i].getDefeatScore()>topScore){

                topScore = enemies[i].getDefeatScore();

                name = enemies[i].getName();
            }
        }
        return name;
    }

    public int getBestEnemyScore(){

        String msgVal = null;
        String name = null;
        int topScore  = 0;
        
        for(int i = 0; i < SIZE_OF_ENEMIES; i++){

            if(enemies[i] != null && enemies[i].getDefeatScore()>topScore){

                boolean continueSearch = false;
                topScore = enemies[i].getDefeatScore();

                name = enemies[i].getName();
            }
        }

        return topScore;
    }
}
