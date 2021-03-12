package br.com.rest_assured.steps;

import cucumber.api.java.gl.E;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class PostStep {
	
	private ValidatableResponse Vresponse;


	@Quando("^insiro uma conta com nome \"(.*?)\" na rota \"(.*?)\"$")
	public void insiro_uma_conta_com_nome(String nome, String rota) throws Throwable {

		Map<String, String> conta = new HashMap<String, String>();
		conta.put("nome", nome);

		Vresponse = 
		given()
			.header("Authorization", "JWT " + BaseStep.token)
			.body(conta)
		.when()
			.post(rota)
		.then()
		;
	}
	
	@Então("^é retornado para a inserção de dados o status code \"(.*?)\"$")
	public void é_retornado_para_a_inserção_de_dados_o_status_code(String statusCode) throws Throwable {

		Vresponse
			.statusCode(is(Integer.parseInt(statusCode)))
		;
		
	}
	
	@Então("^é retornado para a inserção de dados já existentes o status code \"(.*?)\" com a mensagem de erro \"(.*?)\"$")
	public void éRetornadoParaAInserçãoDeDadosOStatusCodeComAMensagemDeErro(String statusCode, String mensagem) throws Throwable {
		Vresponse
			.statusCode(is(Integer.parseInt(statusCode)))
			.body("error", is(mensagem))
		;
	}

}
