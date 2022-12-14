package com.ml.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * BookWormV2
 * Created on 21/8/22 - Sunday
 * User Khan, C M Abdullah
 * Ref:
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment extends BaseEntity {
	
	private String type;
	private String cardName;
	private String cardNumber;
	private int cvc;
	//amount
	
	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	//set billing address -> todo
}
