package br.com.rest_assured.steps;

import io.cucumber.java.pt.Quando;
import io.restassured.response.ValidatableResponse;

import static br.com.rest_assured.core.GlobalValidatableResponse.setvResponse;
import static io.restassured.RestAssured.given;



public class DeleteStep{
	
	ValidatableResponse vResponse;
	
	@Quando("^removo a conta com id \"(.*?)\" na rota \"(.*?)\"$")
	public void removoAContaComIdNaRota(String conta_id, String rota) throws Throwable {
		
		vResponse = 
				given()
				.header("Authorization", "JWT " + BaseStep.token)
			.when()
				.delete(rota + "/" + conta_id)
			.then()
			;
		
		setvResponse(vResponse);
	}
	
	@Quando("^removo a movimentação com id \"(.*?)\" na rota \"(.*?)\"$")
	public void removoAMovimentaçãoComIdNaRota(String id, String rota) throws Throwable {

		vResponse = 
				given()
				.header("Authorization", "JWT " + BaseStep.token)
			.when()
				.delete(rota + "/" + id)
			.then()
			;
		
		setvResponse(vResponse);
		
	}
	
}
