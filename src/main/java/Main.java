import java.util.ArrayList;

public class Main {

    // Username and password stored environment variables in Heroku
    private static String sendGridUsername = System.getenv("SENDGRID_USERNAME");
    private static String sendGridPassword = System.getenv("SENDGRID_PASSWORD");
    private static String fromEmail = sendGridUsername;
    private static String fromName = "Weather App";
    private static String subject;

    public static long timeStart;

    public static void main(String[] args) {
	// write your code here

        timeStart = System.currentTimeMillis();

        // TODO: Move contacts to database
        ArrayList<Contact> contacts = new ArrayList<>();

        // Create each contact - this allows multiple postcodes per person
        contacts.add(new Contact("example@email.com","AA112BB"));

        for (Contact contact:contacts) {
            emailWeatherReport(contact.getEmailAddress(),contact.getPostcode());
        }

        printTimeDelta(timeStart);
        System.exit(0);

    }

    private static void emailWeatherReport(String email, String postcode) {

        System.out.print("Sending email to " + email + " for " + postcode);

        Location home = new Location(postcode);

        MetQuerier mq = new MetQuerier();
        String json = mq.requestWeatherData(home);

        JSONProcessor jp = new JSONProcessor();
        ForecastAll forecasts = jp.parseForecasts(json);
        home.setLocation(jp.parseLocation(json));

        HTMLGenerator g = new HTMLGenerator(forecasts);
        g.generateHtml();
        String html = g.getRawHtml();

        subject = forecasts.getSubject(postcode);

        EmailerSendGrid e = new EmailerSendGrid(sendGridUsername, sendGridPassword, email, fromEmail, fromName,
                subject, html);
        e.sendEmail();

    }

    private static void printTimeDelta(long timeBefore) {

        long timeNow = System.currentTimeMillis();
        System.out.println("Took: " + (double) ((timeNow - timeBefore) / 1000) + " seconds");

    }
}
