package com.wmrk.demotracker.controller.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.wmrk.demotracker.controller.json_view.GeoTrackViews;
import com.wmrk.demotracker.entity.GeoDevice;
import com.wmrk.demotracker.entity.User;
import com.wmrk.demotracker.entity.geo.GeoTrack;
import com.wmrk.demotracker.repo.GeoDeviceRepo;
import com.wmrk.demotracker.repo.GeoTrackRepo;
import com.wmrk.demotracker.util.customization.CurrentUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/device")
@PreAuthorize("#owned == null || hasRole('ROLE_ADMIN') || #owned.owner.name == authentication.name")
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
    public Iterable<GeoTrack> listTracks(@PathVariable("id") @P("owned") GeoDevice device) {
        return geoTrackRepo.findAllByDevice(device);
    }

    @DeleteMapping("{id}")
    public GeoDevice delete(@PathVariable("id") @P("owned") GeoDevice device) {
        geoDeviceRepo.delete(device);
        return device;
    }

    @PostMapping
    public GeoDevice create(@RequestBody GeoDevice newDevice, @CurrentUser User cu) {
        newDevice.setId(0);
        newDevice.setOwner(cu);
        geoDeviceRepo.save(newDevice);
        return newDevice;
    }

    @PutMapping("{id}")
    public GeoDevice update(
            @PathVariable("id") @P("owned") GeoDevice curDevice,
            @RequestBody GeoDevice newDevice
    ) {
        BeanUtils.copyProperties(newDevice, curDevice, "id", "owner");
        geoDeviceRepo.save(curDevice);
        return curDevice;
    }
}
