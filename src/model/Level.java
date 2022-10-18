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

    /** addEnemyToGame: It is responsible for adding the enemy to the game.
    * @param name: String => It is the name of the enemy to be registered.
    * @param enemyType: int => This is the type of enemy into which the enemy will be classified.
    * @param defeatScore: int => It is the score that the enemy will give if defeated.
    * @param playerDamage: int => This is the score that will be taken away from the player if he is hit.
    * @param resPixelX: int => It is resolution X where the enemy will be.
    * @param resPixelY: int => It is the Y resolution at which the enemy will be.
    * @return msgConfirmation: String => It is the message of confirmation of the creation of the new enemy.
    */
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

    /** isFoundSpaceEnemies: It is responsible for finding an available space to add enemies to the game.
    * @param name: String => It is the name of the enemy to be added.
    * @return flag: boolean => It is the confirmation of whether there are spaces, and also validates the name.
    */
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

    /** isFoundSpaceTreasures: He is in charge of finding space in the treasure array.
    * @return flag: boolean => It is the validation of whether space was found.
    */
    public boolean isFoundSpaceFTreasures(){

        boolean flag = false;

        for(int i=0; i<SIZE_OF_TREASURES && !flag; i++){

            if(treasures[i] == null){

                flag = true;

            }
        }
        return flag;
    }

    /** addTreasureToGame: It is responsible for adding the enemy to the game.
    * @param name: String => It is the name of the treasure to be added.
    * @param urlShowImage: String => This is the url of the treasure to be added.
    * @param scoreToPlayer: int => It is the score that will be given to the player if he finds the treasure.
    * @param qlevel: int => It is the amount of treasures that will be in the level.
    * @param resPixelX: int => It is resolution X where the treasure will be.
    * @param resPixelY: int => It is the Y resolution at which the treasure will be.
    * @return msgConfirmation: String => This is the confirmation message of the added treasure.
    */
    public String addTreasureToGame(String name, String urlShowImage, int scoreToPlayer, int qLevel, int resPixelX, int resPixelY){

        String msgConfirmation = "\nLos tesoros registrados han sido agregados correctamente.";
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

                    msgConfirmation = "\nLo sentimos, ha alcanzado el limite de tesoros.";

                    flag = true;
                }
            }
        }
        return msgConfirmation;
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

    /** getAmountTypeTreasure: It is the method to search the number of treasures by name.
    * @param name: int => It is the name under which the treasures will be consulted.
    * @return qTreasures: int => Collect all the treasures requested by name.
    */
    public int getAmountTypeTreasure(String name){

        int qTreasures = 0;
        for(int i = 0; i < SIZE_OF_TREASURES; i++){

            if(treasures[i] != null && treasures[i].getName().equals(name)){

                qTreasures++;
            }
        }

        return qTreasures;
    }

    /** getEnemiesType: It is in charge of obtaining all the enemies of a specific type.
    * @param enemyType: int => This is the type of enemy chosen to consult.
    * @return enemyAmount: int => They are the counted enemies of a type of enemy.
    */
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

    /** getConsonants: It is responsible for obtaining all the consonants of the enemies' names.
    * @return countedConsonants: int => They are the counted consonants of the names of enemies.
    */
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

    public String getMaxEnemyName(){

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

    public int getMaxEnemyScore(){

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
