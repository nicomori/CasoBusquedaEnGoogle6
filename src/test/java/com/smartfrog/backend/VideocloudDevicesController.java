package com.smartfrog.backend;

import com.smartfrog.modelclass.Camera;

import io.restassured.RestAssured;

public class VideocloudDevicesController {

	private static final String ENV_NAME = System.getProperty("env");
	private static final String DEVICES_URL = "https://api.dir.ENV_NAME/v1/devices?access_token=ACCESS_TOKEN";
	private static final String ASSIGN_DEVICE_URL = "https://api.dir.sf-dev1.com/v1/user/devices/UUID?access_token=ACCESS_TOKEN";

	public String createMobilcomCameraAdminUI(String clientToken) {
		String endpoint = DEVICES_URL.replace("ENV_NAME", ENV_NAME).replace("ACCESS_TOKEN", clientToken);

		Camera mdCamera = Camera.createMobilcomCamera();
		String macAddress = RestAssured.given().contentType("application/json; charset=UTF-8").body(mdCamera).when()
				.post(endpoint).then().statusCode(200).extract().path("response.serialNumber");
		return macAddress;
	}

	public String createRetailSmartfrogCameraAdminUI(String clientToken) {
		String endpoint = DEVICES_URL.replace("ENV_NAME", ENV_NAME).replace("ACCESS_TOKEN", clientToken);
		Camera sfRetailCamera = Camera.createRetailSmartfrogCamera();
		String cameraUUID = RestAssured.given().contentType("application/json; charset=UTF-8").body(sfRetailCamera)
				.when().post(endpoint).then().statusCode(200).extract().path("response.uuid");
		return cameraUUID;
	}

	public String createSmartfrogCameraAdminUI(String clientToken) {
		String endpoint = DEVICES_URL.replace("ENV_NAME", ENV_NAME).replace("ACCESS_TOKEN", clientToken);
		Camera sfCamera = Camera.createSmartfrogCamera();
		String cameraMacAddress = RestAssured.given().contentType("application/json; charset=UTF-8").body(sfCamera)
				.when().post(endpoint).then().statusCode(200).extract().path("response.serialNumber");
		return cameraMacAddress;

	}

	public void assignDeviceToUser(String deviceUUID, String userToken) {
		String endpoint = ASSIGN_DEVICE_URL.replace("ENV_NAME", ENV_NAME).replace("UUID", deviceUUID)
				.replace("ACCESS_TOKEN", userToken);
		RestAssured.given().contentType("application/json; charset=UTF-8").when().post(endpoint).then().statusCode(200);
	}
}