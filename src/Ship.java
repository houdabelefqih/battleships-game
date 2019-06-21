public class Ship {

    private MapCoordinates coordinates;
    private boolean sunkStatus;
    private int playerCode ;


    public Ship (){

        this.coordinates= new MapCoordinates();
        this.sunkStatus=false;
        this.playerCode=0;
    }


    public void setCoordinates(MapCoordinates coordinates) {
        this.coordinates =coordinates;
    }

    public MapCoordinates getCoordinates() {
        return coordinates;
    }

    public void setSunkStatus(boolean sunkStatus) {
        this.sunkStatus = sunkStatus;
    }

    public boolean getSunkStatus() {
        return this.sunkStatus;
    }

    public void setPlayerCode(int playerCode) {
        this.playerCode = playerCode;
    }

    public int getPlayerCode() {
        return this.playerCode;
    }
}
