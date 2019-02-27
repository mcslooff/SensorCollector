package nl.tufa.sensor.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class BME680Reading {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@JsonProperty("stationName")
	private String stationName;
	@JsonProperty("timestamp")
	private long timestamp;
	@JsonProperty("temperature")
	private double temperature;
	@JsonProperty("humidity")
	private double humidity;
	@JsonProperty("airpressure")
	private double airpressure;
	@JsonProperty("voc")
	private double voc;
	@JsonProperty("resultCode")
	private long resultCode;
	@JsonProperty("resultText")
	private String resultText;
	
	@Override
	public String toString() {
		return "BME680Reading [id=" + id + ", stationName=" + stationName + ", timestamp=" + new Date(timestamp*1000)
				+ ", temperature=" + temperature + ", humidity=" + humidity + ", airpressure=" + airpressure + ", voc="
				+ voc + ", resultCode=" + resultCode + ", resultText=" + resultText + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(airpressure);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(humidity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (resultCode ^ (resultCode >>> 32));
		result = prime * result + ((resultText == null) ? 0 : resultText.hashCode());
		result = prime * result + ((stationName == null) ? 0 : stationName.hashCode());
		temp = Double.doubleToLongBits(temperature);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		temp = Double.doubleToLongBits(voc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		BME680Reading other = (BME680Reading) obj;
		if (Double.doubleToLongBits(airpressure) != Double.doubleToLongBits(other.airpressure))
			return false;
		if (Double.doubleToLongBits(humidity) != Double.doubleToLongBits(other.humidity))
			return false;
		if (id != other.id)
			return false;
		if (resultCode != other.resultCode)
			return false;
		if (resultText == null) {
			if (other.resultText != null)
				return false;
		} else if (!resultText.equals(other.resultText))
			return false;
		if (stationName == null) {
			if (other.stationName != null)
				return false;
		} else if (!stationName.equals(other.stationName))
			return false;
		if (Double.doubleToLongBits(temperature) != Double.doubleToLongBits(other.temperature))
			return false;
		if (timestamp != other.timestamp)
			return false;
		if (Double.doubleToLongBits(voc) != Double.doubleToLongBits(other.voc))
			return false;
		return true;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getAirpressure() {
		return airpressure;
	}

	public void setAirpressure(double airpressure) {
		this.airpressure = airpressure;
	}

	public double getVoc() {
		return voc;
	}

	public void setVoc(double voc) {
		this.voc = voc;
	}

	public long getResultCode() {
		return resultCode;
	}

	public void setResultCode(long resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultText() {
		return resultText;
	}

	public void setResultText(String resultText) {
		this.resultText = resultText;
	}

	public long getId() {
		return id;
	}

	
}
