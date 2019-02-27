package nl.tufa.sensor.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.tufa.sensor.model.Sensor;

public interface SensorRepo  extends JpaRepository<Sensor, Long>{
	
	public Sensor findOneByNodeName(String nodeName);
	
}
