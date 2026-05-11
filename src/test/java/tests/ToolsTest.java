package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import constants.Constants;
import pojo.response.ToolDetailsResponse;

public class ToolsTest extends BaseTest {
	
	@Test
	public void getAllTools() {
		
		List<ToolDetailsResponse> tools = reqSpec
				.when()
					.get("/tools")
				.then()
					.statusCode(200)
					.extract().jsonPath().getList("", ToolDetailsResponse.class);
		
		for(ToolDetailsResponse tool:tools) {
			Assert.assertNotNull(tool.getId());
			Assert.assertNotNull(tool.getCategory());
			Assert.assertNotNull(tool.getName());
		}
		
	}
	
	@Test
	public void getSingleTool() {
		
		List<ToolDetailsResponse> inStockLadders = reqSpec
					.queryParam("category", Constants.CATEGORY)
					.queryParam("available", "true")
				.when()
					.get("/tools")
				.then()
					.extract().jsonPath().getList("", ToolDetailsResponse.class);
		
		int firstLadderId = inStockLadders.get(0).getId();
		
		ToolDetailsResponse res = reqSpec
				.when()
					.get("/tools/" + firstLadderId)
				.then()
					.statusCode(200)
					.extract().as(ToolDetailsResponse.class);
		
		Assert.assertEquals(res.getId(), Constants.LADDER_ID);
		Assert.assertEquals(res.getCategory(), Constants.CATEGORY);
		Assert.assertTrue(res.getName().contains(Constants.LADDER_NAME));
		Assert.assertEquals(res.getManufacturer(), Constants.MANUFACTURER_NAME);
		Assert.assertEquals(res.getPrice(), Constants.LADDER_PRICE);
		Assert.assertTrue(res.getCurrentStock() > 0);
		Assert.assertEquals(res.isInStock(), true);
		
	}

}
