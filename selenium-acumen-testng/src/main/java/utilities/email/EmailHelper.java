package utilities.email;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import selenium.execution.ExecutionHelper;
import utilities.common.Common;
import utilities.common.ReadWritePropertiesFile;

import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import javax.activation.*;

public class EmailHelper {
	final static Logger logger = Logger.getLogger(EmailHelper.class);
	String user;
	String password;

	public void sendMail() {

		ArrayList<String> arr = ReadWritePropertiesFile.getMailProperties();
		String toList = arr.get(1);
		String ccList = arr.get(11);
		String[] to = Common.stringSepratedByComma(toList);
		String[] cc = Common.stringSepratedByComma(ccList);
		user = arr.get(2);
		String username = arr.get(3);
		password = arr.get(4);
		String subject = arr.get(5);
		String filename = arr.get(8);
		String filePath = ".//" + ExecutionHelper.testoutput + "//" + ExecutionHelper.reportName;
		String host = arr.get(10);
		String endTime = Common.getCurrentDateTime("yyyy-MM-dd HH:mm:ss");

		String currentDate = Common.getCurrentDate();
		String current = ReadWritePropertiesFile.getIISProperty();
		subject += " " + currentDate;

		String msg = "Hi Team, \n\n***This is an automated logging report***\n\nPlease check the portal to resolve attached concern: \n\nStart Date: "
				+ ExecutionHelper.startTime + "\nEnd Date: " + endTime + "\nEnvironment Details: "
				+ ExecutionHelper.envn + "\nReport Link: " + current + "/" + ExecutionHelper.testoutput + "/"
				+ ExecutionHelper.reportName + "\n\nThanks,\nAutomation Global DevOps Team";

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress(user, username));
			} catch (UnsupportedEncodingException e) {
				logger.info("Issue in username settings", e);
			}
			InternetAddress[] mailAddressTo = new InternetAddress[to.length];
			for (int i = 0; i < mailAddressTo.length; i++)
				mailAddressTo[i] = new InternetAddress(to[i]);

			InternetAddress[] mailAddressCC = new InternetAddress[cc.length];
			for (int i = 0; i < mailAddressCC.length; i++)
				mailAddressCC[i] = new InternetAddress(cc[i]);
			message.addRecipients(Message.RecipientType.TO, mailAddressTo);
			message.addRecipients(Message.RecipientType.CC, mailAddressCC);
			message.addRecipients(Message.RecipientType.BCC, "Test@yahoo.com");
			message.setSubject(subject);
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText(msg);
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			DataSource source = new FileDataSource(filePath);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);
			message.setContent(multipart);
			Transport.send(message);
		} catch (MessagingException e) {
			logger.info("Mail did not send to management ", e);

		}

	}
}
