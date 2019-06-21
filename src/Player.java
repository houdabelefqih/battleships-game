import java.util.HashSet;
import java.util.Set;

public class Player {

    private int playerCode;
    private String playerUsername;
    private Set<MapCoordinates> guesses;
    private int playerScore;

    apublic Player (int playerCode, String playerUsername){

        this.playerCode = playerCode;
        this.playerUsername = playerUsername;
        guesses = new HashSet<>();
        this.playerScore = 0;
    }


    public void setPlayerCode(int playerCode) {
        this.playerCode =playerCode;
    }

    public int getPlayerCode() {
        return playerCode;
    }

    public void setPlayerUsername(String playerUsername) {
        this.playerUsername = playerUsername;
    }

    public String getPlayerUsername() {
        return playerUsername;
    }

    public void setPlayerScore(int playerScore){
        this.playerScore = playerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }
}
