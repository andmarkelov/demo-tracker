package com.wmrk.demotracker.controller.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.wmrk.demotracker.controller.json_view.GeoPointViews;
import com.wmrk.demotracker.controller.json_view.GeoTrackViews;
import com.wmrk.demotracker.entity.GeoDevice;
import com.wmrk.demotracker.entity.geo.GeoPoint;
import com.wmrk.demotracker.entity.geo.GeoTrack;
import com.wmrk.demotracker.repo.GeoTrackRepo;
import com.wmrk.demotracker.serializer.GeoJsonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/track")
@CrossOrigin(origins = "*")
public class GeoTrackApiController {
    @Autowired
    private GeoTrackRepo geoTrackRepo;
    
    @GetMapping
    @JsonView(GeoTrackViews.Short.class)
    public Iterable<GeoTrack> getList() {
        return geoTrackRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(GeoTrackViews.Full.class)
    public GeoTrack get(@PathVariable("id") GeoTrack geoTrack) {
        return geoTrack;
    }

    @GetMapping("{track_id}/point")
    @JsonView(GeoPointViews.Short.class)
    public Iterable<GeoPoint> getPoints(@PathVariable("track_id") GeoTrack geoTrack) {
        return geoTrack.getPoints();
    }

    @GetMapping(value = "{track_id}/geoJson")
    public GeoJsonEntity getGeoJson(@PathVariable("track_id") GeoTrack geoTrack) {
        return new GeoJsonEntity(geoTrack);
    }


}
