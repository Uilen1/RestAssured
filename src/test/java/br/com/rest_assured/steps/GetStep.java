package br.com.rest_assured.steps;

import cucumber.api.java.pt.Então;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetStep{

	@Então("^é retornado para a requisição o status code \"(.*?)\"$")
	public void retornado_o_status_code(String statusCode) throws Exception {
		given()
		.when()
			.get(BaseStep.rota)
		.then()
			.log().all()
			.statusCode(is(Integer.parseInt(statusCode)));
		
	}
	
}
