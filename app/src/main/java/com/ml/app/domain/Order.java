package com.ml.app.domain;

import com.ml.auth.domain.User;
import lombok.*;

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
	private Double totalPrice;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ShippingAddress shippingAddress;
	@ToString.Exclude
	//need work
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
	private List<OrderDetails> OrderDetailsList;
	
	//userObject
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	User user;
}
