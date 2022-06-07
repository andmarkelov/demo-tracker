package com.wmrk.demotracker.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class GeoDevice {
    @Id
    private String guid;
    private String name;
    @ManyToOne
    private User owner;


}
