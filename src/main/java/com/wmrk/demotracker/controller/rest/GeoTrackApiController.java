package com.wmrk.demotracker.controller.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.wmrk.demotracker.controller.json_view.GeoPointViews;
import com.wmrk.demotracker.controller.json_view.GeoTrackViews;
import com.wmrk.demotracker.entity.geo.GeoPoint;
import com.wmrk.demotracker.entity.geo.GeoTrack;
import com.wmrk.demotracker.repo.GeoTrackRepo;
import com.wmrk.demotracker.util.serializer.GeoJsonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/track")
@PreAuthorize("#owned == null || #owned.owner.name == authentication.name")
public class GeoTrackApiController {

    private GeoTrackRepo geoTrackRepo;

    @Autowired
    public GeoTrackApiController(GeoTrackRepo geoTrackRepo) {
        this.geoTrackRepo = geoTrackRepo;
    }

    @GetMapping("{id}")
    @JsonView(GeoTrackViews.Full.class)
    public GeoTrack get(@PathVariable("id") @P("owned") GeoTrack geoTrack) {
        return geoTrack;
    }

    @GetMapping("{track_id}/point")
    @JsonView(GeoPointViews.Short.class)
    public Iterable<GeoPoint> getPoints(@PathVariable("track_id") @P("owned") GeoTrack geoTrack) {
        return geoTrack.getPoints();
    }

    @GetMapping(value = "{track_id}/geoJson")
    public GeoJsonEntity getGeoJson(@PathVariable("track_id") @P("owned") GeoTrack geoTrack) {
        return new GeoJsonEntity(geoTrack);
    }

}
