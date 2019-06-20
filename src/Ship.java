public class Ship {


    private int coordinateX;
    private int coordinateY;
    private boolean sunkStatus;
    private int playerCode ;


    public Ship (){

        this.coordinateX =0;
        this.coordinateY=0;
        this.sunkStatus=false;
        this.playerCode=0;
    }


    public void setCoordinateX(int coordinateX) {
        this.coordinateX =coordinateX;
    }

    public int getCoordinateX() {
        return this.coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public int getCoordinateY() {
        return this.coordinateY;
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
