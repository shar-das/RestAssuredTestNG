package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pojo.APIStatus;

public class APIStatusTest extends BaseTest {
	
	@Test
	public void getAPIStatus() {
		
		APIStatus response = reqSpec
				.when()
					.get("/status")
				.then()
					.statusCode(200)
					.extract().as(APIStatus.class);
		
		Assert.assertEquals(response.getStatus(), "UP", "Tool Rental API is down");
	}

}
