package study.services;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMailWithAttachment(String toEmail, String body, String subject) throws MessagingException
	{
		
		
		
		MimeMessage mimemessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimemessageHelper = new MimeMessageHelper(mimemessage,true);
		mimemessageHelper.setFrom("elearningiet6@gmail.com");
		mimemessageHelper.setTo(toEmail);
		mimemessageHelper.setText(body);
		mimemessageHelper.setSubject(subject);

		javaMailSender.send(mimemessage);
		
		System.out.println("Mail with attachment sent sucessfully");
	}


}
