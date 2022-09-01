package com.ml.app.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ml.app.constants.ApiMessage;
import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
@ToString
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddressDto {
	@JsonProperty("address_id")
	private long addressId;
	@JsonProperty("house_no")
	@NotBlank(message = ApiMessage.HOUSE_NO_REQUIRED_ERROR)
	private String houseNo;
	@JsonProperty("road_no")
	@NotBlank(message = ApiMessage.ROAD_NO_REQUIRED_ERROR)
	private String roadNo;
	private String city;
	private String state;
	private String country;
	private String zipcode;
}
