package edu.utcn.gpstrack.server.DTO.user;


import edu.utcn.gpstrack.server.DTO.position.PositionDTO;

import java.util.List;

public class UserDTO {

    private Integer id;

    private String username;

    private String password;

    private String role;

    private List<PositionDTO> positions;

    public UserDTO() {
    }

    public UserDTO(Integer id, String username, String password, String role, List<PositionDTO> positions) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.positions = positions;
    }

    public UserDTO(Integer id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<PositionDTO> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionDTO> positions) {
        this.positions = positions;
    }
}
