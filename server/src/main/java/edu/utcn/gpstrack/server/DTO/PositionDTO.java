package edu.utcn.gpstrack.server.DTO;

import edu.utcn.gpstrack.server.entity.User;

import java.time.LocalDateTime;

public class PositionDTO {

    private Integer id;

    private String terminalId;

    private String latitude;

    private String longitude;

    private LocalDateTime creationDate;

    private User user;

    public PositionDTO(Integer id, String terminalId, String latitude, String longitude, LocalDateTime creationDate, User user) {
        this.id = id;
        this.terminalId = terminalId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.creationDate = creationDate;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
