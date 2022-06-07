package com.wmrk.demotracker.serializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wmrk.demotracker.entity.geo.GeoTrack;

@JsonSerialize(using = GeoJsonTrackSerializer.class)
public class GeoJsonEntity {
    GeoTrack track;

    public GeoJsonEntity(GeoTrack track) {
        this.track = track;
    }

    public GeoTrack getTrack() {
        return track;
    }
}
