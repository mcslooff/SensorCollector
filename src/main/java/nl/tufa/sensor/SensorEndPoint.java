package nl.tufa.sensor;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import nl.tufa.sensor.chart.ChartData;
import nl.tufa.sensor.chart.GaugeData;
import nl.tufa.sensor.model.BME680Reading;
import nl.tufa.sensor.model.GenericReply;
import nl.tufa.sensor.model.Sensor;
import nl.tufa.sensor.model.SensorStatus;
import nl.tufa.sensor.repos.BME680ReadingRepo;
import nl.tufa.sensor.repos.SensorRepo;
import nl.tufa.sensor.repos.SensorStatusRepo;

@RestController
@SpringBootApplication
public class SensorEndPoint {

	@Autowired
	BME680ReadingRepo reading;

	@Autowired
	SensorStatusRepo sensorStatusRepo;

	@Autowired
	private SensorRepo sensorRepo;
	
	private Logger logger = Logger.getLogger("nl.tufa.sensor.SensorImpl");
	
	@PostMapping("/sensor")
	public GenericReply sensor( @RequestBody BME680Reading sensorData) {
		GenericReply reply = null;
		
		Sensor sensor = sensorRepo.findOneByNodeName(sensorData.getStationName());
		
		if(sensor!=null && sensor.getActiveSensor()) {
			reading.save(sensorData);
			sensor.setLastMeasurement(sensorData.getId());
			sensorRepo.save(sensor);
			logger.debug("Adding measurement: " + sensorData);
			reply = new GenericReply(0, "Success");
		} else {
			logger.debug("Measurement ignored. Sensor is unknown or marked as ignore.");
			reply = new GenericReply(10, "Inactive of unknown sensor. Measurement ignored.");
		}
		return reply;
	}

	@GetMapping("/data")
	public List<BME680Reading> getData() {

		List<BME680Reading> result = reading
				.findByTimestampGreaterThanOrderByTimestampAsc((System.currentTimeMillis() / 1000) - 1);

		for (BME680Reading r : result) {
			logger.debug(r);
		}

		return result;
	}

	@GetMapping("/data/chart/{variable}")
	public ChartData getChartData(@PathVariable("variable") String variable,
			@RequestParam(value = "period", required = false) Long period,
			@RequestParam(value = "endAt", required = false) Long endAt) {

		if (period == null || period < 0) {
			period = (long) 1800;
		}

		if (endAt == null) {
			endAt = System.currentTimeMillis();
		}

		List<BME680Reading> result = reading
				.findByTimestampGreaterThanOrderByTimestampAsc(endAt / 1000 + 3600 - period);

		ChartData chart = new ChartData(result, variable);

		return chart;
	}

	@GetMapping("/data/gauge/{variable}")
	public GaugeData getGaugeData(@PathVariable("variable") String variable) {
		return new GaugeData();
	}
	
	@Scheduled(fixedRate = 300000)
	public void getNodeStatus() {
		RestTemplate restTemplate = new RestTemplate();

		List<Sensor> sensors = sensorRepo.findAll();

		for (Sensor sensor : sensors) {
			if (sensor.getActiveSensor()) {
				String resourceUrl = "http://" + sensor.getIpAddress() + ":" + sensor.getPort() + sensor.getStatusURL();
				try {
					SensorStatus sensorStatus = restTemplate.getForObject(resourceUrl, SensorStatus.class);
					sensorStatus.setTimestamp(System.currentTimeMillis());
					sensor.setOnline(true);
					sensorStatusRepo.save(sensorStatus);
					logger.info("Sensor " + sensor.getNodeName() + " is online: " + sensorStatus);
				} catch (Exception e) {
					sensor.setOnline(false);
					logger.info("Sensor " + sensor.getNodeName() + " is offline.");
				}
				sensorRepo.save(sensor);
			}
		}

	}

}
