package nl.tufa.sensor.chart;

public class Cell<T> {
	
	private T v;
	private String f;
	private String p;
	
	public Cell(T value, String label, String properties) {
		super();
		this.v = value;
		this.f = label;
		this.p = properties;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((f == null) ? 0 : f.hashCode());
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		result = prime * result + ((v == null) ? 0 : v.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (f == null) {
			if (other.f != null)
				return false;
		} else if (!f.equals(other.f))
			return false;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cell [value=" + v + ", label=" + f + ", properties=" + p + "]";
	}

	public T getV() {
		return v;
	}

	public void setV(T value) {
		this.v = value;
	}

	public String getF() {
		return f;
	}

	public void setF(String label) {
		this.f = label;
	}

	public String getP() {
		return p;
	}

	public void setP(String properties) {
		this.p = properties;
	}
	
	
}
