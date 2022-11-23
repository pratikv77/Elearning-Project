package study.services;

import javax.mail.MessagingException;

public interface EmailService {
	
	public void sendMailWithAttachment(String toEmail, String body, String subject) throws MessagingException;

}
