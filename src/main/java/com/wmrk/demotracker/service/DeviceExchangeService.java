package com.wmrk.demotracker.service;

import com.wmrk.demotracker.entity.GeoDevice;
import com.wmrk.demotracker.entity.geo.GeoPoint;
import com.wmrk.demotracker.entity.geo.GeoTrack;
import com.wmrk.demotracker.repo.GeoPointRepo;
import com.wmrk.demotracker.repo.GeoTrackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;

@Service
public class DeviceExchangeService {
    private static final String TRACK_DEFAULT_NAME_PREFIX = "Track";

    private GeoTrackRepo geoTrackRepo;
    private GeoPointRepo geoPointRepo;

    @Transactional
    public void pushPosition(GeoDevice device, GeoPoint point) {
        GeoTrack track = geoTrackRepo.findFirstByDeviceOrderByIdDesc(device);
        
        if(track == null) {
            track = new GeoTrack();
            track.setDevice(device);
            track.setName(TRACK_DEFAULT_NAME_PREFIX + " 1");
            track.setPoints(Collections.singletonList(point));
            geoTrackRepo.save(track);
        } else {
            track.getPoints().add(point);
        }

        //point.setId(0L);
        point.setSaveDate(new Date());
        point.setTrack(track);
        geoPointRepo.save(point);
    }

    @Autowired
    public void setGeoTrackRepo(GeoTrackRepo geoTrackRepo) {
        this.geoTrackRepo = geoTrackRepo;
    }

    @Autowired
    public void setGeoPointRepo(GeoPointRepo geoPointRepo) {
        this.geoPointRepo = geoPointRepo;
    }
}
