import java.util.Scanner;

public class BattleShipsGame {


    public static void main(String[] args) {

    int maxShipsPlayer=5,x=0,y=0;
    OceanMap oceanMap = new OceanMap(10,10, maxShipsPlayer);

    /*
    Display Welcome message and initial empty board
     */
    System.out.println("**** Welcome to the Battle Ships game ****");
    System.out.println("Right now, the sea is empty.");

    oceanMap.printOceanMap();

    /*
    Ask the user to place their ship on the board. Check for invalid positions.
     */
    Scanner input = new Scanner(System.in);

    for(int i=0;i <maxShipsPlayer; i++)
        do {

            System.out.print("Deploy your ships: ");
            System.out.print("Enter X coordinate for your ship: ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate for your ship: ");
            y = input.nextInt();

        }while(!isValidShipPosition(oceanMap, x,y));

        /*
        Add ship to the list of ships the user has placed on the board.
         */
       // oceanMap[x][y] = '1';
       // printOceanMap(oceanMap);

    }


public static void playTheGame(){







}


public void generateComputerShips(char[][] oceanMap)
{





}


public boolean gameIsOver(){

        boolean gameOver = false;




        return gameOver;
}


/*
This functions validates ship positions entered by the user
 */
    public static boolean isValidShipPosition(OceanMap oceanMap, int coordinateX, int coordinateY)
    {
        int rows = oceanMap.getOceanMapRows();
        int columns = oceanMap.getOceanMapColumns();
        boolean isValid = true;

        if(coordinateX >= rows || coordinateY>= columns)
            {isValid = false;
            System.out.println("X coordinate cannot exceed " + (rows -1));
            System.out.println("Y coordinate cannot exceed " + (columns -1));}

        else
            if(oceanMap.getOceanMapValue(coordinateX,coordinateY)==' ')
                isValid = false;


    return isValid;

    }

}
