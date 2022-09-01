package com.ml.app.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * BookWormV2
 * Created on 21/8/22 - Sunday
 * User Khan, C M Abdullah
 * Ref:
 */
@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {
	private String productName;
	private String productSKU;
	private String productDescription;
	private Double productPrice;
	private Double productWeight;
	
	@ToString.Exclude
	@OneToOne
	private Categories categories;
	
	@ToString.Exclude
	// category
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<OrderDetails> orderDetailsList;
}
