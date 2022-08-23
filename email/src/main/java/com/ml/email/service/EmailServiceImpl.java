package com.ml.email.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * BookWormV2
 * Created on 23/8/22 - Tuesday
 * User Khan, C M Abdullah
 * Ref:
 */
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	public EmailServiceImpl(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public CompletableFuture<Boolean> sendEmailWithAttachment(Map<String, Object> emailRequestMap) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				MimeMessage msg = mailSender.createMimeMessage();
				// true = multipart message
				MimeMessageHelper helper = new MimeMessageHelper(msg, true);
				helper.setTo(String.valueOf(emailRequestMap.get("to")));
				helper.setSubject(String.valueOf(emailRequestMap.get("subject")));
				emailRequestMap.entrySet().stream().filter(Objects::nonNull)
						.filter(text -> (!text.getKey().equals("to") || !text.getKey().equals("subject")))
						.forEach(body -> {
							try {
								helper.setText(String.valueOf(body.getValue()));
							} catch (MessagingException ignored) {
								log.error("message parsing failed "+ignored.getLocalizedMessage());
								
							}
						});
				
				mailSender.send(msg);
			} catch (MessagingException e) {
				log.error("Mime Message Helper initialization failed or message send failed "+e.getLocalizedMessage());
				return false;
			}
			return true;
		});
	}
}