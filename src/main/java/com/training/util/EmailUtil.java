package com.training.util;

import java.io.IOException;
import java.util.Properties;

public class EmailUtil {

	public static void sendMail() {
		/*
		 * System.out.println("Started"); String recipient = "hepi.inexture@gmail.com";
		 * String sender = "hepi.inexture@gmail.com"; String host = "localhost";
		 * Properties properties = System.getProperties();
		 * properties.setProperty("mail.smtp.host", host); Session session =
		 * Session.getDefaultInstance(properties); MimeMessage message = new
		 * MimeMessage(session); try { message.setFrom(new InternetAddress(sender));
		 * message.addRecipient(Message.RecipientType.TO, new
		 * InternetAddress(recipient)); message.setSubject("This is Suject");
		 * message.setText("This is a test mail"); Transport.send(message);
		 * 
		 * Transport transport = session.getTransport("smtp");
		 * transport.connect(host,"hepi","123"); transport.send(message);
		 * transport.close();
		 * 
		 * System.out.println("Mail successfully sent"); } catch (MessagingException e)
		 * { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }
		 */
	}

	public static void sendEmail2() {
		/*
		 * final String username = "hepi.inexture@gmail.com"; final String password =
		 * "Hepi@2k21@"; String fromEmail = "hepi.inexture@gmail.com"; String toEmail =
		 * "hepi.inexture@gmail.com";
		 * 
		 * Properties properties = new Properties(); properties.put("mail.smtp.auth",
		 * "true"); properties.put("mail.smtp.starttls.enable", "true");
		 * properties.put("mail.smtp.host", "mail.smtp.com");
		 * properties.put("mail.smtp.port", "587");
		 * properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		 * 
		 * Session session = Session.getInstance(properties, new
		 * javax.mail.Authenticator() { protected PasswordAuthentication
		 * getPasswordAuthentication() { return new PasswordAuthentication(username,
		 * password); } }); // Start our mail message MimeMessage msg = new
		 * MimeMessage(session); try { msg.setFrom(new InternetAddress(fromEmail));
		 * msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
		 * msg.setSubject("Subject Line");
		 * 
		 * Multipart emailContent = new MimeMultipart();
		 * 
		 * // Text body part MimeBodyPart textBodyPart = new MimeBodyPart();
		 * textBodyPart.setText("My multipart text");
		 * 
		 * // Attachment body part. // MimeBodyPart pdfAttachment = new MimeBodyPart();
		 * // pdfAttachment.attachFile("/home/parallels/Documents/docs/javamail.pdf");
		 * 
		 * // Attach body parts emailContent.addBodyPart(textBodyPart); //
		 * emailContent.addBodyPart(pdfAttachment);
		 * 
		 * // Attach multipart to message msg.setContent(emailContent);
		 * 
		 * Transport.send(msg); System.out.println("Sent message"); } catch
		 * (MessagingException e) { e.printStackTrace(); }
		 */
	}
}
