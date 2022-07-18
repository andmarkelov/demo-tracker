package com.wmrk.demotracker.service;

import com.wmrk.demotracker.entity.GeoDevice;
import com.wmrk.demotracker.repo.GeoDeviceRepo;
import com.wmrk.demotracker.repo.GeoTrackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeoDeviceService {
    private GeoDeviceRepo geoDeviceRepo;
    private GeoTrackRepo geoTrackRepo;

    @Autowired
    public GeoDeviceService(GeoDeviceRepo geoDeviceRepo, GeoTrackRepo geoTrackRepo) {
        this.geoDeviceRepo = geoDeviceRepo;
        this.geoTrackRepo = geoTrackRepo;
    }

    @Transactional
    public void eraseTracks(GeoDevice device) {
        geoTrackRepo.deleteGeoTracksByDevice(device);
    }
}
