import java.util.LinkedList;

public class ForecastAll {

    private String location;
    private int metId;

    private LinkedList<ForecastDay> forecasts;

    ForecastAll(LinkedList<ForecastDay> forecasts, String location, int metId) {

        this.forecasts = forecasts;
        this.location = location;
        this.metId = metId;

    }

    public LinkedList<ForecastDay> getForecasts() {
        return forecasts;
    }

    public String getLocation() {
        return location;
    }

    public String getSubject(String postcode) {

        String subject = "Weather Summary for ";

        subject = subject + postcode;

        return subject;
    }
}
