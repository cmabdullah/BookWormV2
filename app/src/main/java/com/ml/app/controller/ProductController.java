package com.ml.app.controller;

import com.ml.app.constants.ApiMessage;
import com.ml.app.request.ProductRequestDto;
import com.ml.coreweb.response.ApiResponse;
import com.ml.app.response.ProductResponseDto;
import com.ml.app.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
@RequestMapping("/auth/api/")
public class ProductController {
	
	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@ApiOperation(value = "[TEST] save data to product table -> Done")
	@PostMapping("/product/add")
	public ApiResponse<?> addProducts(Authentication authentication, @Valid @RequestBody ProductRequestDto productRequestDto) {
		return new ApiResponse<>(productService.save(productRequestDto));
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@ApiOperation(value = "[TEST] update data to product table -> Done")
	@PostMapping("/product/update")
	public ApiResponse<?> updateProducts(@Valid @RequestBody ProductRequestDto productRequestDto) {
		return new ApiResponse<>(productService.update(productRequestDto));
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@ApiOperation(value = "[TEST] get all data from product table -> Done")
	@GetMapping("/product/list")
	public ApiResponse<?> getAllProducts() {
		List<ProductResponseDto> productResponseDto = productService.getAllProducts();
		return new ApiResponse<>(productResponseDto);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@ApiOperation(value = "[TEST] delete data from product table -> Done")
	@DeleteMapping("/product/delete/{id}")
	public ApiResponse<?> deleteProduct(@PathVariable(value = "id") Long id) {
		productService.delete(id);
		return new ApiResponse<>(ApiMessage.SUCCESS);
	}
	
	//todo search api
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@ApiOperation(value = "[TEST] search product based on name, sku and category -> Todo")
	@GetMapping("/product/search/{id}")
	public ApiResponse<?> search(@PathVariable(value = "id") Long id) {
//		Users can search products by name, sku and category.
		return new ApiResponse<>(ApiMessage.SUCCESS);
	}
}
