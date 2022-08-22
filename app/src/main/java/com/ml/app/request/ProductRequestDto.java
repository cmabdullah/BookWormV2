package com.ml.app.request;

import com.ml.app.constants.ApiMessage;
import lombok.Data;

import javax.validation.constraints.Max;
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
	private long productId;
	@NotBlank(message = ApiMessage.PRODUCT_NAME_ERROR)
	private String productName;
	@NotBlank(message = ApiMessage.PRODUCT_SKU_ERROR)
	private String productSKU;
	private String productDescription;
	
	@Min(value = 0, message = ApiMessage.MINIMUM_PRICE_REQUIRED)
	private double productPrice;
	@Max(value = 4, message = ApiMessage.MAX_LIMIT_ERROR)
	private int qty;
	private double productWeight;
	
//	//can have only 4
//	private int productQuantity;
	
	// category
	// it will be replaced by Enum
	@NotBlank(message = ApiMessage.PRODUCT_CATEGORY_ERROR)
	private String productCategory;
}
