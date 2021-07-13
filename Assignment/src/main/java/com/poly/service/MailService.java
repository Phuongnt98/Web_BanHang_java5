package com.poly.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.poly.entity.MailModel;

@Service
public class MailService {
	
	@Autowired
	JavaMailSender sender;
	
	List<MimeMessage> queue = new ArrayList<>();
	
	public void push(String to, String subject, String body) throws MessagingException {
		MailModel mail = new MailModel(to, subject, body);
		this.push(mail);
	}

	private void push(MailModel mail) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		helper.setFrom(mail.getFrom());
		helper.setTo(mail.getTo());
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getBody());
		helper.setFrom(mail.getFrom());
		helper.setReplyTo(mail.getFrom());
		for(String email: mail.getCc()) {
			helper.addCc(email);
		}
		for(String email: mail.getBcc()) {
			helper.addCc(email);
		}
		for(File file: mail.getFiles()) {
			helper.addAttachment(file.getName(), file);
		}
		queue.add(message);
	}
	
	int succes = 0, error = 0;
	@Scheduled(fixedDelay = 5000)
	public void run() {
		while(!queue.isEmpty()) {
			MimeMessage message = queue.remove(0);
			try {
				sender.send(message);
				succes++;
			} catch (Exception e) {
				error++;
			}
		}
	}
			
}
