package com.wmrk.demotracker.controller.rest;

import com.wmrk.demotracker.entity.GeoDevice;
import com.wmrk.demotracker.entity.geo.GeoPoint;
import com.wmrk.demotracker.service.DeviceExchangeService;
import com.wmrk.demotracker.util.customization.CurrentDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
    This API is simplified for using by cheap IOT devices,
    so we refused from REST-like specification
    and from Spring Security sessions
    and performing only GET requests
 */
@RestController
@RequestMapping("api/devicex")
public class DeviceExchangeController {
    private DeviceExchangeService deviceExchangeService;

    /*
    Add a position from geo-tracker device
     */
    @GetMapping("push-pos")
    public String pushPosition(@CurrentDevice GeoDevice device, GeoPoint pointDto) {
        if(device == null) {
            return "error: dev not found";
        }

        deviceExchangeService.pushPosition(device, pointDto);

        return "ok";
    }

    @Autowired
    public void setDeviceExchangeService(DeviceExchangeService deviceExchangeService) {
        this.deviceExchangeService = deviceExchangeService;
    }
}
