import java.security.InvalidKeyException;
import java.util.HashMap;

public class WeatherConverter {

    private HashMap<Integer,String> weatherTypes;
    private HashMap<Integer, String> times;
    private HashMap<Integer, String> weatherColors;

    WeatherConverter() {

        initTimes();
        initWeatherTypes2();
        initWeatherColors();

    }

    private void initTimes() {
        times = new HashMap<>();
        times.put( 0,"Midnight");
        times.put( 3,"3am");
        times.put( 6,"6am");
        times.put( 9,"9am");
        times.put(12,"Noon");
        times.put(15,"3pm");
        times.put(18,"6pm");
        times.put(21,"9pm");
    }

    private void initWeatherTypes1() {
        weatherTypes = new HashMap<>();
        weatherTypes.put(0,"Clear night");
        weatherTypes.put(1,"Sunny day");
        weatherTypes.put(2,"Partly cloudy (night)");
        weatherTypes.put(3,"Partly cloudy (day)");
        weatherTypes.put(4,"Not used");
        weatherTypes.put(5,"Mist");
        weatherTypes.put(6,"Fog");
        weatherTypes.put(7,"Cloudy");
        weatherTypes.put(8,"Overcast");
        weatherTypes.put(9,"Light rain shower (night)");
        weatherTypes.put(10,"Light rain shower (day)");
        weatherTypes.put(11,"Drizzle");
        weatherTypes.put(12,"Light rain");
        weatherTypes.put(13,"Heavy rain shower (night)");
        weatherTypes.put(14,"Heavy rain shower (day)");
        weatherTypes.put(15,"Heavy rain");
        weatherTypes.put(16,"Sleet shower (night)");
        weatherTypes.put(17,"Sleet shower (day)");
        weatherTypes.put(18,"Sleet");
        weatherTypes.put(19,"Hail shower (night)");
        weatherTypes.put(20,"Hail shower (day)");
        weatherTypes.put(21,"Hail");
        weatherTypes.put(22,"Light snow shower (night)");
        weatherTypes.put(23,"Light snow shower (day)");
        weatherTypes.put(24,"Light snow");
        weatherTypes.put(25,"Heavy snow shower (night)");
        weatherTypes.put(26,"Heavy snow shower (day)");
        weatherTypes.put(27,"Heavy snow");
        weatherTypes.put(28,"Thunder shower (night)");
        weatherTypes.put(29,"Thunder shower (day)");
        weatherTypes.put(30,"Thunder");
        weatherTypes.put(99,"Unknown");
    }

    private void initWeatherTypes2() {
        weatherTypes = new HashMap<>();
        weatherTypes.put(0,"Clear");
        weatherTypes.put(1,"Sunny");
        weatherTypes.put(2,"Partly cloudy");
        weatherTypes.put(3,"Partly cloudy");
        weatherTypes.put(4,"Not used");
        weatherTypes.put(5,"Mist");
        weatherTypes.put(6,"Fog");
        weatherTypes.put(7,"Cloudy");
        weatherTypes.put(8,"Overcast");
        weatherTypes.put(9,"Light shower");
        weatherTypes.put(10,"Light shower");
        weatherTypes.put(11,"Drizzle");
        weatherTypes.put(12,"Light rain");
        weatherTypes.put(13,"Heavy shower");
        weatherTypes.put(14,"Heavy shower");
        weatherTypes.put(15,"Heavy rain");
        weatherTypes.put(16,"Sleet shower");
        weatherTypes.put(17,"Sleet shower");
        weatherTypes.put(18,"Sleet");
        weatherTypes.put(19,"Hail shower");
        weatherTypes.put(20,"Hail shower");
        weatherTypes.put(21,"Hail");
        weatherTypes.put(22,"Light snow shower");
        weatherTypes.put(23,"Light snow shower");
        weatherTypes.put(24,"Light snow");
        weatherTypes.put(25,"Heavy snow shower");
        weatherTypes.put(26,"Heavy snow shower");
        weatherTypes.put(27,"Heavy snow");
        weatherTypes.put(28,"Thunder shower");
        weatherTypes.put(29,"Thunder shower");
        weatherTypes.put(30,"Thunder");
        weatherTypes.put(99,"Unknown");
    }

