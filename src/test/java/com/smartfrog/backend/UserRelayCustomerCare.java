package com.smartfrog.backend;

import com.smartfrog.modelclass.User;

import io.restassured.RestAssured;

public class UserRelayCustomerCare {

	private static final String ENV_NAME = System.getProperty("env");
	private static final String CREATE_USER_URL = "https://user-relay.dir.ENV_NAME/api/v1/mobilcom/accounts";

	public String createMobilcomUser() {
		User mdUser = User.createMobilcomUserHotline();
		
		String endpoint = CREATE_USER_URL.replace("ENV_NAME", ENV_NAME);
		String mobilcomActivationURL = RestAssured.given().header("Authorization", "Basic bW9iaWxjb206bW9iaWxjb206MDE=")
				.contentType("application/json; charset=UTF-8").body(mdUser).when().post(endpoint).then()
				.statusCode(200).extract().path("activationUrl");
		return mobilcomActivationURL;
	}
}


//changes for Bobby



//public class UserRelayAPIClient {
//	private static final String ENV_NAME = System.getProperty("env");
//	private static final String API_BASE_URL = "https://user-relay.dir.ENV_NAME/";
//	
//	public static init() {
//		String endpoint = API_BASE_URL.replace("ENV_NAME", ENV_NAME);
//		return RestAssured.given().header("Authorization", "Basic bW9iaWxjb206bW9iaWxjb206MDE=")
//				.contentType("application/json; charset=UTF-8").baseUri(endpoint);
//	}
//}
//
//
//
//public class UserRelayCustomerCare {
//
//	private static final String CREATE_USER_URL = "/api/v1/mobilcom/accounts";
//
//	public String createMobilcomUser() {
//		User mdUser = User.createMobilcomUserHotline();
//		
//		String mobilcomActivationURL = UserRelayAPIClient.init().body(mdUser).when().post(endpoint).then()
//				.statusCode(200).extract().path("activationUrl");
//		return mobilcomActivationURL;
//	}
//}