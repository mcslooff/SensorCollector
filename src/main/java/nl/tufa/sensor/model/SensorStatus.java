package nl.tufa.sensor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class SensorStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long timestamp;
	@JsonProperty("version")
	private String version;
	@JsonProperty("stationName")
	private String stationName;
	@JsonProperty("accessPointIP")
	private String accessPointIP;
	@JsonProperty("stationIP")
	private String stationIP;
	@JsonProperty("powerVoltage")
	private double powerVoltage;
	@JsonProperty("systemTime")
	private long systemTime;
	@JsonProperty("upTime")
	private long upTime;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getStationName() {
		return stationName;
	}
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	public String getAccessPointIP() {
		return accessPointIP;
	}
	
	public void setAccessPointIP(String accessPointIP) {
		this.accessPointIP = accessPointIP;
	}
	
	public String getStationIP() {
		return stationIP;
	}
	
	public void setStationIP(String stationIP) {
		this.stationIP = stationIP;
	}
	
	public double getPowerVoltage() {
		return powerVoltage;
	}
	
	public void setPowerVoltage(double powerVoltage) {
		this.powerVoltage = powerVoltage;
	}
	
	public long getSystemTime() {
		return systemTime;
	}
	
	public void setSystemTime(long systemTime) {
		this.systemTime = systemTime;
	}
	
	public long getUpTime() {
		return upTime;
	}
	
	public void setUpTime(long upTime) {
		this.upTime = upTime;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessPointIP == null) ? 0 : accessPointIP.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		long temp;
		temp = Double.doubleToLongBits(powerVoltage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((stationIP == null) ? 0 : stationIP.hashCode());
		result = prime * result + ((stationName == null) ? 0 : stationName.hashCode());
		result = prime * result + (int) (systemTime ^ (systemTime >>> 32));
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		result = prime * result + (int) (upTime ^ (upTime >>> 32));
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		SensorStatus other = (SensorStatus) obj;
		if (accessPointIP == null) {
			if (other.accessPointIP != null)
				return false;
		} else if (!accessPointIP.equals(other.accessPointIP))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(powerVoltage) != Double.doubleToLongBits(other.powerVoltage))
			return false;
		if (stationIP == null) {
			if (other.stationIP != null)
				return false;
		} else if (!stationIP.equals(other.stationIP))
			return false;
		if (stationName == null) {
			if (other.stationName != null)
				return false;
		} else if (!stationName.equals(other.stationName))
			return false;
		if (systemTime != other.systemTime)
			return false;
		if (timestamp != other.timestamp)
			return false;
		if (upTime != other.upTime)
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SensorStatus [id=" + id + ", timestamp=" + timestamp + ", version=" + version + ", stationName="
				+ stationName + ", accessPointIP=" + accessPointIP + ", stationIP=" + stationIP + ", powerVoltage="
				+ powerVoltage + ", systemTime=" + systemTime + ", upTime=" + upTime + "]";
	}
	
	
}
