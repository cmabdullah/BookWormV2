package com.ml.app.request;

import com.ml.app.constants.ApiMessage;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

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
public class OrderDetailsRequest {
	@Min(value = 0, message = ApiMessage.MINIMUM_PRICE_REQUIRED)
	private int qty;
	@NotNull(message = ApiMessage.ORDER_DETAILS_PRODUCT_LIST_ERROR)
	@Valid
	private List<ProductRequestDto> products;
}
