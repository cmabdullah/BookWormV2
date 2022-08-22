package com.ml.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * BookWormV2
 * Created on 21/8/22 - Sunday
 * User Khan, C M Abdullah
 * Ref:
 */
@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShippingAddress extends BaseEntity {
	private String houseNo;
	private String roadNo;
	private String city;
	private String state;
	private String country;
	private String zipcode;
}
