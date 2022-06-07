package com.wmrk.demotracker.repo;

import com.wmrk.demotracker.entity.geo.GeoTrack;
import org.springframework.data.repository.CrudRepository;

public interface GeoTrackRepo extends CrudRepository<GeoTrack, Long> {
}
