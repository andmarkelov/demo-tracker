package com.wmrk.demotracker.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.wmrk.demotracker.controller.json_view.GeoDeviceView;

import javax.persistence.*;

@Entity
public class GeoDevice {
    @Id
    @GeneratedValue
    @JsonView(GeoDeviceView.User.class)
    int id;
    @Column(unique = true)
    @JsonView(GeoDeviceView.Admin.class)
    private String guid;
    @JsonView(GeoDeviceView.User.class)
    private String name;
    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
    @JsonView(GeoDeviceView.Admin.class)
    private User owner;


}
