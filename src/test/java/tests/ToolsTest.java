package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pojo.ToolDetails;
import utils.Constants;

public class ToolsTest extends BaseTest {
	
	@Test
	public void getAllTools() {
		
		List<ToolDetails> tools = reqSpec
				.when()
					.get("/tools")
				.then()
					.statusCode(200)
					.extract().jsonPath().getList("", ToolDetails.class);
		
		for(ToolDetails tool:tools) {
			Assert.assertNotNull(tool.getId());
			Assert.assertNotNull(tool.getCategory());
			Assert.assertNotNull(tool.getName());
		}
		
	}
	
	@Test
	public void getSingleTool() {
		
		List<ToolDetails> inStockLadders = reqSpec
					.queryParam("category", Constants.CATEGORY)
					.queryParam("available", "true")
				.when()
					.get("/tools")
				.then()
					.extract().jsonPath().getList("", ToolDetails.class);
		
		int firstLadderId = inStockLadders.get(0).getId();
		
		ToolDetails res = reqSpec
				.when()
					.get("/tools/" + firstLadderId)
				.then()
					.statusCode(200)
					.extract().as(ToolDetails.class);
		
		Assert.assertEquals(res.getId(), Constants.LADDER_ID);
		Assert.assertEquals(res.getCategory(), Constants.CATEGORY);
		Assert.assertTrue(res.getName().contains(Constants.LADDER_NAME));
		Assert.assertEquals(res.getManufacturer(), Constants.MANUFACTURER_NAME);
		Assert.assertEquals(res.getPrice(), Constants.LADDER_PRICE);
		Assert.assertTrue(res.getCurrentStock() > 0);
		Assert.assertEquals(res.isInStock(), true);
		
	}

}
