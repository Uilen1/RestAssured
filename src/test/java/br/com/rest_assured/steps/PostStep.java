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

import br.com.rest_assured.core.MovimentacaoBean;

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
	
	@Quando("^insiro uma movimentação pelo id \"(.*?)\", descrição \"(.*?)\", envolvido \"(.*?)\",tipo \"(.*?)\", data transação \"(.*?)\", data pagamento \"(.*?)\", valor \"(.*?)\" e status \"(.*?)\" na rota \"(.*?)\"$")
	public void insiroUmaMovimentaçãoPeloIdDescriçãoEnvolvidoTipoDataTransaçãoDataPagamentoValorEStatusNaRota(String conta_id, String descricao, String envolvido, String tipo, String data_transacao, String data_pagamento, String valor, String status, String rota) throws Throwable {
	    
		MovimentacaoBean mov = new MovimentacaoBean();
		mov.setConta_id(Integer.parseInt(conta_id));
		mov.setDescricao(descricao);
		mov.setEnvolvido(envolvido);
		mov.setTipo(tipo);
		mov.setData_transacao(data_transacao);
		mov.setData_pagamento(data_pagamento);
		mov.setValor(Float.parseFloat(valor));
		mov.setStatus(Boolean.parseBoolean(status));
		
		Vresponse = 
				given()
					.header("Authorization", "JWT " + BaseStep.token)
					.body(mov)
				.when()
					.post(rota)
				.then()
				;
		
	}
	
	@Quando("^não insiro nenhum campo obrigatório na rota \"(.*?)\"$")
	public void nãoInsiroNenhumCampoObrigatórioNaRota(String rota) throws Throwable {

		Vresponse = 
				given()
					.header("Authorization", "JWT " + BaseStep.token)
					.body("{}")
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
	
	@Então("^valido todas as mensagens obrigatórias e o status code \"(.*?)\"$")
	public void validoTodasAsMensagensObrigatóriasEOStatusCode(String statusCode) throws Throwable {

		Vresponse
		.statusCode(is(Integer.parseInt(statusCode)))
		.body("msg", hasItems(
					"Data da Movimentação é obrigatório",
					"Data do pagamento é obrigatório",
					"Descrição é obrigatório",
					"Interessado é obrigatório",
					"Valor é obrigatório",
					"Valor deve ser um número",
					"Conta é obrigatório",
					"Situação é obrigatório"				
				))
		;
		
	}

}
