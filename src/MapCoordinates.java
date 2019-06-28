import java.util.Objects;

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



    @Override
    public int hashCode() {
        return Objects.hash(getCoordinateX(), getCoordinateY());
    }


    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        MapCoordinates coordinates = (MapCoordinates) obj;

        return (coordinates.getCoordinateX() == this.coordinateX && coordinates.getCoordinateY() == this.coordinateY);

    }


    @Override
    public String toString() {
        return "[x=" + coordinateX + ", y=" + coordinateY + "]";
    }


}

