package com.wmrk.demotracker.repo;

import com.wmrk.demotracker.entity.GeoDevice;
import com.wmrk.demotracker.entity.geo.GeoTrack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

import java.util.List;

public interface GeoTrackRepo extends CrudRepository<GeoTrack, Long> {
    List<GeoTrack> findAllByDevice(GeoDevice device);
}
