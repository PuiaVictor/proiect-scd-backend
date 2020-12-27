package com.proiectSCD.proiectSCD.model.dto;

import java.util.Date;

public class CreateLocationDTO {
    private String latitude;
    private String longitude;
    private Date date;
    private String email;

    public CreateLocationDTO(String latitude, String longitude, String email) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = new Date();
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
