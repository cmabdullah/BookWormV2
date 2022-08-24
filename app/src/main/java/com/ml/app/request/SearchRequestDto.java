package com.ml.app.request;

import lombok.Data;

/**
 * BookWormV2
 * Created on 24/8/22 - Wednesday
 * User Khan, C M Abdullah
 * Ref:
 */
@Data
public class SearchRequestDto {
	private String productName;
	private String sku;
	private String category;
}
