import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class ForecastDay {

    private String date;
    private String weekday;

    public String getWeekday() {
        return weekday;
    }

    private LinkedList<Forecast3Hr> forecasts;

    ForecastDay(LinkedList<Forecast3Hr> forecasts, String date) {

        this.date = date;
        this.weekday = calculateWeekday(date);
        this.forecasts = forecasts;

    }

    private String calculateWeekday(String dateString) {
        String weekday;

        Calendar thisDate = convertToCalendar(dateString);
        int thisWeekday = thisDate.get(Calendar.DAY_OF_WEEK);

        switch(thisWeekday) {
            case 2:
                weekday = "Monday";
                break;
            case 3:
                weekday = "Tuesday";
                break;
            case 4:
                weekday = "Wednesday";
                break;
            case 5:
                weekday = "Thursday";
                break;
            case 6:
                weekday = "Friday";
                break;
            case 7:
                weekday = "Saturday";
                break;
            case 1:
                weekday = "Sunday";
                break;
            default:
                throw new InvalidParameterException("Unknown weekday");
            }

        return weekday;
    }

    private Calendar convertToCalendar(String dateString) {

        int dateYear = Integer.parseInt(date.substring(0, 4));
        int dateMonth = Integer.parseInt(date.substring(5, 7)) - 1;
        int dateDay = Integer.parseInt(date.substring(8, 10));

        Calendar calendar = new GregorianCalendar();
        calendar.set(dateYear,dateMonth,dateDay);

        return calendar;
    }

    public String getDate() {
        return date;
    }

    public LinkedList<Forecast3Hr> getForecasts() {

        return forecasts;
    }
}
