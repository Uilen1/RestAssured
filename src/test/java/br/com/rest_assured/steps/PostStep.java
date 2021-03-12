package br.com.rest_assured.steps;

import cucumber.api.java.gl.E;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class PostStep {
	
	private int statusCode;

	@Quando("^insiro uma conta com nome \"(.*?)\" na rota \"(.*?)\"$")
	public void insiro_uma_conta_com_nome(String nome, String rota) throws Throwable {

		Map<String, String> conta = new HashMap<String, String>();
		conta.put("nome", nome);

		statusCode = 
		given()
			.header("Authorization", "JWT " + BaseStep.token)
			.body(conta)
		.when()
			.post(rota)
			.getStatusCode()
		;
	}
	
	@Então("^é retornado para a inserção de dados o status code \"(.*?)\"$")
	public void é_retornado_para_a_inserção_de_dados_o_status_code(String statusCode) throws Throwable {

		Assert.assertEquals(Integer.parseInt(statusCode), this.statusCode);
		
	}

}
