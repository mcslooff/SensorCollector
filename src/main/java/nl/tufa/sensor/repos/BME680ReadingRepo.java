package nl.tufa.sensor.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.tufa.sensor.model.BME680Reading;

public interface BME680ReadingRepo  extends JpaRepository<BME680Reading, Long>{
	
	List<BME680Reading> findByTimestampGreaterThanOrderByTimestampAsc(Long timestamp);
	
}
