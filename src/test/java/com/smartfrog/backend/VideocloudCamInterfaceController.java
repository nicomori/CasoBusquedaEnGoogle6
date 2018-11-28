package com.smartfrog.backend;

import io.restassured.RestAssured;

public class VideocloudCamInterfaceController {

    private static final String ENV_NAME = System.getProperty("env");
    private static final String ASSIGN_DEVICE_URL = "https://api.dir.ENV_NAME/cam/assignCamera?serialNumber=SERIAL_NUMBER&wifiToken=WIFI_TOKEN&secureToken=SECURE_TOKEN&access_token=ACCESS_TOKEN";

    private static final String secureToken = "zmodo";
    private static final String wifiToken = "WIFI_TOKEN";

    public void assignCameraToUser(String cameraMacAddress, String userToken){
        String endpoint = ASSIGN_DEVICE_URL.replace("ENV_NAME", ENV_NAME)
                .replace("SERIAL_NUMBER", cameraMacAddress)
                .replace("WIFI_TOKEN", wifiToken)
                .replace("SECURE_TOKEN", secureToken)
                .replace("ACCESS_TOKEN", userToken);
        RestAssured
                .given()
                .contentType("application/json; charset=UTF-8")
                .when()
                .post(endpoint)
                .then()
                .statusCode(200);

    }
}
