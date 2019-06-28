import java.util.*;

public class BattleShipsGame {


    public static void main(String[] args) {

    int maxShipsPlayer=5;
    MapCoordinates mapCoordinates = new MapCoordinates();

    HashMap<Character, Character> symbolMap= new HashMap<>();
    symbolMap.put('I',' ');
    symbolMap.put('1','@');
    symbolMap.put('2',' ');
    symbolMap.put('3','-');
    symbolMap.put('4','!');
    symbolMap.put('5','x');
    symbolMap.put('C',' ');

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
        oceanMap.setPlayerCodeTurn(1);
        playTheGame(oceanMap);

    }


public static void playTheGame(OceanMap oceanMap){
    Player userPlayer = new Player(1);
    Player computerPlayer = new Player(2);
    MapCoordinates mapCoordinates;
    Set<MapCoordinates> allGuesses = new HashSet<>();


    while(!gameIsOver(oceanMap, userPlayer, computerPlayer)) {

        Scanner input = new Scanner(System.in);

        if (oceanMap.getPlayerCodeTurn() == 1) {

            System.out.println("\n\nYOUR TURN: ");

            do {
                mapCoordinates = new MapCoordinates();

                System.out.print("Enter X coordinate: ");
                mapCoordinates.setCoordinateX(input.nextInt());

                System.out.print("Enter Y coordinate: ");
                mapCoordinates.setCoordinateY(input.nextInt());

            }while(!isValidGuess(oceanMap,mapCoordinates,userPlayer, allGuesses));

            userPlayer.addGuess(mapCoordinates);
            allGuesses.add(mapCoordinates);
            evaluateGuess(oceanMap,mapCoordinates,userPlayer,computerPlayer);


        } else if (oceanMap.getPlayerCodeTurn() == 2) {

            System.out.println("\n\nCOMPUTER'S TURN: ");

            Random randomCoordinate = new Random();
            do {
                mapCoordinates = new MapCoordinates();
                mapCoordinates.setCoordinateX(randomCoordinate.nextInt(10));
                mapCoordinates.setCoordinateY(randomCoordinate.nextInt(10));

            } while (!isValidGuess(oceanMap,mapCoordinates,computerPlayer, allGuesses));

            computerPlayer.addGuess(mapCoordinates);

             System.out.println("Cpmouter guesses:" + computerPlayer.getGuesses());

            allGuesses.add(mapCoordinates);
            evaluateGuess(oceanMap,mapCoordinates,userPlayer,computerPlayer);

        } else {

            System.out.println("Player code not recognized.");
        }

        int userShips = oceanMap.getMaxShipsPerPlayer() - computerPlayer.getPlayerScore();
        int computerShips = oceanMap.getMaxShipsPerPlayer() - userPlayer.getPlayerScore();

        oceanMap.printOceanMap();
        System.out.println("Your ships:" +  userShips +" | Computer ships:"+  computerShips);

        /*
         *      Switch turns
         */

        oceanMap.setPlayerCodeTurn(oceanMap.getPlayerCodeTurn()%2 +1);
    }

    /**
     * Evaluate score when the game is over.
     */

        if(computerPlayer.getPlayerScore() > userPlayer.getPlayerScore())
            System.out.println("Computer won the game.");
        else if (computerPlayer.getPlayerScore() < userPlayer.getPlayerScore())
            System.out.println("Yay!!!! You won the game.");
        else
            System.out.println("TIE");

}

public static void deployComputerShips(OceanMap oceanMap){

    int maxShipsPlayer= oceanMap.getMaxShipsPerPlayer();
    MapCoordinates mapCoordinates = new MapCoordinates();
    Random randomCoordinate = new Random();


    System.out.println("Computer is deploying ships:");


    for(int i=0;i <maxShipsPlayer; i++) {
        do {
            mapCoordinates.setCoordinateX(randomCoordinate.nextInt(10));
            mapCoordinates.setCoordinateY(randomCoordinate.nextInt(10));

        } while (!oceanMap.isValidShipPosition(oceanMap, mapCoordinates));

        oceanMap.setOceanMapValue(mapCoordinates, '2');
        System.out.println((i+1) + ". ship DEPLOYED.");
    }

}


public static boolean gameIsOver(OceanMap oceanMap, Player human, Player computer){

    boolean gameOver;

    if (human.getPlayerScore() == oceanMap.getMaxShipsPerPlayer() ||computer.getPlayerScore() == oceanMap.getMaxShipsPerPlayer())
        gameOver = true;
    else
        gameOver=false;

    return gameOver;
}


public static boolean isValidGuess(OceanMap oceanMap, MapCoordinates coordinates, Player player, Set AllGuesses){

        int rows = oceanMap.getOceanMapRows();
        int columns = oceanMap.getOceanMapColumns();
        boolean isValidGuess= true;
        /**
         * For debugging

         System.out.println("Size of set " + player.getGuesses().size());
         System.out.println(player.getGuesses());
        */

    if(coordinates.getCoordinateX() >= rows || coordinates.getCoordinateY() >= columns){
            isValidGuess = false;
            if(player.getPlayerCode() == 1) {
                System.out.println("X coordinate cannot exceed " + (rows - 1));
                System.out.println("Y coordinate cann1ot exceed " + (columns - 1));
                System.out.println("TRY AGAIN:");
            }
        }

    else {
            if (player.getGuesses().contains(coordinates)){
                isValidGuess =false;
                if(player.getPlayerCode()==1) {
                    System.out.println("You already guessed these coordinates");
                }

            else if (AllGuesses.contains(coordinates) && player.getPlayerCode() == 2){
                isValidGuess = false;
            }
            }
        }
        return isValidGuess;
    }

public static void evaluateGuess(OceanMap oceanMap, MapCoordinates mapCoordinates, Player userPlayer, Player computerPlayer){

    switch(oceanMap.getPlayerCodeTurn()) {
        case 1:
            switch (oceanMap.getOceanMapValue(mapCoordinates)) {
                case '2':
                    System.out.println("Boom you sunk the ship.");
                    oceanMap.setOceanMapValue(mapCoordinates, '4');
                    userPlayer.setPlayerScore(userPlayer.getPlayerScore()+1);
                    break;
                case '1':
                    System.out.println("Oh no, you sunk your own ship.");
                    oceanMap.setOceanMapValue(mapCoordinates, '5');
                    computerPlayer.setPlayerScore(computerPlayer.getPlayerScore()+1);
                    break;

                default:
                    System.out.println("Sorry, you missed.");
                    oceanMap.setOceanMapValue(mapCoordinates, '3');
                    break;
            }
            break;

        case 2:
            switch (oceanMap.getOceanMapValue(mapCoordinates)) {
                case '1':
                    System.out.println("The computer sunk one of your ships.");
                    oceanMap.setOceanMapValue(mapCoordinates, '5');
                    computerPlayer.setPlayerScore(computerPlayer.getPlayerScore()+1);
                    break;
                case '2':
                    System.out.println("The computer sunk one of its own ships.");
                    oceanMap.setOceanMapValue(mapCoordinates, '4');
                    userPlayer.setPlayerScore(userPlayer.getPlayerScore()+1);
                    break;

                default:
                    System.out.println("Computer missed.");
                    oceanMap.setOceanMapValue(mapCoordinates, 'C');
                    break;
            }
            break;

        default:
            System.out.println("Player not recognized.");

    }
}


}