package nl.tufa.sensor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sensor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique=true)
	private String nodeName;
	private String sensorType;
	private String ipAddress;
	private String configuration;
	private Boolean activeSensor = true;
	private String statusURL;
	private String measurementURL;
	private String configurationURL;
	private String username;
	private String password;
	private int port;
	private long pollInterval = 0;	// Polling interval in seconds.
	private Boolean online;
	private String location;
	private String comments;
	private Long lastMeasurement;
	
	public String getNodeName() {
		return nodeName;
	}
	
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	public String getIpAddress() {
		return ipAddress;
	}
	
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public String getConfiguration() {
		return configuration;
	}
	
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	
	public Boolean getActiveSensor() {
		return activeSensor;
	}
	
	public void setActiveSensor(Boolean activeSensor) {
		this.activeSensor = activeSensor;
	}
	
	public long getId() {
		return id;
	}
	
	public String getSensorType() {
		return sensorType;
	}
	
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	
	public String getStatusURL() {
		return statusURL;
	}
	
	public void setStatusURL(String statusURL) {
		this.statusURL = statusURL;
	}
	
	public String getMeasurementURL() {
		return measurementURL;
	}
	
	public void setMeasurementURL(String measurementURL) {
		this.measurementURL = measurementURL;
	}
	
	public String getConfigurationURL() {
		return configurationURL;
	}
	
	public void setConfigurationURL(String configurationURL) {
		this.configurationURL = configurationURL;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nodeName == null) ? 0 : nodeName.hashCode());
		result = prime * result + ((sensorType == null) ? 0 : sensorType.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sensor other = (Sensor) obj;
		if (id != other.id)
			return false;
		if (nodeName == null) {
			if (other.nodeName != null)
				return false;
		} else if (!nodeName.equals(other.nodeName))
			return false;
		if (sensorType == null) {
			if (other.sensorType != null)
				return false;
		} else if (!sensorType.equals(other.sensorType))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Sensor [id=" + id + ", nodeName=" + nodeName + ", sensorType=" + sensorType + ", ipAddress=" + ipAddress
				+ ", activeSensor=" + activeSensor + ", statusURL=" + statusURL + ", measurementURL=" + measurementURL
				+ ", configurationURL=" + configurationURL + "]";
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public long getPollInterval() {
		return pollInterval;
	}
	
	public void setPollInterval(long pollInterval) {
		this.pollInterval = pollInterval;
	}
	
	public Boolean getStatus() {
		return online;
	}
	
	public Boolean isOnline() {
		return online;
	}
	
	public void setOnline(Boolean online) {
		this.online = online;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getLastMeasurement() {
		return lastMeasurement;
	}

	public void setLastMeasurement(Long lastMeasurement) {
		this.lastMeasurement = lastMeasurement;
	}

	public Boolean getOnline() {
		return online;
	}
	
}
