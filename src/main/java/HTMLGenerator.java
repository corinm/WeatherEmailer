import java.util.Calendar;
import java.util.GregorianCalendar;

public class HTMLGenerator {

    private String rawHtml;
    private ForecastAll forecasts;
    private StringBuilder sb;
    private Calendar calendarReal;
    private Calendar calendarTemp;

    HTMLGenerator(ForecastAll forecasts) {

        this.forecasts = forecasts;
        sb = new StringBuilder();
        calendarReal = new GregorianCalendar();
        calendarTemp = new GregorianCalendar();

    }

    public void generateHtml() {

        generateHtml_Part1();
        generateHtml_Part2();
        generateHtml_Part3();
        generateHtml_Part4(0);
        generateHtml_Part5();
        generateHtml_Part6();
        generateHtml_Part7();
        generateHtml_Part4(1);
        generateHtml_Part9();

        rawHtml = sb.toString();
    }

    private void generateHtml_Part1() {
        sb.append(Html.htmlHeader);
        sb.append(Html.dayStart);
    }

    private void generateHtml_Part2() {
        String title = Html.day1Title;

        String day = forecasts.getForecasts().get(0).getWeekday();
        title = title.replace("$Day", day);

        sb.append(title);
    }

    private void generateHtml_Part3() {
        sb.append(Html.dayTableHeaders);
    }

    private void generateHtml_Part4(int i) {

        // For each Forecast3Hr in 1st ForecastDay in forecasts...
        for (Forecast3Hr f : forecasts.getForecasts().get(i).getForecasts()) {

            int forecastHour = f.getHours();
            int currentHour = getCurrentHour();

            if (!(forecastHour <= currentHour - 3 && i == 0)) {

                String tempHtml = Html.hourForecast;

                tempHtml = tempHtml.replace("$Color", f.getColor());
                tempHtml = tempHtml.replace("$TextColor", f.getTextColor());
                tempHtml = tempHtml.replace("$Time", f.getTime());
                tempHtml = tempHtml.replace("$WeatherType", f.getWeatherTypeFull());
                tempHtml = tempHtml.replace("$Temp", String.valueOf(f.getTemp()));
                tempHtml = tempHtml.replace("$FeelsLike", String.valueOf(f.getTempFeelsLike()));
                tempHtml = tempHtml.replace("$Rain", String.valueOf(f.getPrecipitationProb()));
                tempHtml = tempHtml.replace("$Wind", String.valueOf(f.getWindSpeed()));
                tempHtml = tempHtml.replace("$Gusts", String.valueOf(f.getWindGust()));

                sb.append(tempHtml);
            }

        }
    }

    private void generateHtml_Part5() {
        sb.append(Html.day1End);

        sb.append(Html.dayStart);
    }

    private void generateHtml_Part6() {
        String title = Html.day2Title;

        String day = forecasts.getForecasts().get(1).getWeekday();
        title = title.replace("$Day", day);

        sb.append(title);
    }

    private void generateHtml_Part7() {
        sb.append(Html.dayTableHeaders);
    }

    private void generateHtml_Part9() {
        sb.append(Html.day2End);
    }

    public String getRawHtml() {
        return rawHtml;
    }

    private int getCurrentHour() {

        int hours;

        calendarTemp.set(calendarReal.get(Calendar.YEAR), calendarReal.get(Calendar.MONTH), calendarReal.get(Calendar.DATE), 0, 0);

        int currentHour = calendarReal.get(Calendar.HOUR_OF_DAY);
        int midnightHour = calendarTemp.get(Calendar.HOUR_OF_DAY);

        hours = currentHour - midnightHour;
        return hours;
    }

}
