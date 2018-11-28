package com.smartfrog.backend;

import java.io.File;

import io.restassured.RestAssured;

public class UserRelayPartners {
	private static final String ENV_NAME = System.getProperty("env");
	private static final String UPLOAD_API = "user-relay.dir.ENV_NAME/api/v1/partnerdata/PARTNER_REFERENCE/upload/?partnerRef=PARTNER_REFERENCE";
	private static final String DEV_DATA ="http://";
	private static final String TEST_DATA ="https://test-hz-";
	
	
	/**
	 * This service is for make the upload to the Api, for that is necessary work
	 * with a file who need the unique fields in the columns "contract_id, user_id
	 * and email", and this require an String with the partner reference to put in
	 * the endpoint.
	 * 
	 * @param partnerRefence
	 *            String with the partner name.
	 * @param fileWithTheAbsolutePath
	 *            String with the absolute path of the file.
	 * @param authoriyation
	 *            code String with the authorization code.
	 */
	public void uploadFileApi(String partnerRefence, String fileNameWithAbsolutePath, String authorizationCode) {
		String endpoint = UPLOAD_API.replace("ENV_NAME", ENV_NAME);
		endpoint = endpoint.replace("PARTNER_REFERENCE", partnerRefence);
		
		if(ENV_NAME.equals("sf-test1.com")) {
			endpoint = TEST_DATA+endpoint;
		}else {
			endpoint = DEV_DATA+endpoint;
		}
		
		System.out.println("Starting to upload the file to the Api with the partner reference: " + partnerRefence
				+ " in the Enviroment " + ENV_NAME);
		RestAssured.given().multiPart("file", new File(fileNameWithAbsolutePath))
				.header("Authorization", authorizationCode)
				.contentType("multipart/form-data; boundary=----WebKitFormBoundarygWAeOv9MjUkH3MM").when()
				.post(endpoint).then().log().all().statusCode(200);
	}
}
