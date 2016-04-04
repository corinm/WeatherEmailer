import java.util.HashMap;

public class Location {

    private String postcode;
    private double latitudeActual;
    private double longitudeActual;
    private int metId;

    // This is the location according to the Met Office's nearest data source
    private String location;

    private PostcodesIOQuerier pq;
    private JSONProcessor jp;
    private LatLongSearcher lls;

    Location(String postcode) {

        this.pq = new PostcodesIOQuerier();
        this.jp = new JSONProcessor();

        this.setPostcode(postcode);
        this.getLatAndLong();

        this.lls = new LatLongSearcher();
        int nearestId = lls.searchMetLocations(this);
        this.setMetId(nearestId);
    }

    private void setPostcode(String postcode) {

        if (validatePostcode(postcode)) {
            this.postcode = postcode;
            //System.out.println("Postcode valid");

        } else {
            //System.out.println("Invalid postcode");
        }

    }

    private boolean validatePostcode(String postcode) {

        boolean valid;

        //System.out.println(">> CHECKING POSTCODE");

        String jsonString = pq.requestPostcodeCheck(postcode);
        valid = jp.parseValidPostcodeJSON(jsonString);

        return valid;
    }

    private void getLatAndLong() {

        //System.out.println();
        //System.out.println(">> GETTING LAT AND LONG");

        String jsonString = pq.requestLatLong(postcode);

        HashMap<String,Double> longLat = jp.parseLatPostcodeJSON(jsonString);

        this.latitudeActual = longLat.get("latitude");
        this.longitudeActual = longLat.get("longitude");
    }

    public double getLongitudeActual() {
        return longitudeActual;
    }

    public int getMetId() {
        return metId;
    }

    public void setMetId(int metId) {
        this.metId = metId;
    }

    public double getLatitudeActual() {
        return latitudeActual;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
