package br.com.rest_assured.steps;

import cucumber.api.java.gl.E;
import cucumber.api.java.pt.Dado;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;



public class BaseStep{

	protected static String rota;
	protected static String token;
	private String email;
	private String senha;
	
	@Dado("^que acesso a rota \"(.*?)\"$")
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
	
}
