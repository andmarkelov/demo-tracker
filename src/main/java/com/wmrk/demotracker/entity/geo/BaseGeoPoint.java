package com.wmrk.demotracker.entity.geo;


import com.fasterxml.jackson.annotation.JsonView;
import com.wmrk.demotracker.controller.json_view.GeoPointViews;
import com.wmrk.demotracker.controller.json_view.GeoTrackViews;

import javax.persistence.MappedSuperclass;

/**
 * Position format: <a href="https://epsg.io/3857">EPSG:3857</a> (in meters)
 *
 */
@MappedSuperclass
public class BaseGeoPoint {
    @JsonView({GeoPointViews.Short.class, GeoTrackViews.Full.class})
    private double lat;
    @JsonView({GeoPointViews.Short.class, GeoTrackViews.Full.class})
    private double lon;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double longitude) {
        this.lon = longitude;
    }
}
