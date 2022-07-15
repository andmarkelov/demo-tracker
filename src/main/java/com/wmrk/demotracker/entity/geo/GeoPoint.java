package com.wmrk.demotracker.entity.geo;


import com.fasterxml.jackson.annotation.JsonView;
import com.wmrk.demotracker.controller.json_view.GeoPointViews;
import com.wmrk.demotracker.controller.json_view.GeoTrackViews;
import com.wmrk.demotracker.util.customization.Ownable;
import com.wmrk.demotracker.entity.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GeoPoint extends BaseGeoPoint implements Ownable {
    @Id
    @GeneratedValue
    @JsonView({GeoPointViews.Short.class, GeoTrackViews.Short.class})
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView(GeoPointViews.Full.class)
    private GeoTrack track;

    private Date saveDate;
    private Date trackDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GeoTrack getTrack() {
        return track;
    }

    public void setTrack(GeoTrack track) {
        this.track = track;
    }

    public Date getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(Date saveDate) {
        this.saveDate = saveDate;
    }

    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    @Override
    public User getOwner() {
        return track.getOwner();
    }


}
