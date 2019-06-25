import com.sun.xml.internal.bind.v2.runtime.Coordinator;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class BattleShipsGame {

    public static void main(String[] args) {

    int maxShipsPlayer=5,x=0,y=0;
    MapCoordinates mapCoordinates = new MapCoordinates();

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
    System.out.println("Right now, the sea is empty.\n");
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

            } while (!oceanMap.isValidShipPosition(oceanMap, mapCoordinates));

            oceanMap.setOceanMapValue(mapCoordinates, '1');
        }

        /*
        Print new ocean map with user's ships deployed
         */
        oceanMap.printOceanMap();

        /*
        Randomly deploy computer's ships
         */

        deployComputerShips(oceanMap);

        /*
        Start the game
         */
        playTheGame();


    }


public static void playTheGame(){
    Player userPlayer = new Player(1, "human");
    Player computerPlayer = new Player(2, "computer");

}





public static void deployComputerShips(OceanMap oceanMap){

    int maxShipsPlayer=5;
    MapCoordinates mapCoordinates = new MapCoordinates();
    System.out.println("Computer is deploying ships:");
    Random randomCoordinate = new Random();


    for(int i=0;i <maxShipsPlayer; i++) {
        do {
            mapCoordinates.setCoordinateX(randomCoordinate.nextInt(10));
            mapCoordinates.setCoordinateY(randomCoordinate.nextInt(10));

        } while (!oceanMap.isValidShipPosition(oceanMap, mapCoordinates));

        oceanMap.setOceanMapValue(mapCoordinates, '2');
        System.out.println((i+1) + ". ship DEPLOYED.");
    }

}





public boolean gameIsOver(){
        boolean gameOver = false;

    return gameOver;
}


}