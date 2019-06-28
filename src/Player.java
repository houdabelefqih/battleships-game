import java.util.HashSet;
import java.util.Set;

public class Player {

    private int playerCode;
    private Set<MapCoordinates> guesses;
    private int playerScore;

    public Player (int playerCode){

        this.playerCode = playerCode;
        guesses = new HashSet<>();
        this.playerScore = 0;
    }


    public void setPlayerCode(int playerCode) {
        this.playerCode =playerCode;
    }

    public int getPlayerCode() {
        return playerCode;
    }


    public void setPlayerScore(int playerScore){
        this.playerScore = playerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public Set<MapCoordinates> getGuesses() {
        return guesses;
    }

    public void setGuesses(Set<MapCoordinates> guesses) {
        this.guesses = guesses;
    }

    public void addGuess(MapCoordinates coordinates){

        this.guesses.add(coordinates);
    }
}
