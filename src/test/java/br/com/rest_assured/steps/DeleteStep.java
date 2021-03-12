package br.com.rest_assured.steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;

import static io.restassured.RestAssured.*;

import org.junit.Assert;


public class DeleteStep{
	
	private int statusCode;
	
	@Dado("^deleto pelo ID do usuário \"(.*?)\"$")
	public void deleto_pelo_ID_do_usuário(String idUser) throws Exception {
		statusCode =  when().delete(BaseStep.rota + idUser).getStatusCode();
		
	}
	
	@Então("^é retornado para a deleção o status code \"(.*?)\"$")
	public void retornado_o_status_code(String statusCode) throws Exception {
		Assert.assertEquals(statusCode, Integer.toString(this.statusCode));
	}
	
}
