package com.ml.app.response;

import lombok.Builder;
import lombok.Data;

/**
 * BookWormV2
 * Created on 21/8/22 - Sunday
 * User Khan, C M Abdullah
 * Ref:
 */
@Builder
@Data
public class ProductResponseDto {
	private Long productId;
	private String productName;
	private String productSKU;
	private String productDescription;
	
	private Double productPrice;
	private Double productWeight;
//	//can have only 4
//	private int productQuantity;
	
	// category
	// it will be replaced by Enum
	private String productCategory;
}
