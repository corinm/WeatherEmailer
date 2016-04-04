import java.util.LinkedList;

public class MetLocations {

    private LinkedList<double[]> metLatLongs;
    private LinkedList<Integer> metIds;

    MetLocations(LinkedList<double[]> metLatLongs, LinkedList<Integer> metIds) {

        this.metLatLongs = metLatLongs;
        this.metIds = metIds;

    }

    public LinkedList<double[]> getMetLatLongs() {
        return metLatLongs;
    }

    public LinkedList<Integer> getMetIds() {
        return metIds;
    }
}
