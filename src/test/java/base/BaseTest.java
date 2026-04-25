package base;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class BaseTest {
	
	protected RequestSpecification reqSpec;
	
	@BeforeClass
	public void setup() {
		reqSpec = given()
				.baseUri(ConfigReader.getProperty("baseUrl"))
				.auth().oauth2(ConfigReader.getProperty("bearerToken"))
				.header("Content-Type", "application/json");
	}

}
