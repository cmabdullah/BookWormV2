package com.ml.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * BookWormV2
 * Created on 21/8/22 - Sunday
 * User Khan, C M Abdullah
 * Ref:
 */
@Data
@Entity
@Table(name = "product_order")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends BaseEntity {
	
	private String shippingMethod;
	private String orderStatus;
	private Double orderTotal;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ShippingAddress shippingAddress;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private Payment payment;
	
	//need work
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private List<OrderDetails> OrderDetailsList;
}
