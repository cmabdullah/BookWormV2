package com.ml.coreweb.controller;

import com.ml.coreweb.exception.ApiError;
import com.ml.coreweb.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * BookWormV2
 * Created on 19/8/22 - Friday
 * User Khan, C M Abdullah
 * Ref:
 */
@RestController
public class ProductController {
	@GetMapping("/product/list")
	public ApiResponse<?> getAllProducts() {
		return new ApiResponse<>(List.of("Potato", "Rice"));
	}
	
	@GetMapping("/product/error")
	public ApiResponse<?> getE() {
		throw new ApiError("throw not found " , HttpStatus.BAD_REQUEST);
//		List.of("Potato", "Rice").stream().filter(n -> n.equals("A")).findFirst()
//				.orElseThrow(ApiError.createSingletonSupplier(" not found " , HttpStatus.BAD_REQUEST));
//		return new ApiResponse<>(List.of("Potato", "Rice"));
	}
}
