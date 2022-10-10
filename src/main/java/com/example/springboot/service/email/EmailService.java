package com.example.springboot.service.email;

import javax.mail.MessagingException;

import com.example.springboot.resource.EmailBody;

public interface EmailService {

	boolean sendEmail(EmailBody emailBody, String rutaAdjunto, String nombreArchivo) throws MessagingException;
}
