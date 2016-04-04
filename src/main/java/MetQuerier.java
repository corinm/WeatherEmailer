import java.io.IOException;

public class MetQuerier {

    // Met Office Datapoint
    private String metKey = System.getenv("MET_KEY");
    private String urlMetLocations = "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=";
    private String urlMetWeather1 = "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/";
    private String urlMetWeather2 = "?res=3hourly&key=";

    private HttpConnector hc;

    MetQuerier() {

        this.hc = new HttpConnector();

    }

    public String requestMetLocations() {

        //System.out.println();
        //System.out.println(">> OBTAINING MET LOCATIONS");

        String tempUrl = urlMetLocations + metKey;
        String response = null;

        try {
            response = hc.sendGet(tempUrl);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public String requestWeatherData(Location location) {

        //System.out.println();
        //System.out.println(">> OBTAINING WEATHER DATA");

        String tempUrl = urlMetWeather1 + location.getMetId() + urlMetWeather2 + metKey;
        String response = null;

        try {
            response = hc.sendGet(tempUrl);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
