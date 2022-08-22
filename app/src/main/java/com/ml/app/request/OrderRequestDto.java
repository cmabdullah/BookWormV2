package com.ml.app.request;

import com.ml.app.constants.ApiMessage;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class OrderRequestDto {
	@NotBlank(message = ApiMessage.SHIPPING_METHOD_ERROR)
	private String shippingMethod;
	// private String orderStatus;
	@Min(value = 0, message = ApiMessage.TOTAL_PRICE_REQUIRED_ERROR)
	private Double orderTotal;
	@NotNull(message = ApiMessage.SHIPPING_ADDRESS_ERROR)
	@Valid
	private ShippingAddressDto shippingAddress;
	@NotNull(message = ApiMessage.PAYMENT_INFO_ERROR)
	@Valid
	private PaymentDto payment;
	@NotNull(message = ApiMessage.ORDER_DETAILS_ERROR)
	@Valid
	private OrderDetailsRequest orderDetails;
}
