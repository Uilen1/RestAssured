package br.com.rest_assured.steps;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.util.Map;

import static br.com.rest_assured.core.GlobalValidatableResponse.setvResponse;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PutStep {
	
	private ValidatableResponse vResponse;

	@Quando("^altero uma conta pelo nome \"(.*?)\" através do id \"(.*?)\" na rota \"(.*?)\"$")
	public void insiro_uma_conta_com_nome(String nome, String id, String rota) throws Throwable {

		Map<String, String> conta = new HashMap<String, String>();
		conta.put("nome", nome);

		vResponse = 
			given()
			.header("Authorization", "JWT " + BaseStep.token)
			.body(conta)
		.when()
			.put(rota + "/" + id)
		.then()
		;
		
		setvResponse(vResponse);
	}
	
	@Então("^é retornado para a alteração de dados o status code \"(.*?)\"$")
	public void é_retornado_para_a_inserção_de_dados_o_status_code(String statusCode) throws Throwable {

		vResponse.statusCode(is(Integer.parseInt(statusCode)));
		
	}

}
