package com.ml.coreweb.request;

import com.ml.coreweb.constants.ApiMessage;
import lombok.*;

import javax.validation.constraints.Min;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
@ToString
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
	
	@Min(value = 0, message = ApiMessage.SUB_TOTAL_PRICE_REQUIRED_ERROR)
	private Double subTotal;
	@Min(value = 0, message = ApiMessage.MINIMUM_PRICE_REQUIRED)
	private int qty;
	private ProductRequestDto product;
}
