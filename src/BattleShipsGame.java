import java.util.Scanner;

public class BattleShipsGame {


    public static void main(String[] args) {

    char[][] oceanMap = new char[10][10];
    int rows = oceanMap.length;
    int columns = oceanMap[0].length;
    int x=0,y=0;
    int numberOfShips=5;

        /*
        Initialize the map with space character
         */
        for (int i=0; i<rows;i++) {
            for (int j = 0; j < columns; j++) {
                oceanMap[i][j]=' ';
            }
        }

    /*
    Display Welcome message and initial empty board
     */
    System.out.println("**** Welcome to the Battle Ships game ****");
    System.out.println("Right now, the sea is empty.");

    printOceanMap(oceanMap);

    /*
    Ask the user to place their ship on the board. Check for invalid positions.
     */
    Scanner input = new Scanner(System.in);

    for(int i=0;i <numberOfShips; i++)
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
        oceanMap[x][y] = '1';
        printOceanMap(oceanMap);

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
    public static boolean isValidShipPosition(char[][] oceanMap, int x, int y)
    {
        int rows = oceanMap.length;
        int columns = oceanMap[0].length;
        boolean isValid = true;

        if(x >= rows || y>= columns)
            {isValid = false;
            System.out.println("X coordinate cannot exceed " + (rows -1));
            System.out.println("Y coordinate cannot exceed " + (columns -1));}

        else
            if(oceanMap[x][y]==' ')
                isValid = false;


    return isValid;

    }

/*
This functions displays the battle ships board i.e 2D matrix
 */
    public static void printOceanMap(char[][] oceanMap)
    {
        int rows = oceanMap.length;
        int columns = oceanMap[0].length;

        System.out.print("   ");
        for (int k=0;k< columns; k++)
            System.out.print(k);

        System.out.print("\n");

        for (int i=0; i<rows;i++) {
            System.out.print(i + " |");

            for (int j = 0; j < columns; j++) {

                if(oceanMap[i][j]== '1')
                    System.out.print('@');
                else
                     System.out.print(oceanMap[i][j]);
            }

            System.out.println("| " + i);
        }

        System.out.print("   ");
        for (int k=0;k< columns; k++)
            System.out.print(k);

        System.out.print("\n");

    }
}
