package br.com.rest_assured.steps;

import static br.com.rest_assured.core.GlobalValidatableResponse.getvResponse;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import br.com.rest_assured.core.NameAccountBean;
import br.com.rest_assured.utilities.PathDataJson;
import cucumber.api.java.gl.E;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;



public class BaseStep{

	protected static String rota;
	protected static String token;
	protected static NameAccountBean conta;
	private String email;
	private String senha;
	
	@Dado("^que todoas as massas estão iniciadas$")
	public void queTodoasAsMassasEstãoIniciadas() throws Throwable {
		
		PathDataJson.setJsonData("nome");
		Gson deserialized = new Gson();
		conta = deserialized.fromJson(PathDataJson.getJsonData(), NameAccountBean.class);
		
	}
	
//	@Dado("^que acesso a rota \"(.*?)\"$")
//	public void queAcessoARota(String url) throws Exception {
//		rota = url;
//	}
	
	@E("^que acesso a rota \"(.*?)\"$")
	public void queAcessoARota(String url) throws Exception {
		rota = url;
	}
	
	@E("^logo com email \"(.*?)\" e senha \"(.*?)\"$")
	public void logoComEmailESenha(String email, String senha) throws Throwable {
		this.email = email;
		this.senha = senha;
	}

	@E("^extraio o token$")
	public void extraioOToken() throws Throwable {
		Map<String, String> login = new HashMap<String, String>();
		login.put("email", email);
		login.put("senha", senha);
		
		token = 
		given()
			.body(login)
		.when()
			.post(rota)
		.then()
			.statusCode(200)
			.extract().path("token")		
		;
		
	}
	
	@Então("^é retornado o status code \"(.*?)\"$")
	public void éRetornadoOStatusCode(String statusCode) throws Throwable {
		
		getvResponse().log().all().statusCode(Integer.parseInt(statusCode));
//		getvResponse().statusCode(Integer.parseInt(statusCode));
				
	}
	
}
