package nl.tufa.sensor;

import java.io.IOException;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import nl.tufa.sensor.services.MultiCastDNSService;

@SpringBootApplication(scanBasePackages={"nl.tufa.sensor"})
@EnableScheduling
public class SensorApp {

	@Autowired
	MultiCastDNSService mDNSService;
	
	private Logger logger = Logger.getLogger("nl.tufa.sensor.SensorImpl");
	
	public static void main(String[] args) throws UnknownHostException, IOException {

		SpringApplication.run(SensorApp.class, args);

	}

	@Scheduled(fixedRate = 300000)
	public void scanServices() {
		logger.info("Scanning for services...");
		mDNSService.scan();
	}

}
