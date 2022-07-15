package com.wmrk.demotracker.repo;

import com.wmrk.demotracker.entity.GeoDevice;
import com.wmrk.demotracker.entity.geo.GeoTrack;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GeoTrackRepo extends CrudRepository<GeoTrack, Long> {
    public List<GeoTrack> findAllByDevice(GeoDevice device);
    public GeoTrack findFirstByDeviceOrderByIdDesc(GeoDevice device);
}
