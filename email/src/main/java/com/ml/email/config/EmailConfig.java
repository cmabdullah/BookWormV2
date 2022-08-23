package com.ml.email.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * BookWormV2
 * Created on 23/8/22 - Tuesday
 * User Khan, C M Abdullah
 * Ref:
 */
@Configuration
public class EmailConfig {
	
	@Autowired
	private final JavaMailSender mailSender;
	
	@Autowired
	public EmailConfig(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
}
