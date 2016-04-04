public class Forecast3Hr {

    private int hours;
    private String time;

    private String windDirection;
    private int tempFeelsLike;
    private int windGust;
    private int relHumidity;
    private int precipitationProb;
    private int windSpeed;

    public String getTime() {
        return time;
    }

    public String getWeatherTypeFull() {
        return weatherTypeFull;
    }

    private int temp;
    private int uv;

    // Visibility (E = Excellent, VG = Very Good, G = Good, M = Moderate, P = Poor, VP = Very Poor)
    private String visibility;
    private int weatherType;
    private String weatherTypeFull;
    private int weatherTypeSimple;
    private String color;
    private String textColor;

    public String getTextColor() {
        return textColor;
    }

    public Forecast3Hr(int hours, String time, String windDirection, int tempFeelsLike, int windGust, int relHumidity,
                       int precipitationProb, int windSpeed, int temp, int uv, String visibility, int weatherType,
                       String weatherTypeFull, int weatherTypeSimple, String color, String textColor) {

        this.hours = hours;
        this.time = time;

        this.windDirection = windDirection;
        this.tempFeelsLike = tempFeelsLike;
        this.windGust = windGust;
        this.relHumidity = relHumidity;
        this.precipitationProb = precipitationProb;
        this.windSpeed = windSpeed;
        this.temp = temp;
        this.uv = uv;
        this.visibility = visibility;
        this.weatherType = weatherType;
        this.weatherTypeFull = weatherTypeFull;

        this.weatherTypeSimple = weatherTypeSimple;
        this.color = color;
        this.textColor = textColor;

    }

    public int getHours() {
        return hours;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public int getTempFeelsLike() {
        return tempFeelsLike;
    }

    public int getWindGust() {
        return windGust;
    }

    public int getRelHumidity() {
        return relHumidity;
    }

    public int getPrecipitationProb() {
        return precipitationProb;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public int getTemp() {
        return temp;
    }

    public int getUv() {
        return uv;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getWeatherType() {
        return weatherTypeFull;
    }

    public void printSummary() {
        System.out.println();
        System.out.println("Time: " + this.time);
        System.out.println("Weather type: " + this.weatherTypeFull);
        System.out.println("Temperature: " + this.temp + " (" + this.tempFeelsLike + ")");
        System.out.println("Chance rain: " + this.precipitationProb);
        System.out.println("Wind speed: " + this.windSpeed + " (" + this.windGust + ")");
    }

    public String getColor() {
        return color;
    }
}
