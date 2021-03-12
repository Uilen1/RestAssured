package br.com.rest_assured.steps;

import cucumber.api.java.gl.E;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class PutStep {
	
	private ValidatableResponse Vresponse;

	@Quando("^altero uma conta pelo nome \"(.*?)\" através do id \"(.*?)\" na rota \"(.*?)\"$")
	public void insiro_uma_conta_com_nome(String nome, String id, String rota) throws Throwable {

		Map<String, String> conta = new HashMap<String, String>();
		conta.put("nome", nome);

		Vresponse = 
			given()
			.header("Authorization", "JWT " + BaseStep.token)
			.body(conta)
		.when()
			.put(rota + "/" + id)
		.then()
		;
	}
	
	@Então("^é retornado para a alteração de dados o status code \"(.*?)\"$")
	public void é_retornado_para_a_inserção_de_dados_o_status_code(String statusCode) throws Throwable {

		Vresponse.statusCode(is(Integer.parseInt(statusCode)));
		
	}

}
