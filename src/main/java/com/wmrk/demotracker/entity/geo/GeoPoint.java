package com.wmrk.demotracker.entity.geo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GeoPoint {
    @Id
    @GeneratedValue
    private long id;
    private float lat;
    private float lon;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float longitude) {
        this.lon = longitude;
    }
}
