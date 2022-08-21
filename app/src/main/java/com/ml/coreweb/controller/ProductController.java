package com.ml.coreweb.controller;

import com.ml.coreweb.constants.ApiMessage;
import com.ml.coreweb.request.ProductRequestDto;
import com.ml.coreweb.response.ApiResponse;
import com.ml.coreweb.response.ProductResponseDto;
import com.ml.coreweb.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * BookWormV2
 * Created on 19/8/22 - Friday
 * User Khan, C M Abdullah
 * Ref:
 */
@Slf4j
@RestController
public class ProductController {
	
	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@PostMapping("/product/add")
	public ApiResponse<?> addProducts(@Valid @RequestBody ProductRequestDto productRequestDto) {
		return new ApiResponse<>(productService.save(productRequestDto));
	}
	
	@PostMapping("/product/update")
	public ApiResponse<?> updateProducts(@Valid @RequestBody ProductRequestDto productRequestDto) {
		return new ApiResponse<>(productService.update(productRequestDto));
	}
	
	@GetMapping("/product/list")
	public ApiResponse<?> getAllProducts() {
		List<ProductResponseDto> productResponseDto = productService.getAllProducts();
		return new ApiResponse<>(productResponseDto);
	}
	
	@DeleteMapping("/product/delete/{id}")
	public ApiResponse<?> deleteProduct(@PathVariable(value = "id") Long id) {
		productService.delete(id);
		return new ApiResponse<>(ApiMessage.SUCCESS);
	}
	
	//todo search api
	
	@DeleteMapping("/product/search/{id}")
	public ApiResponse<?> search(@PathVariable(value = "id") Long id) {
//		Users can search products by name, sku and category.
		return new ApiResponse<>(ApiMessage.SUCCESS);
	}
}
