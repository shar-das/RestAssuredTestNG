package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pojo.response.APIStatusResponse;

public class APIStatusTest extends BaseTest {
	
	@Test
	public void getAPIStatus() {
		
		APIStatusResponse response = reqSpec
				.when()
					.get("/status")
				.then()
					.statusCode(200)
					.extract().as(APIStatusResponse.class);
		
		Assert.assertEquals(response.getStatus(), "UP", "Tool Rental API is down");
	}

}
