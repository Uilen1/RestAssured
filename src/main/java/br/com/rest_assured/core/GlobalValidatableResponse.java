package br.com.rest_assured.core;

import io.restassured.response.ValidatableResponse;

public class GlobalValidatableResponse {
	
	private static ValidatableResponse vResponse;

	public static ValidatableResponse getvResponse() {
		return vResponse;
	}

	public static void setvResponse(ValidatableResponse vResponse) {
		GlobalValidatableResponse.vResponse = vResponse;
	}

	
	
	

}
