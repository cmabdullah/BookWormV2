package com.ml.coreweb.request;

import com.ml.coreweb.constants.ApiMessage;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * BookWormV2
 * Created on 21/8/22 - Sunday
 * User Khan, C M Abdullah
 * Ref:
 */
@Data
public class ProductRequestDto {
	private Long productId;
	@NotBlank(message = ApiMessage.PRODUCT_NAME_ERROR)
	private String productName;
	@NotBlank(message = ApiMessage.PRODUCT_SKU_ERROR)
	private String productSKU;
	private String productDescription;
	
	@Min(value = 0, message = ApiMessage.MINIMUM_PRICE_REQUIRED)
	private Double productPrice;
	private Double productWeight;
	
//	//can have only 4
//	private int productQuantity;
	
	// category
	// it will be replaced by Enum
	@NotBlank(message = ApiMessage.PRODUCT_CATEGORY_ERROR)
	private String productCategory;
}
