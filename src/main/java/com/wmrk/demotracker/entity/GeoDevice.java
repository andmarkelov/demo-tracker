package com.wmrk.demotracker.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.wmrk.demotracker.controller.json_view.GeoDeviceView;
import com.wmrk.demotracker.customization.Ownable;

import javax.persistence.*;

@Entity
public class GeoDevice implements Ownable {
    @Id
    @GeneratedValue
    @JsonView(GeoDeviceView.User.class)
    long id;
    @Column(unique = true)
    @JsonView(GeoDeviceView.Admin.class)
    private String guid;
    @JsonView(GeoDeviceView.User.class)
    private String name;
    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
    @JsonView(GeoDeviceView.Admin.class)
    private User owner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
