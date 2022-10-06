package com.example.springboot.service.email;

import com.example.springboot.resource.EmailBody;

public interface EmailService {

	boolean sendEmail(EmailBody emailBody);
}
