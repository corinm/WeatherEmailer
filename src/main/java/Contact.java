public class Contact {

    private String emailAddress;
    private String postcode;

    Contact(String emailAddress, String postcode) {

        this.emailAddress = emailAddress;
        this.postcode = postcode;

    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPostcode() {
        return postcode;
    }
}
