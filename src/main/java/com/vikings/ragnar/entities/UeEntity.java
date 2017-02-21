package com.vikings.ragnar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by carlmccann2 on 19/02/2017.
 */
@Entity
@Table(name="UE")
public class UeEntity implements Serializable {

    @Id @Column(name="TAC")             private Integer tac;
    @Column(name="Marketing_Name")      private String marketingName;
    @Column(name="Manufacturer")        private String manufacturer;
    @Column(name="Access_Capability")   private String accessCapability;
    @Column(name="Model")               private String model;
    @Column(name="Vendor_Name")         private String vendorName;
    @Column(name="UE_Type")             private String ueType;
    @Column(name="OS")                  private String os;
    @Column(name="Input_Mode")          private String inputMode;

    public UeEntity(Integer tac, String marketingName, String manufacturer, String accessCapability, String model, String vendorName, String ueType, String os, String inputMode) {
        this.tac = tac;
        this.marketingName = marketingName;
        this.manufacturer = manufacturer;
        this.accessCapability = accessCapability;
        this.model = model;
        this.vendorName = vendorName;
        this.ueType = ueType;
        this.os = os;
        this.inputMode = inputMode;
    }

    public UeEntity() {

    }

    public Integer getTac() {
        return tac;
    }

    public void setTac(Integer tac) {
        this.tac = tac;
    }

    public String getMarketingName() {
        return marketingName;
    }

    public void setMarketingName(String marketingName) {
        this.marketingName = marketingName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getAccessCapability() {
        return accessCapability;
    }

    public void setAccessCapability(String accessCapability) {
        this.accessCapability = accessCapability;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getUeType() {
        return ueType;
    }

    public void setUeType(String ueType) {
        this.ueType = ueType;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getInputMode() {
        return inputMode;
    }

    public void setInputMode(String inputMode) {
        this.inputMode = inputMode;
    }
}
