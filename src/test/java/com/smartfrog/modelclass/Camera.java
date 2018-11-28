package com.smartfrog.modelclass;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Random;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Camera {
    @JsonProperty("articleNumber")
    private String articleNumber;
    @JsonProperty("deviceModel")
    private String deviceModel;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("distributorData")
    DistributorData distributorData;
    @JsonProperty("ean")
    private String ean;
    @JsonProperty("hardwareVersion")
    private String hardwareVersion;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("retail")
    private boolean retail;
    @JsonProperty("serialNumber")
    private String serialNumber;
    @JsonProperty("softwareVersion")
    private String softwareVersion;
    @JsonProperty("type")
    private String type;

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public DistributorData getDistributorData() {
        return distributorData;
    }

    public void setDistributorData(DistributorData distributorData) {
        this.distributorData = distributorData;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean isRetail() {
        return retail;
    }

    public void setRetail(boolean retail) {
        this.retail = retail;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static String generateMacAddress(){
        String macAddress;
        Random r = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < 12; i++) {
            builder.append(r.nextInt(10));
        }
        macAddress = builder.toString();
        return macAddress;
    }

    public static Camera createMobilcomCamera() {
        Camera mdCamera = new Camera();
        mdCamera.setArticleNumber("100120111");
        mdCamera.setDeviceModel("ZmodoEZ");
        mdCamera.setDisplayName("qaTest");
        mdCamera.setOrigin("Test");
        mdCamera.setRetail(false);
        mdCamera.setSerialNumber("M"+generateMacAddress());
        mdCamera.setType("Camera");
        return mdCamera;
    }

    public static Camera createRetailSmartfrogCamera() {
        Camera smartfrogRetailCamera = new Camera();
        smartfrogRetailCamera.setArticleNumber("100010001");
        smartfrogRetailCamera.setDeviceModel("ZmodoEZ");
        smartfrogRetailCamera.setDisplayName("qaTest");
        smartfrogRetailCamera.setOrigin("Test");
        smartfrogRetailCamera.setRetail(true);
        smartfrogRetailCamera.setSerialNumber("M"+generateMacAddress());
        smartfrogRetailCamera.setType("Camera");
        return smartfrogRetailCamera;
    }

    public static Camera createSmartfrogCamera() {
        Camera smartfrogCamera = new Camera();
        smartfrogCamera.setArticleNumber("100010001");
        smartfrogCamera.setDeviceModel("ZmodoEZ");
        smartfrogCamera.setDisplayName("qaTest");
        smartfrogCamera.setOrigin("Test");
        smartfrogCamera.setRetail(false);
        smartfrogCamera.setSerialNumber("M"+generateMacAddress());
        smartfrogCamera.setType("Camera");
        return smartfrogCamera;
    }

}
