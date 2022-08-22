package com.ml.app.service;

import com.ml.app.constants.ApiMessage;
import com.ml.app.domain.Categories;
import com.ml.app.domain.Product;
import com.ml.app.repository.CategoriesRepository;
import com.ml.app.request.ProductRequestDto;
import com.ml.app.response.ProductResponseDto;
import com.ml.coreweb.exception.ApiError;
import com.ml.app.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	private final CategoriesRepository categoriesRepository;
	
	@Autowired
	ProductServiceImpl(ProductRepository productRepository,
					   CategoriesRepository categoriesRepository){
		this.productRepository = productRepository;
		this.categoriesRepository = categoriesRepository;
	}
	@Override
	public ProductResponseDto save(ProductRequestDto productRequestDto) {
		
		Categories ctg = categoriesRepository.findByCategoryName(productRequestDto.getProductCategory());
		log.info("ctg"+ ctg);
		Product product = productRequestDtoToProduct(productRequestDto);
		product.setCategories(ctg);
		
		Product savedProduct = productRepository.save(product);
		
		return getProductToProductResponseDto(savedProduct);
	}
	
	
	@Override
	public List<ProductResponseDto> getAllProducts() {
		List<Product> productList = productRepository.findAll();
		return productList.stream().filter(Objects::nonNull)
					   .map(this::getProductToProductResponseDto).collect(Collectors.toList());
	}
	
	private ProductResponseDto getProductToProductResponseDto(Product savedProduct) {
		return ProductResponseDto.builder()
					   .productId(savedProduct.getId())
					   .productName(savedProduct.getProductName())
					   .productDescription(savedProduct.getProductDescription())
					   .productPrice(savedProduct.getProductPrice())
					   .productSKU(savedProduct.getProductSKU())
					   .productWeight(savedProduct.getProductWeight())
					   .productCategory(savedProduct.getCategories().getCategoryName()).build();
	}
	
	private Product productRequestDtoToProduct(ProductRequestDto productRequestDto) {
		return Product.builder()
					   .productName(productRequestDto.getProductName())
					   .productDescription(productRequestDto.getProductDescription())
					   .productPrice(productRequestDto.getProductPrice())
					   .productSKU(productRequestDto.getProductSKU())
					   .productWeight(productRequestDto.getProductWeight())
//					   .categories(ctg)
					   .build();
	}

	
	@Override
	public ProductResponseDto update(ProductRequestDto productRequestDto) {
		Product product = productRepository.findById(productRequestDto.getProductId())
								  .orElseThrow(ApiError.createSingletonSupplier(ApiMessage.PRODUCT_NOT_FOUND_ERROR, HttpStatus.NOT_FOUND));
		updateProduct(productRequestDto, product);
		return getProductToProductResponseDto(productRepository.save(product));
	}
	
	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
	
	@Override
	public List<Product> findAllProductByProductId(List<Long> productIdList) {
		
		List<Product> list = productRepository.findByIdIn(productIdList);
		return list;
	}
	
	private void updateProduct(ProductRequestDto productRequestDto, Product product) {
		if (!product.getProductName().equals(productRequestDto.getProductName())){
			product.setProductName(productRequestDto.getProductName());
		}
		
		if (!product.getProductDescription().equals(productRequestDto.getProductDescription())){
			product.setProductDescription(productRequestDto.getProductDescription());
		}
		
		if (!product.getProductPrice().equals(productRequestDto.getProductPrice())){
			product.setProductPrice(productRequestDto.getProductPrice());
		}
		
		if (!product.getProductWeight().equals(productRequestDto.getProductWeight())){
			product.setProductWeight(productRequestDto.getProductWeight());
		}
	}
}