    private void initWeatherColors() {
        weatherColors = new HashMap<>();
        weatherColors.put(WeatherSimple.SUNNY_HOT, Colors.SUNNY_HOT);
        weatherColors.put(WeatherSimple.SUNNY_COLD, Colors.SUNNY_COLD);
        weatherColors.put(WeatherSimple.CLOUDY, Colors.CLOUDY);
        weatherColors.put(WeatherSimple.RAIN_LIGHT, Colors.RAIN_LIGHT);
        weatherColors.put(WeatherSimple.RAIN_HEAVY, Colors.RAIN_HEAVY);
        weatherColors.put(WeatherSimple.SNOW, Colors.SNOW);
        weatherColors.put(WeatherSimple.STORM, Colors.STORM);
        weatherColors.put(WeatherSimple.CLEAR_NIGHT, Colors.CLEAR_NIGHT);

    }

    public String convertWeatherType(int code) {

        String result;

        if (weatherTypes.containsKey(code)) {
            result = weatherTypes.get(code);
        } else {
            result = "Unknown";
            System.out.println("Weather code not found");
        }

        return result;
    }

    public int convertWeatherTypeToInt(String codeStr) {

        int code;

        try {
            code = Integer.parseInt(codeStr);

        } catch (NumberFormatException e) {
            code = 99;
        }
        return code;
    }

    public String convertTime(int hours) throws InvalidKeyException {

        String result;

        if (times.containsKey(hours)) {
            result = times.get(hours);
        } else {
            throw new InvalidKeyException("Hours searched for not present");
        }

        return result;
    }

    public int convertWeatherTypeToSimple(int weatherType, int temp) {

        int simple;

        // TODO: Add code
        switch (weatherType) {
            case 0:
                if (temp >= 18) {
                    simple = WeatherSimple.SUNNY_HOT;
                } else {
                    simple = WeatherSimple.SUNNY_COLD;
                }
                break;
            case 1:
                if (temp >= 18) {
                    simple = WeatherSimple.SUNNY_HOT;
                } else {
                    simple = WeatherSimple.SUNNY_COLD;
                }
                break;
            case 2:
                if (temp >= 18) {
                    simple = WeatherSimple.SUNNY_HOT;
                } else {
                    simple = WeatherSimple.SUNNY_COLD;
                }
                break;
            case 3:
                if (temp >= 18) {
                    simple = WeatherSimple.SUNNY_HOT;
                } else {
                    simple = WeatherSimple.SUNNY_COLD;
                }
                break;
            case 5:
                simple = WeatherSimple.CLOUDY;
                break;
            case 6:
                simple = WeatherSimple.CLOUDY;
                break;
            case 7:
                simple = WeatherSimple.CLOUDY;
                break;
            case 8:
                simple = WeatherSimple.CLOUDY;
                break;
            case 9:
                simple = WeatherSimple.RAIN_LIGHT;
                break;
            case 10:
                simple = WeatherSimple.RAIN_LIGHT;
                break;
            case 11:
                simple = WeatherSimple.RAIN_LIGHT;
                break;
            case 12:
                simple = WeatherSimple.RAIN_LIGHT;
                break;
            case 13:
                simple = WeatherSimple.RAIN_HEAVY;
                break;
            case 14:
                simple = WeatherSimple.RAIN_HEAVY;
                break;
            case 15:
                simple = WeatherSimple.RAIN_HEAVY;
                break;
            case 16:
                simple = WeatherSimple.SNOW;
                break;
            case 17:
                simple = WeatherSimple.SNOW;
                break;
            case 18:
                simple = WeatherSimple.SNOW;
                break;
            case 19:
                simple = WeatherSimple.SNOW;
                break;
            case 20:
                simple = WeatherSimple.SNOW;
                break;
            case 21:
                simple = WeatherSimple.SNOW;
                break;
            case 22:
                simple = WeatherSimple.SNOW;
                break;
            case 23:
                simple = WeatherSimple.SNOW;
                break;
            case 24:
                simple = WeatherSimple.SNOW;
                break;
            case 25:
                simple = WeatherSimple.SNOW;
                break;
            case 26:
                simple = WeatherSimple.SNOW;
                break;
            case 27:
                simple = WeatherSimple.SNOW;
                break;
            case 28:
                simple = WeatherSimple.STORM;
                break;
            case 29:
                simple = WeatherSimple.STORM;
                break;
            case 30:
                simple = WeatherSimple.STORM;
                break;
            default:
                simple = 0;

        }

        return simple;
    }

    public String convertWeatherToColor(int weatherTypeSimple) {

        String color = "#FFFFFF";

        if (weatherColors.containsKey(weatherTypeSimple)) {
            color = weatherColors.get(weatherTypeSimple);
        }

        return color;
    }

}
