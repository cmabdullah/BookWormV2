package com.ml.coreweb.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

/**
 * BookWormV2
 * Created on 21/8/22 - Sunday
 * User Khan, C M Abdullah
 * Ref:
 */
@Data
@Entity
@NoArgsConstructor
public class CartItem extends BaseEntity {
	
	private int qty;
	private Double subtotal;
	
	@OneToOne
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
}
