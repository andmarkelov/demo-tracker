package com.wmrk.demotracker.repo;

import com.wmrk.demotracker.entity.GeoDevice;
import com.wmrk.demotracker.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface GeoDeviceRepo extends CrudRepository<GeoDevice, Long> {
    public List<GeoDevice> findAllByOwner(User owner);
}
