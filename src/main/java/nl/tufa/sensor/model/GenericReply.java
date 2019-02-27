package nl.tufa.sensor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericReply {
	
	@JsonProperty("resultCode")
	private long resutCode;
	@JsonProperty("resultText")
	private String resultTest;
	
	public GenericReply(long resutCode, String resultTest) {
		super();
		this.resutCode = resutCode;
		this.resultTest = resultTest;
	}

	@Override
	public String toString() {
		return "GenericReply [resutCode=" + resutCode + ", resultTest=" + resultTest + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resultTest == null) ? 0 : resultTest.hashCode());
		result = prime * result + (int) (resutCode ^ (resutCode >>> 32));
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
		GenericReply other = (GenericReply) obj;
		if (resultTest == null) {
			if (other.resultTest != null)
				return false;
		} else if (!resultTest.equals(other.resultTest))
			return false;
		if (resutCode != other.resutCode)
			return false;
		return true;
	}
	
}
