package com.smartfrog.modelclass;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistributorData {
    @JsonProperty("distributor")
    private String distributor;
    @JsonProperty("reseller")
    private String reseller;
    @JsonProperty("resellerSub")
    private String resellerSub;

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public String getReseller() {
        return reseller;
    }

    public void setReseller(String reseller) {
        this.reseller = reseller;
    }

    public String getResellerSub() {
        return resellerSub;
    }

    public void setResellerSub(String resellerSub) {
        this.resellerSub = resellerSub;
    }
}
