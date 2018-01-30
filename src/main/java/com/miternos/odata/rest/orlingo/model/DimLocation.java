package com.miternos.odata.rest.orlingo.model;

import org.apache.olingo.odata2.api.annotation.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.annotation.edm.EdmEntityType;
import org.apache.olingo.odata2.api.annotation.edm.EdmKey;
import org.apache.olingo.odata2.api.annotation.edm.EdmProperty;

@EdmEntityType(namespace = "MyFormula")
@EdmEntitySet(name = "DimLocation")
public class DimLocation {

    @EdmKey
    @EdmProperty
    private String LocationId;

    @EdmProperty
    private String Location;

    @EdmProperty
    private String LocationLevel1;

    @EdmProperty
    private String LocationLevel2;

    @EdmProperty
    private String LocationLevel3;

    @EdmProperty
    private String LocationLevel4;

    @EdmProperty
    private String LocationLevel5;

    @EdmProperty
    private String LocationLevel6;

    @EdmProperty
    private String DeviceNetworkId;

    public String getLocationId() {
        return LocationId;
    }

    public void setLocationId(String locationId) {
        this.LocationId = locationId;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }

    public String getLocationLevel1() {
        return LocationLevel1;
    }

    public void setLocationLevel1(String locationLevel1) {
        this.LocationLevel1 = locationLevel1;
    }

    public String getLocationLevel2() {
        return LocationLevel2;
    }

    public void setLocationLevel2(String locationLevel2) {
        this.LocationLevel2 = locationLevel2;
    }

    public String getLocationLevel3() {
        return LocationLevel3;
    }

    public void setLocationLevel3(String locationLevel3) {
        this.LocationLevel3 = locationLevel3;
    }

    public String getLocationLevel4() {
        return LocationLevel4;
    }

    public void setLocationLevel4(String locationLevel4) {
        this.LocationLevel4 = locationLevel4;
    }

    public String getLocationLevel5() {
        return LocationLevel5;
    }

    public void setLocationLevel5(String locationLevel5) {
        this.LocationLevel5 = locationLevel5;
    }

    public String getLocationLevel6() {
        return LocationLevel6;
    }

    public void setLocationLevel6(String locationLevel6) {
        this.LocationLevel6 = locationLevel6;
    }

    public String getDeviceNetworkId() {
        return DeviceNetworkId;
    }

    public void setDeviceNetworkId(String deviceNetworkId) {
        this.DeviceNetworkId = deviceNetworkId;
    }
}
