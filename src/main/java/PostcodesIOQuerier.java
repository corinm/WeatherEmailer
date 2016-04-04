import java.io.IOException;

public class PostcodesIOQuerier {

    // http://postcodes.io/
    private String urlPostcode1 = "https://api.postcodes.io/postcodes/";
    private String urlPostcode2 = "/validate";
    private String urlLatLong = "https://api.postcodes.io/postcodes?q=";

    private HttpConnector hc;

    PostcodesIOQuerier() {

        this.hc = new HttpConnector();

    }

    public String requestPostcodeCheck(String postcode) {

        String tempUrl = urlPostcode1 + postcode + urlPostcode2;
        String response = null;

        try {
            response = hc.sendGet(tempUrl);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public String requestLatLong(String postcode) {

        String tempUrl = urlLatLong + postcode;
        String response = null;

        try {
            response = hc.sendGet(tempUrl);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

}
