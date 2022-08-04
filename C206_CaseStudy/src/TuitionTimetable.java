
public class TuitionTimetable {
	private String timetableID;
	private double price;
	private String StartDateTime;
	private String EndDateTime;
	
	public TuitionTimetable(String timetableID, double price, String StartDateTime, String EndDateTime, String mode) {
		this.timetableID = timetableID;
		this.price = price;
		this.EndDateTime = EndDateTime;
		this.StartDateTime = StartDateTime;
		this.mode = mode;
	}
	
	private String mode;
	public String getTimetableID() {
		return timetableID;
	}
	public void setTimetableID(String timetableID) {
		this.timetableID = timetableID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStartDateTime() {
		return StartDateTime;
	}
	public void setStartDateTime(String startDateTime) {
		StartDateTime = startDateTime;
	}
	public String getEndDateTime() {
		return EndDateTime;
	}
	public void setEndDateTime(String endDateTime) {
		EndDateTime = endDateTime;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
}