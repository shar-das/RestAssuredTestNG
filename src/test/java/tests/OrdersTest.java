package tests;

import java.util.List;

import org.testng.annotations.Test;

import base.BaseTest;
import pojo.AllOrderDetails;

public class OrdersTest extends BaseTest {
	
	@Test
	public void createOrder() {
		
	}
	
	@Test
	public void getAllOrders() {
		
		List<AllOrderDetails> orders = reqSpec
				.when()
					.get("/orders")
				.then()
					.statusCode(200)
					.extract().jsonPath().getList("", AllOrderDetails.class);
		
	}

}
