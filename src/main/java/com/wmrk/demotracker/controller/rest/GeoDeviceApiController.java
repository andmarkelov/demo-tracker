package com.wmrk.demotracker.controller.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.wmrk.demotracker.controller.json_view.GeoTrackViews;
import com.wmrk.demotracker.entity.GeoDevice;
import com.wmrk.demotracker.entity.geo.GeoTrack;
import com.wmrk.demotracker.repo.GeoDeviceRepo;
import com.wmrk.demotracker.repo.GeoTrackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/device")
public class GeoDeviceApiController {
    @Autowired
    private GeoDeviceRepo geoDeviceRepo;
    @Autowired
    private GeoTrackRepo geoTrackRepo;

    @GetMapping("{id}/tracks")
    @JsonView(GeoTrackViews.Short.class)
    public Iterable<GeoTrack> listTracks(@PathVariable("id") GeoDevice device) {
        return geoTrackRepo.findAllByDevice(device);
    }

}
