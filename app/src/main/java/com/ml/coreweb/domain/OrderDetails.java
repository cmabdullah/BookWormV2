package com.ml.coreweb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	private int qty;
	//@OneToMany
	@ManyToMany
	private List<Product> products;
	
	@OneToOne
	private Order order;
}
