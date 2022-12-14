package com.ml.app.constants;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
public class ApiMessage {
	
	//product request dto
	public static final String PRODUCT_NAME_ERROR = "product.name.error";
	public static final String PRODUCT_SKU_ERROR = "product.sku.error";
	public static final String MINIMUM_PRICE_REQUIRED = "minimum.price.required";
	public static final String MAX_LIMIT_ERROR = "max.limit.error";
	public static final String PRODUCT_CATEGORY_ERROR = "product.category.error";
	public static final String PRODUCT_NOT_FOUND_ERROR = "product.not.found.error";

	public static final String SUCCESS = "success";
	
	//order request
	public static final String SHIPPING_METHOD_ERROR = "shipping.method.error";
	public static final String TOTAL_PRICE_REQUIRED_ERROR = "total.price.required.error";
	public static final String SHIPPING_ADDRESS_ERROR = "shipping.address.cannot.be.null.error";
	public static final String PAYMENT_INFO_ERROR = "payment.info.cannot.be.null.error";
	public static final String ORDER_DETAILS_PRODUCT_LIST_ERROR = "order.details.product.list.cannot.be.null.error";
	public static final String ORDER_DETAILS_ERROR = "order.details.cannot.be.null.error";
	
	//shipping address request
	public static final String HOUSE_NO_REQUIRED_ERROR = "house.no.required.error";
	public static final String ROAD_NO_REQUIRED_ERROR = "road.no.required.error";


	//payment request
	public static final String CARD_TYPE_REQUIRED_ERROR = "card.type.required.error";
	public static final String CARD_NAME_REQUIRED_ERROR = "card.name.required.error";
	public static final String CARD_NO_REQUIRED_ERROR = "card.no.required.error";
	public static final String CVC_ERROR = "cvc.error";
	
	public static final String QUANTITY_ERROR = "quantity.error";
	
	public static final String PRODUCT_LIST_ERROR = "product.list.cannot.be.null.error";
	
	public static final String SUB_TOTAL_PRICE_REQUIRED_ERROR = "sub.total.price.required.error";
}
