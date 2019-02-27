package nl.tufa.sensor.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.tufa.sensor.model.SensorStatus;

public interface SensorStatusRepo  extends JpaRepository<SensorStatus, Long>{
	
}
