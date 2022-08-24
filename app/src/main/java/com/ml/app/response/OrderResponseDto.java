package com.ml.app.response;

import com.ml.app.request.ShippingAddressDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDto {
	private long orderId;
	private String orderStatus;
	private String shippingMethod;
	private double totalPrice;
	private ShippingAddressDto shippingAddress;
	private List<ProductResponseDto> products;
}
