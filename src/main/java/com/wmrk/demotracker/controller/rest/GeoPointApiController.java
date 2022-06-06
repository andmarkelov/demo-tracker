package com.wmrk.demotracker.controller.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.wmrk.demotracker.controller.json_view.GeoPointViews;
import com.wmrk.demotracker.entity.geo.GeoPoint;
import com.wmrk.demotracker.repo.GeoPointRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/point")
public class GeoPointApiController {
    @Autowired
    private GeoPointRepo geoPointRepo;

    @GetMapping
    @JsonView(GeoPointViews.Short.class)
    public Iterable<GeoPoint> getList() {
        return geoPointRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(GeoPointViews.Full.class)
    public GeoPoint get(@PathVariable("id") GeoPoint geoPoint) {
        return geoPoint;
    }

    @PostMapping
    @JsonView(GeoPointViews.Short.class)
    public GeoPoint create(@RequestBody GeoPoint geoPoint) {
        return geoPointRepo.save(geoPoint);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") GeoPoint geoPoint){
        geoPointRepo.delete(geoPoint);
    }



}
