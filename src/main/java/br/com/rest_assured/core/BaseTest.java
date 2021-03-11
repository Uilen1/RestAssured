package br.com.rest_assured.core;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;


@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {"@Validado"}, 
		features = "src/test/resources/br/com/desafiolivelo/features/", 
		glue = "br.com.desafiolivelo.steps", 
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
		RestAssured.basePath = APP_BASE_PATH;
		
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.setContentType(APP_CONTENT_TYPE);
		RestAssured.requestSpecification = reqBuilder.build();
		
		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
		RestAssured.responseSpecification = resBuilder.build();
		
	}

}
