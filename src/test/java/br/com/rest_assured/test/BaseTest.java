package br.com.rest_assured.test;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import br.com.rest_assured.core.Constants;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;


@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {"@DELETEteste1"}, 
		features = "src/test/resources/br/com/rest_assured/features/", 
		glue = "br.com.rest_assured.steps", 
		snippets = SnippetType.CAMELCASE,
		plugin = {
				"pretty", 
				"html:target/cucumber-reports",
				"json:target/report.json"
				}
			)

public class BaseTest implements Constants {
	
	@BeforeClass
	public static void setup() {
		
		RestAssured.baseURI = APP_BASE_URL;
		RestAssured.port = APP_PORT;
		
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.setContentType(APP_CONTENT_TYPE);
		RestAssured.requestSpecification = reqBuilder.build();
		
		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		//resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
		RestAssured.responseSpecification = resBuilder.build();
		
	}

}
