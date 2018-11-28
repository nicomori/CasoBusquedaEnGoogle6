package com.smartfrog.backend;

import com.smartfrog.modelclass.UserTestFlag;

import io.restassured.RestAssured;

public class VideocloudAdminController {

	private static final String ENV_NAME = System.getProperty("env");
	private static final String SEARCH_USER_URL = "https://api.dir.ENV_NAME/v1/admin/users?email=EMAIL&consumer=true&max=1024&access_token=ACCESS_TOKEN";
	private static final String UPDATE_USER_URL = "https://api.dir.ENV_NAME/v1/admin/users/UUID?access_token=ACCESS_TOKEN";

	// TODO: extract 'Search user' functionality to separate method
	private String getUsersUuid(String userEmail, String adminToken) {
		System.out.println("VideocloudAdminController:getUsersUuid: Start with user email: "+userEmail+" and admin token: "+adminToken);
		String endpoint = SEARCH_USER_URL.replace("ENV_NAME", ENV_NAME).replace("EMAIL", userEmail)
				.replace("ACCESS_TOKEN", adminToken);

		System.out.println(endpoint);

		String uuid = RestAssured.given().contentType("application/json; charset=UTF-8").when().get(endpoint).then()
				.statusCode(200).extract().path("response.items[0].uuid");
		return uuid;
	}

	public void updateTestUserFlag(String userEmail, String adminToken) {
		String usersUuid = getUsersUuid(userEmail, adminToken);
		String endpoint = UPDATE_USER_URL.replace("ENV_NAME", ENV_NAME).replace("UUID", usersUuid)
				.replace("ACCESS_TOKEN", adminToken);
		RestAssured.given().contentType("application/json; charset=UTF-8").body(new UserTestFlag(true)).when()
				.put(endpoint).then().statusCode(200);
	}
}
