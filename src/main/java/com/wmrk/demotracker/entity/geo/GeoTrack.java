package com.wmrk.demotracker.entity.geo;

import com.fasterxml.jackson.annotation.JsonView;
import com.wmrk.demotracker.controller.json_view.GeoPointViews;
import com.wmrk.demotracker.controller.json_view.GeoTrackViews;
import com.wmrk.demotracker.customization.Ownable;
import com.wmrk.demotracker.entity.GeoDevice;
import com.wmrk.demotracker.entity.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class GeoTrack implements Ownable {
    @Id
    @GeneratedValue
    @JsonView({GeoTrackViews.Short.class, GeoPointViews.Full.class})
    private long id;
    @JsonView(GeoTrackViews.Short.class)
    private String name;
    @JsonView(GeoTrackViews.Short.class)
    private boolean nameChanged;
    @ManyToOne
    private GeoDevice device;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "track", orphanRemoval = true)
    @JsonView(GeoTrackViews.Full.class)
    @OrderBy("id")
    private List<GeoPoint> points;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNameChanged() {
        return nameChanged;
    }

    public void setNameChanged(boolean nameChanged) {
        this.nameChanged = nameChanged;
    }

    public List<GeoPoint> getPoints() {
        return points;
    }

    public void setPoints(List<GeoPoint> tracks) {
        this.points = tracks;
    }

    public GeoDevice getDevice() {
        return device;
    }

    public void setDevice(GeoDevice device) {
        this.device = device;
    }

    @Override
    public User getOwner() {
        return device.getOwner();
    }
}
