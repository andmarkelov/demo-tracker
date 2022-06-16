package com.wmrk.demotracker.controller.rest;

import com.wmrk.demotracker.repo.GeoDeviceRepo;
import com.wmrk.demotracker.repo.GeoPointRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/device")
public class GeoDeviceApiController {
    @Autowired
    private GeoDeviceRepo geoDeviceRepo;


}
