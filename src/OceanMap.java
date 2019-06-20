import java.util.ArrayList;

public class OceanMap {

    private int oceanMapRows;
    private int oceanMapColumns;
    private char[][] oceanMap;
    private char initializationChar;
    private int maxShipsPerPlayer;
    private int playerCodeTurn;
    private boolean gameIsOver;


    public OceanMap(int oceanMapRows, int oceanMapColumns, int maxShipsPerPlayer){

       this.oceanMapRows = oceanMapRows;
       this.oceanMapColumns = oceanMapColumns;
       this.initializationChar=' ';
       this.oceanMap = initializeOceanMap(oceanMapRows,oceanMapColumns,initializationChar);
       this.maxShipsPerPlayer=maxShipsPerPlayer;
       this.playerCodeTurn=0;
       this.gameIsOver=false;

    }


    public void setOceanMapRows(int oceanMapRows){
        this.oceanMapRows = oceanMapRows;
    }

    public int getOceanMapRows(){
       return this.oceanMapRows;
    }

    public void setOceanMapColumns(int oceanMapColumns){
        this.oceanMapColumns = oceanMapColumns;
    }

    public int getOceanMapColumns(){
        return this.oceanMapColumns;
    }

    public void setOceanMapValue(int coordinateX, int coordinateY, char value) {
        this.oceanMap[coordinateX][coordinateY] = value;
    }

    public char getOceanMapValue(int coordinateX, int coordinateY) {
        return this.oceanMap[coordinateX][coordinateY];
    }

    public void setInitializationChar(char initializationChar){
        this.initializationChar = initializationChar;
    }

    public char getInitializationChar(){
       return initializationChar;
    }

    public void setMaxShipsPerPlayer(int maxShipsPerPlayer) {
        this.maxShipsPerPlayer = maxShipsPerPlayer;
    }

    public int getMaxShipsPerPlayer() {
        return this.maxShipsPerPlayer;
    }

    public void setPlayerCodeTurn(int playerCodeTurn){
        this.playerCodeTurn=playerCodeTurn;
    }

    public int getPlayerCodeTurn() {
        return this.playerCodeTurn;
    }

    public void setGameIsOver(boolean gameIsOver) {
        this.gameIsOver = gameIsOver;
    }

    public boolean getGameIsOver() {
        return this.gameIsOver;
    }


    public char[][] initializeOceanMap (int oceanMapRows, int oceanMapColumns, char initializationChar)
    {
        char[][] oceanMap= new char[oceanMapRows][oceanMapColumns];
        /*
        Initialize the map with space character
         */
        for (int i=0; i<oceanMapRows;i++) {
            for (int j = 0; j < oceanMapColumns; j++) {
                oceanMap[i][j]=initializationChar;
            }
        }
     return this.oceanMap;

    }



    /*
    This functions displays the battle ships board i.e 2D matrix
     */
    public void printOceanMap()
    {
        int rows = this.getOceanMapRows();
        int columns = this.getOceanMapColumns();

        System.out.print("   ");
        for (int k=0;k< columns; k++)
            System.out.print(k);

        System.out.print("\n");

        for (int i=0; i<rows;i++) {
            System.out.print(i + " |");

            for (int j = 0; j < columns; j++) {

                if(this.getOceanMapValue(i,j) == '1')
                    System.out.print('@');
                else
                    System.out.print(this.getOceanMapValue(i,j));
            }

            System.out.println("| " + i);
        }

        System.out.print("   ");
        for (int k=0;k< columns; k++)
            System.out.print(k);

        System.out.print("\n");

    }




}
