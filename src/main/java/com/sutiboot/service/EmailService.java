/**
 * 
 */
package com.sutiboot.service;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sutiboot.domain.Mail;

/**
 * @className:com.sutiboot.service.EmailService.java
 * @author <a href="mailto:balramc@****.**">Balram</a>
 * @date May 22, 2019 1:38:53 PM
 * @description:
 */

@Service
public class EmailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * @param mail
	 */
	public void sendMail(Mail mail) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(mail.getTo());
		mailMessage.setSubject(mail.getSubject());
		mailMessage.setText(mail.getText());
		javaMailSender.send(mailMessage);
	}

	/**
	 * @param mail
	 * @param attachFiles
	 */
	public void sendMail(Mail mail, final MultipartFile[] attachFiles) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(mail.getTo());
			helper.setSubject(mail.getSubject());
			helper.setText("<html><body>" + mail.getText() + "</html></body>", true);
			for (MultipartFile file : attachFiles) {
				helper.addAttachment(file.getOriginalFilename(), file);	
			}
			javaMailSender.send(mimeMessage);
		} catch (MailException | IllegalStateException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
	}

	/**
	 * @param multipart
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
		File convFile = new File(multipart.getOriginalFilename());
		multipart.transferTo(convFile);
		return convFile;
	}
}
