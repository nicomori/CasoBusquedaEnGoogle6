package com.smartfrog.backend;

import io.restassured.RestAssured;

public class VideocloudTokenGenerator {

    private static final String ENV_NAME = System.getProperty("env");
    private static final String CLIENT_TOKEN_URL = "https://api.dir.ENV_NAME/oauth/token?grant_type=client_credentials&scope=Standard";
    
    
 //   private static final String ADMIN_TOKEN_URL = "https://api.dir.ENV_NAME/oauth/token?grant_type=password&username=qa_automation&password=7586ABC4610def$$@@!!&scope=Standard&device=Browser";
    private static final String ADMIN_TOKEN_URL = "https://api.dir.ENV_NAME/oauth/token?grant_type=password&username=test.user&password=L6w40Ngo5GYnwAWKGE!&scope=Standard&device=Browser";
    
    
    private static final String USER_TOKEN_URL = "https://api.dir.ENV_NAME/oauth/token?grant_type=password&username=USER_EMAIL&password=PASSWORD&scope=Standard&device=Browser";

//    public String generateClientToken() {
//        String endpoint = CLIENT_TOKEN_URL.replace("ENV_NAME", ENV_NAME);
//        String clientToken = RestAssured
//                .given()
//                .header("Authorization", "Basic bW9iaWxjb206bW9iaWxjb206MDE=")
//                .contentType("application/json; charset=UTF-8")
//                .when()
//                .post(endpoint)
//                .then()
//                .statusCode(200)
//                .extract()
//                .path("access_token");
//        return clientToken;
//    }

    public String generateAdminUserToken() {
        String endpoint = ADMIN_TOKEN_URL.replace("ENV_NAME", ENV_NAME);
        System.out.println(endpoint);
        String adminToken = RestAssured
                .given()
                .header("Authorization", "Basic dmlkZW9jbG91ZDp2aWRlb2Nsb3VkOjAx")
                .contentType("application/json; charset=UTF-8")
                .when()
                .post(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .path("access_token");
        return adminToken;
    }
//    public String generateUserToken(String userEmail, String userPassword) {
//        String endpoint = USER_TOKEN_URL.replace("ENV_NAME", ENV_NAME)
//                .replace("USER_EMAIL", userEmail).replace("PASSWORD", userPassword);
//        String userToken = RestAssured
//                .given()
//                .urlEncodingEnabled(false)
//                .header("Authorization", "Basic dmlkZW9jbG91ZDp2aWRlb2Nsb3VkOjAx")
//                .contentType("application/json; charset=UTF-8")
//                .when()
//                .post(endpoint)
//                .then()
//                .statusCode(200)
//                .extract()
//                .path("access_token");
//        return userToken;
//
//    }
}