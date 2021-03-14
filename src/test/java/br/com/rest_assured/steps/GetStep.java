package br.com.rest_assured.steps;

import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.restassured.response.ValidatableResponse;

import static br.com.rest_assured.core.GlobalValidatableResponse.setvResponse;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetStep{
	
	ValidatableResponse vResponse;
	
	@Quando("^verifico o saldo de \"(.*?)\" na conta com id \"(.*?)\" na rota \"(.*?)\"$")
	public void verificoOSaldoPeloContaComIdNaRota(String saldo ,String conta_id, String rota) throws Throwable {
		vResponse = 
				given()
					.header("Authorization", "JWT " + BaseStep.token)
				.when()
					.get(rota)
				.then()
					.body("find{it.conta_id == "+conta_id+"}.saldo", is(saldo))
			;
		
		setvResponse(vResponse);
	}

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
