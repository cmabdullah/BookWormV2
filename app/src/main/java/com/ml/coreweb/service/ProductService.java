package com.ml.coreweb.service;

import com.ml.coreweb.domain.Product;
import com.ml.coreweb.request.ProductRequestDto;
import com.ml.coreweb.response.ProductResponseDto;

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
}
