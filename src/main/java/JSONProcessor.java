import org.apache.commons.lang3.text.WordUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.LinkedList;

public class JSONProcessor {

    private WeatherConverter wc;

    JSONProcessor() {

        this.wc = new WeatherConverter();

    }

    public boolean parseValidPostcodeJSON(String jsonString) {

        JSONObject obj = new JSONObject(jsonString);

        return obj.getBoolean("result");
    }

    public HashMap<String, Double> parseLatPostcodeJSON(String jsonString) {

        HashMap<String, Double> latLong = new HashMap<>();

        JSONObject obj = new JSONObject(jsonString);
        JSONObject result = obj.getJSONArray("result").getJSONObject(0);

        double latitude = result.getDouble("latitude");
        double longitude = result.getDouble("longitude");

        latLong.put("latitude", latitude);
        latLong.put("longitude", longitude);

        return latLong;
    }

    public MetLocations parseMetLocations(String jsonString) {

        LinkedList<double[]> metLocations = new LinkedList<>();
        LinkedList<Integer> metIds = new LinkedList<>();

        // JSON
        JSONObject obj = new JSONObject(jsonString);

        JSONArray loc = obj.getJSONObject("Locations").getJSONArray("Location");

        for (int i = 0; i < loc.length(); i++) {
            JSONObject tempObj = loc.getJSONObject(i);

            double tempLat = Double.parseDouble(tempObj.getString("latitude"));
            double tempLong = Double.parseDouble(tempObj.getString("longitude"));
            int tempId = Integer.parseInt(tempObj.getString("id"));

            double[] tempDoubleArray = new double[2];
            tempDoubleArray[0] = tempLat;
            tempDoubleArray[1] = tempLong;

            metLocations.add(tempDoubleArray);
            metIds.add(tempId);
        }

        return new MetLocations(metLocations, metIds);
    }

    public ForecastAll parseForecasts(String jsonString) {

        // 1st LinkedList, to contain LinkedLists of Forecast objects
        LinkedList<ForecastDay> forecasts = new LinkedList<>();

        JSONObject obj = new JSONObject(jsonString);
        JSONArray days = obj.getJSONObject("SiteRep").getJSONObject("DV").getJSONObject("Location").getJSONArray("Period");

        String location = obj.getJSONObject("SiteRep").getJSONObject("DV").getJSONObject("Location").getString("name");
        int metId = obj.getJSONObject("SiteRep").getJSONObject("DV").getJSONObject("Location").getInt("i");

        for (int i = 0; i < days.length(); i++) {
            // Repeat once per day

            JSONObject hours1 = (JSONObject) days.get(i);
            JSONArray hours2 = hours1.getJSONArray("Rep");

            String date = hours1.getString("value");

            // 2nd set of LinkedLists (ones inside the first), to contain forecast objects
            LinkedList<Forecast3Hr> tempList = new LinkedList<>();

            for (int j = 0; j < hours2.length(); j++) {
                // Repeat once per hour

                JSONObject hour = (JSONObject) hours2.get(j);

                int hours = hour.getInt("$") / 60;

                String time = null;
                try {
                    time = wc.convertTime(hours);
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                }

                String windDirection = hour.getString("D");
                int tempFeelsLike = hour.getInt("F");
                int windGust = hour.getInt("G");
                int relHumidity = hour.getInt("H");
                int precipitationProb = hour.getInt("Pp");
                int windSpeed = hour.getInt("S");
                int temp = hour.getInt("T");
                int uv = hour.getInt("U");
                String visibility = hour.getString("V");
                int weatherType = wc.convertWeatherTypeToInt(hour.getString("W"));
                String weatherTypeFull = wc.convertWeatherType(weatherType);

                int weatherTypeSimple = wc.convertWeatherTypeToSimple(weatherType, temp);
                String color = wc.convertWeatherToColor(weatherTypeSimple);
                String textColor;

                if (color == Colors.CLEAR_NIGHT) {
                    textColor = "#FFF";
                } else {
                    textColor = "#000";
                }

                Forecast3Hr tempForecast3Hr = new Forecast3Hr(hours, time, windDirection, tempFeelsLike, windGust,
                        relHumidity, precipitationProb, windSpeed, temp, uv, visibility, weatherType, weatherTypeFull,
                        weatherTypeSimple, color, textColor);

                tempList.add(tempForecast3Hr);
            }

            ForecastDay tempForecastDay = new ForecastDay(tempList, date);
            forecasts.add(tempForecastDay);

        }

        ForecastAll forecastsAll = new ForecastAll(forecasts, location, metId);

        return forecastsAll;
    }

    public String parseLocation(String jsonString) {

        JSONObject obj = new JSONObject(jsonString);
        return obj.getJSONObject("SiteRep").getJSONObject("DV").getJSONObject("Location").getString("name");
    }

    public String parseSendGridResponse(String jsonString) {

        JSONObject obj = new JSONObject(jsonString);
        return obj.getString("message");

    }

}
