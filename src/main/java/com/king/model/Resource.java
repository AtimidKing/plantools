package com.king.model;

import java.math.BigInteger;

/**
 * Created by king on 2017/7/25.
 */
public class Resource {
    private BigInteger id;
    private BigInteger planId;
    private String address;

    public Resource(){}
    public Resource(BigInteger id, BigInteger planId,String address){
        setId(id);
        setPlanId(planId);
        setAddress(address);
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getPlanId() {
        return planId;
    }

    public void setPlanId(BigInteger planId) {
        this.planId = planId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
