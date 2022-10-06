package com.example.springboot.service.email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.springboot.resource.EmailBody;





@Service
public class EmailServiceImpl implements EmailService {
	
	private final JavaMailSender sender;

	public EmailServiceImpl(JavaMailSender sender) {
	    this.sender = sender;
	}

	@Override
	public boolean sendEmail(EmailBody emailBody) {
	    //LOGGER.info("EmailBody: {}", emailBody.toString());
	    return sendEmailTool(emailBody.getContent(), emailBody.getEmail(), emailBody.getSubject());
	}
	
	private boolean sendEmailTool(String textMessage, String email, String subject) {
	    boolean send = false;
	    MimeMessage message = sender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	    try {
	        //helper.setTo(email);  //setTo para un solo receptor
	    	helper.setFrom("RAFAEL RODRIGUEZ <rafaelrfp@gmail.com>");
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email)); //setRecipients para muñtiples receptores separados por "," en un String
	        helper.setText(textMessage, true);
	        helper.setSubject(subject);
	        sender.send(message);
	        send = true;
	        //LOGGER.info("Mail sent!");
	    } catch (MessagingException e) {
	        //LOGGER.error("There has been an error sending mail", e);
	    }
	    return send;
	}
	
	
}
