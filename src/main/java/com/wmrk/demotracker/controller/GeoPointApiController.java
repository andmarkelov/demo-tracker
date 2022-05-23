package com.wmrk.demotracker.controller;

import com.wmrk.demotracker.entity.geo.GeoPoint;
import com.wmrk.demotracker.repo.GeoPointRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/geo")
public class GeoPointApiController {
    @Autowired
    private GeoPointRepo geoPointRepo;

    @GetMapping
    public Iterable<GeoPoint> getList() {
        return geoPointRepo.findAll();
    }

    @GetMapping("{id}")
    public GeoPoint get(@PathVariable("id") GeoPoint geoPoint) {
        return geoPoint;
    }

    @PostMapping
    public GeoPoint create(@RequestBody GeoPoint geoPoint) {
        return geoPointRepo.save(geoPoint);
    }
    

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") GeoPoint geoPoint){
        geoPointRepo.delete(geoPoint);
    }

}
