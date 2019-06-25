import java.util.HashMap;

import static java.lang.System.exit;

public class OceanMap {

    private int oceanMapRows;
    private int oceanMapColumns;
    private char[][] oceanMap;
    private char initialization;
    private int maxShipsPerPlayer;
    private int playerCodeTurn;
    private boolean gameIsOver;
    private HashMap<Character, Character> symbolMap;


    public OceanMap(int oceanMapRows, int oceanMapColumns, int maxShipsPerPlayer){

       this.oceanMapRows = oceanMapRows;
       this.oceanMapColumns = oceanMapColumns;
       this.initialization='I';
       this.oceanMap = initializeOceanMap(oceanMapRows,oceanMapColumns,initialization);
       this.maxShipsPerPlayer=maxShipsPerPlayer;
       this.playerCodeTurn=0;
       this.gameIsOver=false;
       this.symbolMap= new HashMap<>();

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

    public void setOceanMap(char[][] oceanMap) {
        this.oceanMap = oceanMap;
    }

    public char[][] getOceanMap() {
        return oceanMap;
    }

    public void setOceanMapValue(MapCoordinates mapCoordinates, char value) {
        this.oceanMap[mapCoordinates.getCoordinateX()][mapCoordinates.getCoordinateY()] = value;
    }

    public char getOceanMapValue(MapCoordinates mapCoordinates) {
        return this.oceanMap[mapCoordinates.getCoordinateX()][mapCoordinates.getCoordinateY()];
    }

    public void setInitialization(char initializationChar){
        this.initialization = initializationChar;
    }

    public char getInitialization(){
       return initialization;
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

    public void setSymbolMap(HashMap<Character, Character> symbolMap) {
        this.symbolMap = symbolMap;
    }

    public HashMap<Character, Character> getSymbolMap() {
        return symbolMap;
    }

    public char[][] initializeOceanMap (int oceanMapRows, int oceanMapColumns, char initialization)
    {
        char[][] oceanMap= new char[oceanMapRows][oceanMapColumns];
        /*
        Initialize the map with space character
         */
        for (int i=0; i<oceanMapRows;i++) {
            for (int j = 0; j < oceanMapColumns; j++) {
                oceanMap[i][j]= initialization;

            }
        }
        return oceanMap;

    }

    /*
    This functions displays the battle ships board i.e 2D matrix
     */
    public void printOceanMap() {
        int rows = this.getOceanMapRows();
        int columns = this.getOceanMapColumns();
        MapCoordinates mapCoordinates = new MapCoordinates();

        if (rows <= 0 || columns <= 0) {
            System.out.println("Error printing ocean map.");
            exit(0);
        } else {

            System.out.print("   ");
            for (int k = 0; k < columns; k++)
                System.out.print(k);

            System.out.print("\n");

            for (int i = 0; i < rows; i++) {
                System.out.print(i + " |");

            /*
            Print characters according to hashmap values stored in the 2D oceanMap matrix
                - 0 ----> ' '   (Position is empty)
                - 1 ----> @     (Where the player's ships are positioned)
                - 2 ----> ' '   (Where the computer's ships are positioned)
                - 3 ----> -     (Player missed)
                - 4 ----> !     (Player hits a computer ship OR Computer hits its own ship)
                - 5 ----> x     (Computer hits a player ship OR Player hits its own ship )
             */
                for (int j = 0; j < columns; j++) {
                    if (symbolMap.isEmpty() || this.getOceanMap() == null) {
                        System.out.println("Error printing ocean map");
                        exit(0);
                    } else {
                        mapCoordinates.setCoordinateX(i);
                        mapCoordinates.setCoordinateY(j);
                        System.out.print(this.symbolMap.get(this.getOceanMapValue(mapCoordinates)));
                    }
                }

                System.out.println("| " + i);
            }

            System.out.print("   ");
            for (int k = 0; k < columns; k++)
                System.out.print(k);

            System.out.print("\n");

        }
    }



    /*
    This functions validates ship positions entered by the user
     */
    public static boolean isValidShipPosition(OceanMap oceanMap, MapCoordinates coordinates )
    {
        int rows = oceanMap.getOceanMapRows();
        int columns = oceanMap.getOceanMapColumns();
        boolean isValid = true;

        if(coordinates.getCoordinateX() >= rows || coordinates.getCoordinateY() >= columns){
            isValid = false;
            System.out.println("X coordinate cannot exceed " + (rows -1));
            System.out.println("Y coordinate cannot exceed " + (columns -1));
            System.out.println("TRY AGAIN:");
        }

        else {
            if (oceanMap.getOceanMapValue(coordinates) != 'I') {
                System.out.println("----- THERE'S ALREADY HAVE A SHIP HERE. -----");
                System.out.println("TRY AGAIN:");

                isValid = false;
            }
        }

        return isValid;

    }


}
