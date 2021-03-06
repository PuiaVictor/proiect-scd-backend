package com.proiectSCD.proiectSCD.dal.model.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="location")
public class UserLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String latitude;

    @NotNull
    private String longitude;

    @NotNull
    private Date date;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;

    public UserLocation() {
    }

    public UserLocation(String latitude, String longitude, Date date, UserEntity user) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.user = user;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
