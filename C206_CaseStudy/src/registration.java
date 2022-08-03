
public class registration {
	
	private String registrationNum;
	private int tuitionId;
	private String email;
	private String status;
	private String dateTime;
	private int registrationId;
	
	public registration(String registrationNum, int tuitionId, String email, String dateTime,int registrationId) {
		this.registrationNum = registrationNum;
		this.tuitionId = tuitionId;
		this.email = email;
		this.status = "Pending";
		this.dateTime = dateTime;
		this.registrationId = registrationId;
	}

	public String getRegistrationNum() {
		return registrationNum;
	}

	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}

	public int getTuitionId() {
		return tuitionId;
	}

	public void setTuitionId(int tuitionId) {
		this.tuitionId = tuitionId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	
	
	
	

}
