package com.wmrk.demotracker.entity.geo;


import com.fasterxml.jackson.annotation.JsonView;
import com.wmrk.demotracker.controller.json_view.GeoPointViews;
import com.wmrk.demotracker.controller.json_view.GeoTrackViews;
import com.wmrk.demotracker.customization.Ownable;
import com.wmrk.demotracker.entity.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GeoPoint extends BaseGeoPoint implements Ownable {
    @Id
    @GeneratedValue
    @JsonView({GeoPointViews.Short.class, GeoTrackViews.Short.class})
    private long id;

    @ManyToOne(optional = false)
    @JsonView(GeoPointViews.Full.class)
    private GeoTrack track;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GeoTrack getTrack() {
        return track;
    }

    public void setTrack(GeoTrack track) {
        this.track = track;
    }

    @Override
    public User getOwner() {
        return track.getOwner();
    }
}
