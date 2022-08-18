package com.ml.coreweb.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * BookWormV2
 * Created on 19/8/22 - Friday
 * User Khan, C M Abdullah
 * Ref:
 */
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = ApiError.class)
	public static ResponseEntity<?> handleGenericNotFoundException(ApiError error) {
		
		ApiErrorResponse errorResponse = new ApiErrorResponse(error.getErrorMessage(), error.getErrors());
		
		return new ResponseEntity<>(errorResponse, error.getStatus());
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiError apiError = new ApiError("arguments.not.valid", HttpStatus.BAD_REQUEST);
		
		Map<String, String> errorMap =
				ex.getBindingResult().getFieldErrors().stream().filter(Objects::nonNull)
						.collect(
								Collectors.toMap(FieldError::getField,
										errorValue -> StringUtils.defaultIfBlank(errorValue.getDefaultMessage(), "default.message.not.set")));
		apiError.addAllErrors(errorMap);
		return apiErrorResponse(apiError);
	}
	
	private static ResponseEntity<Object> apiErrorResponse(ApiError error) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(error.getErrorMessage(), error.getErrors());
		return new ResponseEntity<>(errorResponse, error.getStatus());
	}
}
