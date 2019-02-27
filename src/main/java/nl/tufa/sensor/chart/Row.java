package nl.tufa.sensor.chart;

import java.util.ArrayList;
import java.util.List;

public class Row {
	
	private List<Cell> c;
	
	public Row() {
		super();
		c = new ArrayList<Cell>();
	}
	
	public Row(List<Cell> cells) {
		super();
		this.c = cells;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c == null) ? 0 : c.hashCode());
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
		Row other = (Row) obj;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Row [c=" + c + "]";
	}

	public List<Cell> getC() {
		return c;
	}

	public void setC(List<Cell> cells) {
		this.c = cells;
	}
	
	public void addCell(Cell<?> cell) {
		this.c.add(cell);
	}
	
	public void removeCell(Cell<?> cell) {
		this.c.remove(cell);
	}
	
}
