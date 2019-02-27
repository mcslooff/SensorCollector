package nl.tufa.sensor.chart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nl.tufa.sensor.model.BME680Reading;

public class ChartData {

	private List<Col> cols;
	private List<Row> rows;

	public ChartData() {
		super();
		cols = new ArrayList<Col>();
		rows = new ArrayList<Row>();
	}

	public ChartData(List<Col> cols, List<Row> rows) {
		super();
		this.cols = cols;
		this.rows = rows;
	}
	
	public ChartData(List<BME680Reading> rawData, String variable) {
		super();
		cols = new ArrayList<Col>();
		rows = new ArrayList<Row>();
		
		cols.add(new Col("timestamp", "Time", "datetime"));
		
		if("temperature".compareTo(variable)==0) {
			cols.add(new Col("temperature", "temperature", "number"));
		} else if("humidity".compareTo(variable)==0) {
			cols.add(new Col("humidity", "humidity", "number"));
		} else if("pressure".compareTo(variable)==0) {
			cols.add(new Col("airPressure", "Air pressure", "number"));
		} else if("voc".compareTo(variable)==0) {
			cols.add(new Col("voc", "VOC", "number"));
		}
		
		for(BME680Reading r : rawData) {
			List<Cell> cells = new ArrayList<Cell>();
			cells.add(
					new Cell<String>(
							"Date(" + r.getTimestamp()*1000 + ")", 
							null, 
							null)
					);

			if("temperature".compareTo(variable)==0) {
				cells.add(new Cell<Double>(r.getTemperature(), null, null));
			} else if("humidity".compareTo(variable)==0) {
				cells.add(new Cell<Double>(r.getHumidity(), null, null));
			} else if("pressure".compareTo(variable)==0) {
				cells.add(new Cell<Double>(r.getAirpressure(), null, null));
			} else if("voc".compareTo(variable)==0) {
				cells.add(new Cell<Double>(r.getVoc(), null, null));
			}
			
			rows.add(new Row(cells));
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cols == null) ? 0 : cols.hashCode());
		result = prime * result + ((rows == null) ? 0 : rows.hashCode());
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
		ChartData other = (ChartData) obj;
		if (cols == null) {
			if (other.cols != null)
				return false;
		} else if (!cols.equals(other.cols))
			return false;
		if (rows == null) {
			if (other.rows != null)
				return false;
		} else if (!rows.equals(other.rows))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChartData [cols=" + cols + ", rows=" + rows + "]";
	}

	public List<Col> getCols() {
		return cols;
	}

	public void setCols(List<Col> cols) {
		this.cols = cols;
	}

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

}
