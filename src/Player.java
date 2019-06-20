import java.util.HashSet;
import java.util.Set;

public class Player {

    private int playerCode;
    private String playerUsername;
    private Set<Ship> guesses = new HashSet<Ship>();
    private int playerScore;

    public Player (){

        this.playerCode =0;
        this.playerUsername ="";
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
