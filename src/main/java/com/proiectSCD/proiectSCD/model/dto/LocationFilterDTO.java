package com.proiectSCD.proiectSCD.model.dto;

import java.util.Date;

public class LocationFilterDTO {
    Long userId;

    Date startDate;

    Date endDate;

    public LocationFilterDTO() {
    }

    public LocationFilterDTO(Long userId) {
        this.userId = userId;
    }

    public LocationFilterDTO(Long userId, Date startDate, Date endDate) {
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
