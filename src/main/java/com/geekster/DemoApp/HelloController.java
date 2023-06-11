package com.geekster.DemoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService; // Injecting HelloService bean using @Autowired


    @GetMapping("/hello")
    public String hello() {
        // Invoke getMessage() method of HelloService bean
        String message = helloService.getMessage();

        // Send the message as an email using JavaMail
        sendEmail("aniket9766228627@gmail.com", "uchtigtocjaonato", "aabhishekgosavi11@gmail.com", "Hello from Spring Boot",
                message);

        return message;
    }

    private void sendEmail(String from, String password, String to, String subject, String body) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(from, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            System.out.println("Email sent successfully!!!!!!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
