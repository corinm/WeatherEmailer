import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class Emailer {

    private final String username;
    private final String password;
    private final String toEmail;
    private final String fromEmail;
    private final String fromName;
    private final String subject;
    private final String messageHtml;

    private Properties props;
    private Session session;

    public Emailer(String username, String password, String toEmail, String fromEmail, String fromName, String subject,
                   String messageHtml) {
        this.username = username;
        this.password = password;
        this.toEmail = toEmail;
        this.fromEmail = fromEmail;
        this.fromName = fromName;
        this.subject = subject;
        this.messageHtml = messageHtml;

        createProps();
        startSession(props);
    }

    public void sendEmail() {

        System.out.println();
        System.out.println(">> SENDING EMAIL");

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail, fromName));
            message.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(this.toEmail));
            message.setSubject(this.subject);
            message.setContent(this.messageHtml, "text/html; charset=utf-8");

            Transport.send(message);

            System.out.println("Email sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private void createProps() {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // SMTP server address and port
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        this.props = props;

    }

    private void startSession(Properties props) {

        this.session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        // Authenticates gmail account
                        return new PasswordAuthentication(username, password);
                    }

                });

    }
}
