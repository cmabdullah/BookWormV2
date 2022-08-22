package com.ml.coreweb.request;

import com.ml.coreweb.constants.ApiMessage;
import com.ml.coreweb.domain.Product;
import lombok.*;

import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
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
	private List<ProductRequestDto> products;
}
