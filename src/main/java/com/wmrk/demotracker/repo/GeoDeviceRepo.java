package com.wmrk.demotracker.repo;

import com.wmrk.demotracker.entity.GeoDevice;
import com.wmrk.demotracker.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.sound.midi.Track;
import java.util.List;


public interface GeoDeviceRepo extends CrudRepository<GeoDevice, Long> {
    public List<GeoDevice> findAllByOwner(User owner);
    public GeoDevice findByGuidIgnoreCase(String guid);
}
