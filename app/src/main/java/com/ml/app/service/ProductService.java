package com.ml.app.service;

import com.ml.app.domain.Product;
import com.ml.app.request.ProductRequestDto;
import com.ml.app.response.OrderResponseDto;
import com.ml.app.response.ProductResponseDto;

import java.util.List;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
public interface ProductService {
	ProductResponseDto save(ProductRequestDto productRequestDto);
	
	List<ProductResponseDto> getAllProducts();
	
	ProductResponseDto update(ProductRequestDto productRequestDto);
	
	void delete(Long id);
	
	List<Product> findAllProductByProductId(List<Long> productIdList);
	
	List<ProductResponseDto> search(String productName, String sku, String category);
}
