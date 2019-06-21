import com.sun.xml.internal.bind.v2.runtime.Coordinator;

import java.util.HashMap;
import java.util.Scanner;

public class BattleShipsGame {


    public static void main(String[] args) {

    int maxShipsPlayer=5,x=0,y=0;
    MapCoordinates mapCoordinates = new MapCoordinates();
    Player userPlayer = new Player(1, "human");
    Player computerPlayer = new Player(2, "computer");


    HashMap<Character, Character> symbolMap= new HashMap<>();
    symbolMap.put('I',' ');
    symbolMap.put('1','@');
    symbolMap.put('2',' ');
    symbolMap.put('3','-');
    symbolMap.put('4','!');
    symbolMap.put('5','x');


    OceanMap oceanMap = new OceanMap(10,10, maxShipsPlayer);
    oceanMap.setSymbolMap(symbolMap);

    /*
    Display Welcome message and initial empty board
     */
    System.out.println("**** Welcome to the Battle Ships game ****");
    System.out.println("Right now, the sea is empty.");
    oceanMap.printOceanMap();

    /*
    *   Ask the user to place their ship on the board. Check for invalid positions.
    *   For the sake of simplicity here we are assuming the user player enters ints
    */
    Scanner input = new Scanner(System.in);
    System.out.println("Deploy your ships: ");

        for(int i=0;i <maxShipsPlayer; i++) {
            do {

                System.out.println("Ship #" + (i + 1));

                System.out.print("Enter X coordinate for your ship: ");
                mapCoordinates.setCoordinateX(input.nextInt());

                System.out.print("Enter Y coordinate for your ship: ");
                mapCoordinates.setCoordinateY(input.nextInt());

            } while (!isValidShipPosition(oceanMap, mapCoordinates));

            oceanMap.setOceanMapValue(mapCoordinates, '1');
        }

    }


public static void playTheGame(){
}


public void generateComputerShips(char[][] oceanMap){
}


public boolean gameIsOver(){
        boolean gameOver = false;
        
    return gameOver;
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
                System.out.println("----- YOU ALREADY HAVE A SHIP HERE. -----");
                System.out.println("TRY AGAIN:");

                isValid = false;
            }
        }

    return isValid;

    }


}