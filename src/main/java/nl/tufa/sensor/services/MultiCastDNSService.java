package nl.tufa.sensor.services;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.tufa.sensor.model.Sensor;
import nl.tufa.sensor.repos.SensorRepo;

@Service
public class MultiCastDNSService {
	
	@Autowired
	private SensorRepo sensorRepo;
	
	private JmDNS jmdns = null;
	
	private Logger logger = Logger.getLogger("nl.tufa.sensor.SensorImpl");
	
	public MultiCastDNSService() {
		
		// Create a JmDNS instance
		try {
			jmdns = JmDNS.create(InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			logger.error("UnknownHostException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		}

	}
	
	@SuppressWarnings("deprecation")
	public List<Sensor> scan() {
		
		List<Sensor> result = new ArrayList<Sensor>();
		ServiceInfo[] serviceList = jmdns.list("_bme680._tcp.local.");
		
		for(int i=0; i<serviceList.length; i++) {
			logger.debug("Service resolved: " + serviceList[i]);
			Sensor sensor = sensorRepo.findOneByNodeName(serviceList[i].getName());
			
			if (sensor == null) {
				logger.debug("Found new node, addiing it to the database.");
				sensor = new Sensor();
				sensor.setNodeName(serviceList[i].getName());
				sensor.setSensorType(serviceList[i].getType());
				sensor.setActiveSensor(false);
			}
			
			sensor.setIpAddress(serviceList[i].getHostAddress());
			sensor.setMeasurementURL(serviceList[i].getPropertyString("path"));
			sensor.setStatusURL(serviceList[i].getPropertyString("statusURL"));
			sensor.setConfigurationURL(serviceList[i].getPropertyString("configurationURL"));
			sensor.setPort(serviceList[i].getPort());
			
			result.add(sensor);
			
			sensorRepo.save(sensor);
		}
		
		return result;
		
	}
	
	@SuppressWarnings("unused")
	private class MultiCastDNSListener implements ServiceListener {

		public void serviceAdded(ServiceEvent event) {
			logger.debug("Service added: " + event.getInfo());
			Sensor sensor = sensorRepo.findOneByNodeName(event.getName());
			if (sensor == null) {
				logger.debug("Found new node, addiing it to the database.");
				sensor = new Sensor();
				sensor.setNodeName(event.getName());
				sensor.setSensorType(event.getType());
				sensor.setActiveSensor(false);
				sensorRepo.save(sensor);
			}
		}

		public void serviceRemoved(ServiceEvent event) {
			logger.debug("Service removed: " + event.getInfo());
		}

		@SuppressWarnings("deprecation")
		public void serviceResolved(ServiceEvent event) {

			logger.info("Service resolved: " + event.getInfo());
			Sensor sensor = sensorRepo.findOneByNodeName(event.getName());
			sensor.setIpAddress(event.getInfo().getHostAddress());
			sensor.setMeasurementURL(event.getInfo().getPropertyString("path"));
			sensor.setStatusURL(event.getInfo().getPropertyString("statusURL"));
			sensor.setConfigurationURL(event.getInfo().getPropertyString("configurationURL"));
			sensor.setPort(event.getInfo().getPort());

			sensorRepo.save(sensor);
		}

	}
	
}
