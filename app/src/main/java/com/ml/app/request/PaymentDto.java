package com.ml.app.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ml.app.constants.ApiMessage;
import lombok.*;

import javax.validation.constraints.Min;
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
public class PaymentDto {
	@NotBlank(message = ApiMessage.CARD_TYPE_REQUIRED_ERROR)
	private String type;
	@JsonProperty("card_name")
	@NotBlank(message = ApiMessage.CARD_NAME_REQUIRED_ERROR)
	private String cardName;
	@JsonProperty("card_number")
	@NotBlank(message = ApiMessage.CARD_NO_REQUIRED_ERROR)
	private String cardNumber;
	@Min(value = 0, message = ApiMessage.CVC_ERROR)
	private int cvc;
}
