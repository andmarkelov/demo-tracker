package com.wmrk.demotracker.controller.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.wmrk.demotracker.controller.json_view.GeoTrackViews;
import com.wmrk.demotracker.entity.GeoDevice;
import com.wmrk.demotracker.entity.geo.GeoTrack;
import com.wmrk.demotracker.repo.GeoDeviceRepo;
import com.wmrk.demotracker.repo.GeoTrackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/device")
public class GeoDeviceApiController {
    
    private GeoDeviceRepo geoDeviceRepo;
    private GeoTrackRepo geoTrackRepo;

    @Autowired
    public GeoDeviceApiController(GeoDeviceRepo geoDeviceRepo, GeoTrackRepo geoTrackRepo) {
        this.geoDeviceRepo = geoDeviceRepo;
        this.geoTrackRepo = geoTrackRepo;
    }

    @GetMapping("{id}/tracks")
    @JsonView(GeoTrackViews.Short.class)
    @PreAuthorize("#device.owner.name == authentication.name")
    public Iterable<GeoTrack> listTracks(@PathVariable("id") @P("device") GeoDevice device) {
        return geoTrackRepo.findAllByDevice(device);
    }
}
