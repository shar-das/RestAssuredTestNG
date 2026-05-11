package tests;

import java.util.List;

import org.testng.annotations.Test;

import base.BaseTest;
import constants.Constants;
import pojo.request.CreateOrderRequest;
import pojo.response.AllOrdersResponse;
import pojo.response.CreateOrderResponse;

public class OrdersTest extends BaseTest {
	
	String orderId;
	
	@Test
	public void createOrder() {
		
		CreateOrderRequest requestBody = new CreateOrderRequest();
		requestBody.setToolId(Constants.LADDER_ID);
		requestBody.setCustomerName(Constants.CUSTOMER_NAME);
		requestBody.setComment(Constants.COMMENT);
		
		CreateOrderResponse response = reqSpec
					.body(requestBody)
				.when()
					.post("/orders")
				.then()
					.statusCode(201)
					.extract().as(CreateOrderResponse.class);
		
		orderId = response.getOrderId();
		
	}
	
	@Test
	public void getAllOrders() {
		
		List<AllOrdersResponse> orders = reqSpec
				.when()
					.get("/orders")
				.then()
					.statusCode(200)
					.extract().jsonPath().getList("", AllOrdersResponse.class);
		
	}

}
