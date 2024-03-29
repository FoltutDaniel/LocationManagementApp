package edu.utcn.gpstrack.server.repository;

import edu.utcn.gpstrack.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
