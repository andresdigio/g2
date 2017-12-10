package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Company extends User{
    private String serviceRange, serviceType, serviceCharacteristics, serviceIncoterms, serviceIncludes, transportContainer, transportType, loadSize, loadType;

    public Company(String username, String name, String email, Location location, String phoneNum, String serviceRange, String serviceType, String serviceCharacteristics, String serviceIncoterms, String serviceIncludes, String transportContainer, String transportType, String loadSize, String loadType) {
        super(username, name, email, location, phoneNum);
        this.serviceRange = serviceRange;
        this.serviceType = serviceType;
        this.serviceCharacteristics = serviceCharacteristics;
        this.serviceIncoterms = serviceIncoterms;
        this.serviceIncludes = serviceIncludes;
        this.transportContainer = transportContainer;
        this.transportType = transportType;
        this.loadSize = loadSize;
        this.loadType = loadType;
    }

    public Company(ResultSet rs) throws SQLException {
        super(rs);
        serviceRange = rs.getString("serviceRange");
        serviceType = rs.getString("serviceType");
        serviceCharacteristics = rs.getString("serviceCharacteristics");
        serviceIncoterms = rs.getString("serviceIncoterms");
        serviceIncludes = rs.getString("serviceIncludes");
        transportContainer = rs.getString("transportContainer");
        transportType = rs.getString("transportType");
        loadSize = rs.getString("loadSize");
        loadType = rs.getString("loadType");
    }

    public String getServiceRange() {
        return serviceRange;
    }

    public void setServiceRange(String serviceRange) {
        this.serviceRange = serviceRange;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceCharacteristics() {
        return serviceCharacteristics;
    }

    public void setServiceCharacteristics(String serviceCharacteristics) {
        this.serviceCharacteristics = serviceCharacteristics;
    }

    public String getServiceIncoterms() {
        return serviceIncoterms;
    }

    public void setServiceIncoterms(String serviceIncoterms) {
        this.serviceIncoterms = serviceIncoterms;
    }

    public String getServiceIncludes() {
        return serviceIncludes;
    }

    public void setServiceIncludes(String serviceIncludes) {
        this.serviceIncludes = serviceIncludes;
    }

    public String getTransportContainer() {
        return transportContainer;
    }

    public void setTransportContainer(String transportContainer) {
        this.transportContainer = transportContainer;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getLoadSize() {
        return loadSize;
    }

    public void setLoadSize(String loadSize) {
        this.loadSize = loadSize;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }
}
