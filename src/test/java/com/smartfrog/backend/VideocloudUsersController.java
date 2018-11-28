package com.smartfrog.backend;

import com.smartfrog.modelclass.User;

import io.restassured.RestAssured;

public class VideocloudUsersController {
	private static final String ENV_NAME = System.getProperty("env");
	private static final String CREATE_USERS_URL = "https://api.dir.ENV_NAME/v1/users?acceptLegalDocuments=true&access_token=ACCESS_TOKEN";

	public void createSmartfrogUser(String clientToken, User sfUser) {
		String endpoint = CREATE_USERS_URL.replace("ENV_NAME", ENV_NAME).replace("ACCESS_TOKEN", clientToken);
		RestAssured.given().header("Authorization", "Basic c21hcnRmcm9nOnBsZWFzZWFza21lMjAxOA==")
				.contentType("application/json; charset=UTF-8").body(sfUser).when().post(endpoint).then()
				.statusCode(200);
	}
}
