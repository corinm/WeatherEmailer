import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnector {

    public String sendGet(String url) throws IOException {

        URL finalURL = new URL(url);
        HttpURLConnection con = (HttpURLConnection) finalURL.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        //System.out.println("Sending request...");
        //System.out.println("Request accepted...");

        BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = br.readLine()) != null) {
            response.append(inputLine);
        }
        br.close();

        return response.toString();
    }

}
