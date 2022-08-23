package com.ml.email.service;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * BookWormV2
 * Created on 23/8/22 - Tuesday
 * User Khan, C M Abdullah
 * Ref:
 */
public interface EmailService {
	CompletableFuture<Boolean> sendEmailWithAttachment(Map<String, Object> emailRequestMap);
}
