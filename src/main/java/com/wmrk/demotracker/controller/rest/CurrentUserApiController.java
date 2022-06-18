package com.wmrk.demotracker.controller.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.wmrk.demotracker.controller.json_view.GeoDeviceView;
import com.wmrk.demotracker.customization.CurrentUser;
import com.wmrk.demotracker.entity.GeoDevice;
import com.wmrk.demotracker.repo.GeoDeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/currentUser")
public class CurrentUserApiController {
    @Autowired
    private GeoDeviceRepo geoDeviceRepo;

    @GetMapping("devices")
    @JsonView(GeoDeviceView.Admin.class)
    List<GeoDevice> listDevices(CurrentUser user) {
        return geoDeviceRepo.findAllByOwner(user.get());
    }
}
