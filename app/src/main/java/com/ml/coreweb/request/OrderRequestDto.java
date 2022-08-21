package com.ml.coreweb.request;

import com.ml.coreweb.constants.ApiMessage;
import com.ml.coreweb.domain.CartItem;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
public class OrderRequestDto {
	@NotBlank(message = ApiMessage.SHIPPING_METHOD_ERROR)
	private String shippingMethod;
	// private String orderStatus;
	@Min(value = 0, message = ApiMessage.TOTAL_PRICE_REQUIRED_ERROR)
	private Double orderTotal;
	private ShippingAddressDto shippingAddress;
	private PaymentDto payment;
	private List<CartItemDto> cartItems;
}
