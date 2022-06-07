package com.wmrk.demotracker.entity.geo;

import com.fasterxml.jackson.annotation.JsonView;
import com.wmrk.demotracker.controller.json_view.GeoPointViews;
import com.wmrk.demotracker.controller.json_view.GeoTrackViews;

import javax.persistence.*;
import java.util.List;

@Entity
public class GeoTrack {
    @Id
    @GeneratedValue
    @JsonView({GeoTrackViews.Short.class, GeoPointViews.Full.class})
    private long id;
    @JsonView(GeoTrackViews.Short.class)
    private String name;
    @JsonView(GeoTrackViews.Short.class)
    private boolean nameChanged;

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
    
}
