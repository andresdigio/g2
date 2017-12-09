package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Company extends User{
    private String container_type, transport, load_size, load_type, service_type, service_description, incoterms, services_included;

    public Company(String username, String name, String email, Location location,String phoneNum,String container_type,String transport,String load_size,String load_type,String service_type,String service_description,String incoterms,String services_included) {
        super(username, name, email, location, phoneNum);
        this.container_type = container_type;
        this.transport = transport;
        this.load_size = load_size;
        this.load_type = load_type;
        this.service_type = service_type;
        this.service_description = service_description;
        this.incoterms = incoterms;
        this.services_included = services_included;
    }

    public Company(ResultSet rs) throws SQLException {
        super(rs);
        container_type = rs.getString("container_type");
        transport = rs.getString("transport");
        load_size = rs.getString("load_size");
        load_type = rs.getString("load_type");
        service_type = rs.getString("service_type");
        service_description = rs.getString("service_description");
        incoterms = rs.getString("incoterms");
        services_included = rs.getString("services_included");
    }

    public String getContainer_type() {
        return container_type;
    }

    public void setContainer_type(String container_type) {
        this.container_type = container_type;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getLoad_size() {
        return load_size;
    }

    public void setLoad_size(String load_size) {
        this.load_size = load_size;
    }

    public String getLoad_type() {
        return load_type;
    }

    public void setLoad_type(String load_type) {
        this.load_type = load_type;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getService_description() {
        return service_description;
    }

    public void setService_description(String service_description) {
        this.service_description = service_description;
    }

    public String getIncoterms() {
        return incoterms;
    }

    public void setIncoterms(String incoterms) {
        this.incoterms = incoterms;
    }

    public String getServices_included() {
        return services_included;
    }

    public void setServices_included(String services_included) {
        this.services_included = services_included;
    }

    public String toString(){
        return getName() + getContainer_type() + getIncoterms();
    }

}
