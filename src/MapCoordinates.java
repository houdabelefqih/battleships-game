public class MapCoordinates {
    private int coordinateX;
    private int coordinateY;


    public MapCoordinates (){

        this.coordinateX =0;
        this.coordinateY=0;
    }


    public void setMapCoordinates(int coordinateX, int coordinateY){

        this.coordinateX =coordinateX;
        this.coordinateY=coordinateY;
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
}

