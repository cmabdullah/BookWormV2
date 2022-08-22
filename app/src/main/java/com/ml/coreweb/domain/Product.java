package com.ml.coreweb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	
	@OneToOne
	private Categories categories;
	
	// category
}
