package com.wmrk.demotracker.repo;

import com.wmrk.demotracker.entity.geo.GeoPoint;
import org.springframework.data.repository.CrudRepository;

public interface GeoPointRepo extends CrudRepository<GeoPoint, Long> {


}
