package Business;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bhavna Menghrajani
 */
public class SendInvoiceinEmail {

	public void sendEmail(String toAddress) throws MessagingException {

		String host = "smtp.gmail.com";
		String Password = "password";
		String from = "email@gmail.com";
		String filename = System.getProperty("user.dir") + "\\Invoice.PDF";
		// Get system properties
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtps.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(props, null);

		MimeMessage message = new MimeMessage(session);

		message.setFrom(new InternetAddress(from));

		message.setRecipients(Message.RecipientType.TO, toAddress);

		message.setSubject("Invoice for your order");

		BodyPart messageBodyPart = new MimeBodyPart();

		messageBodyPart.setText(
				"Dear Customer, \n\n Your Invoice has been generated and attached in the email. \n\n Please ignore the email if it was not intended for you.\n \n \n Kind Regards, \n The Pharmacist");

		Multipart multipart = new MimeMultipart();

		multipart.addBodyPart(messageBodyPart);

		messageBodyPart = new MimeBodyPart();

		DataSource source = new FileDataSource(filename);

		messageBodyPart.setDataHandler(new DataHandler(source));

		messageBodyPart.setFileName(filename);

		multipart.addBodyPart(messageBodyPart);

		message.setContent(multipart);

		try {
			Transport tr = session.getTransport("smtps");
			tr.connect(host, from, Password);
			tr.sendMessage(message, message.getAllRecipients());
			System.out.println("Mail Sent Successfully");
			tr.close();

		} catch (SendFailedException sfe) {

			System.out.println(sfe);
		}

	}

}
