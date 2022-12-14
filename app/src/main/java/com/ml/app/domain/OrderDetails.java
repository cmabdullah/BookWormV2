package com.ml.app.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetails extends BaseEntity {
	private int subQty;
	private double price;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private Order order;
}
