package com.smartfrog.backend;

import io.restassured.RestAssured;

public class VideocloudUserController {

    private static final String ENV_NAME = System.getProperty("env");
    private static final String CREATE_WIFI = "https://api.dir.ENV_NAME/v1/user/signInDevice?wifiToken=WIFI_TOKEN&deviceName=DEVICE_NAME&access_token=ACCESS_TOKEN";

    public void createWifiForCam(String userToken){

        String endpoint = CREATE_WIFI.replace("ENV_NAME", ENV_NAME)
                .replace("WIFI_TOKEN", "WIFI_TOKEN")
                .replace("DEVICE_NAME", "TestCam123")
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

