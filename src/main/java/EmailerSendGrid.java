import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

public class EmailerSendGrid {

    private String username;
    private String password;
    private String toEmail;
    private String fromEmail;
    private String fromName;
    private String subject;
    private String messageHtml;
    private JSONProcessor jp;

    EmailerSendGrid(String username, String password, String toEmail, String fromEmail, String fromName,
                    String subject, String messageHtml) {

        jp = new JSONProcessor();
        this.username = username;
        this.password = password;
        this.toEmail = toEmail;
        this.fromEmail = fromEmail;
        this.fromName = fromName;
        this.subject = subject;
        this.messageHtml = messageHtml;

    }

    public void sendEmail() {

        //System.out.println();
        //System.out.println(">> SENDING EMAIL");

        SendGrid sg = new SendGrid(username, password);

        SendGrid.Email email = new SendGrid.Email();
        email.addTo(toEmail);
        email.setFrom(fromEmail);
        email.setFromName(fromName);
        email.setSubject(subject);
        email.setHtml(messageHtml);

        try {
            SendGrid.Response response = sg.send(email);
            //System.out.println("Email sent");
            System.out.println(" - " + jp.parseSendGridResponse(response.getMessage()));
        }
        catch (SendGridException e) {
            System.err.println(e);
        }
    }

}
