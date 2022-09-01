package com.ml.app.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * BookWormV2
 * Created on 24/8/22 - Wednesday
 * User Khan, C M Abdullah
 * Ref:
 */
@Data
public class SearchRequestDto {
	@JsonProperty("product_name")
	private String productName;
	private String sku;
	private String category;
}
