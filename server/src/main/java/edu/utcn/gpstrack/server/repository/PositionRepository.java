package edu.utcn.gpstrack.server.repository;


import edu.utcn.gpstrack.server.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Radu Miron
 * @version 1
 */
public interface PositionRepository extends JpaRepository<Position, Integer> {
    Position getPositionByTerminalId(String terminalId);
}
