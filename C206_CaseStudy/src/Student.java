
public class Student {

	public String name;
	public String gender;
	public String mobile;
	public String email;
	public String DOB;
	public String COR;
	public String interest;
	private boolean isAvailable;

	public Student(String name, String gender, String mobile, String email, String dOB, String cOR, String interest) {
		super();
		this.name = name;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		DOB = dOB;
		COR = cOR;
		this.interest = interest;
	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public boolean getIsAvailable() {
		return getIsAvailable();
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getDOB() {
		return DOB;
	}

	public String getCOR() {
		return COR;
	}

	public String getInterest() {
		return interest;
	}

}
