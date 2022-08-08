import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		int option = 0;

		while (option != 4) {
			MainMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) { // YeeTeng
				registration();
			} else if (option == 2) { // Faith
				timetable();
			} else if (option == 3) { // Lilianne
				tuition();
			} else if (option == 4) { // Bhavanaa
				StudentMain();
			} else if (option == 5) { // WeiHong

			} else {
				System.out.println("Invalid type");
			}
		}
	}

	private static void registration() {
		// TODO Auto-generated method stub
		ArrayList<registration> registrationList = new ArrayList<registration>();
		registrationList.add(new registration("RE001", 1, "taytay22@gmail.com", "31/07/22 09:00AM", 1101));
		registrationList.add(new registration("RE002", 1, "maryyy@gmail.com", "30/07/22 03:00PM", 1102));

		int option = 0;

		while (option != 4) {
			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// view registration
				viewAllRegistration(registrationList);
			} else if (option == 2) {
				// add registration
				registration re = inputRegistration();
				addRegistration(registrationList, re);
				System.out.println("Registration added!\n");
			} else if (option == 3) {
				// delete registration
				deleteRegistration(registrationList);
			} else if (option == 4) {
				System.out.println("Thank you!");
			}
		}
	}

	public static void MainMenu() {
		System.out.println("1. TUITION TIMETABLE WITH REGISTRATION");
		System.out.println("2. TUITION TIMETABLE INFORMATION");
		System.out.println("3. TUITION INFORMATION");
		System.out.println("4. STUDENT ACCOUNT INFORMATION");
		System.out.println("5. TEACHER INFORMATION");
		System.out.println("6. QUIT");
		Helper.line(80, "-");
	}

	public static void menu() {
		System.out.println("TUITION MANAGEMENT APP");
		System.out.println("1. View registration");
		System.out.println("2. Add registration");
		System.out.println("3. Delete registration");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	public static String retrieveAllRegistration(ArrayList<registration> registrationList) {
		String output = "";

		for (int i = 0; i < registrationList.size(); i++) {

			output += String.format("%-20s %-20d %-20s %-20s %-30s %-30d\n",
					registrationList.get(i).getRegistrationNum(), registrationList.get(i).getTuitionId(),
					registrationList.get(i).getEmail(), registrationList.get(i).getStatus(),
					registrationList.get(i).getDateTime(), registrationList.get(i).getRegistrationId());
		}
		return output;
	}

	public static void viewAllRegistration(ArrayList<registration> registrationList) {
		String output = String.format("%-20s %-20s %-20s %-20s %-30s %-30s\n", "REGISTRATION NUMBER", "TUITION ID",
				"EMAIL", "STATUS", "REGISTRATION DATE/TIME", "REGISTRATION ID");

		for (registration r : registrationList) {
			output += String.format("%-20s %-20d %-20s %-20s %-30s %-30d\n", r.getRegistrationNum(), r.getTuitionId(),
					r.getEmail(), r.getStatus(), r.getDateTime(), r.getRegistrationId());
		}
		System.out.println(output);
	}

	public static void addRegistration(ArrayList<registration> registrationList, registration re) {
		registrationList.add(re);
	}

	public static registration inputRegistration() {
		String registrationNum = Helper.readString("Enter registration number > ");
		int tuitionId = Helper.readInt("Enter tuition timetable id > ");
		String email = Helper.readString("Enter student email > ");
		String dateTime = Helper.readString("Enter registration date/time > ");
		int registrationId = Helper.readInt("Enter registration id > ");

		registration re = new registration(registrationNum, tuitionId, email, dateTime, registrationId);
		return re;
	}

	public static void deleteRegistration(ArrayList<registration> registrationList) {
		C206_CaseStudy.viewAllRegistration(registrationList);
		int registrationId = Helper.readInt("Enter registration id > ");
		Boolean isDeleted = doDeleteRegistration(registrationList, registrationId);

		if (isDeleted == false) {
			System.out.println("Invalid registration ID!");
		} else {
			System.out.println("Registration ID " + registrationId + " deleted!\n");
		}
	}

	public static boolean doDeleteRegistration(ArrayList<registration> registrationList, int registrationId) {
		boolean isDeleted = false;

		for (int i = 0; i < registrationList.size(); i++) {
			if (registrationId == registrationList.get(i).getRegistrationId()) {
				registrationList.remove(i);

				isDeleted = true;
			}
		}
		return isDeleted;

	}

	public static void timetable() {
		ArrayList<TuitionTimetable> TuitionTimetableList = new ArrayList<TuitionTimetable>();

		TuitionTimetableList
				.add(new TuitionTimetable("TT001", 450, "28/10/22 09:00", "28/10/22 10:30", "Face-to-Face"));
		TuitionTimetableList
				.add(new TuitionTimetable("TT002", 550, "29/10/22 09:00", "29/10/22 10:30", "Homebased-Learning"));
		TuitionTimetableList
				.add(new TuitionTimetable("TT003", 550, "30/10/22 09:00", "30/10/22 10:30", "Face-to-Face"));
		int option = 0;

		while (option != 4) {

			menu1();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Add tuition timetable
				TuitionTimetable tt = inputTuitionTimetable();
				addTuitionTimetable(TuitionTimetableList, tt);
				System.out.println("Tuition Timetable Added");

			}

			else if (option == 2) {
				// View tuition timetable
				viewAllTuitionTimetable(TuitionTimetableList);
			}

			else if (option == 3) {
				// Delete tuition timetable
				deleteTuitionTimetable(TuitionTimetableList);
			}

			else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}

	}

// Menu
	public static void menu1() {
		System.out.println("TUITION MANAGEMENT SYSTEM");
		System.out.println("1. Add tuition timetable");
		System.out.println("2. View tuition timetable");
		System.out.println("3. Delete tuition timetable");
		System.out.println("4. Quit");
		Helper.line(120, "-");

	}

// Add Tuition Timetable
	public static TuitionTimetable inputTuitionTimetable() {
		String tuitionTimetableId = Helper.readString("Enter tuition timetable ID > ");
		double price = Helper.readDouble("Enter price > ");
		String StartDateTime = Helper.readString("Enter start date/time > ");
		String EndDateTime = Helper.readString("Enter end date/time > ");
		String mode = Helper.readString("Enter mode > ");

		TuitionTimetable tt = new TuitionTimetable(tuitionTimetableId, price, StartDateTime, EndDateTime, mode);
		return tt;
	}

	public static void addTuitionTimetable(ArrayList<TuitionTimetable> tuitionTimetableList, TuitionTimetable tt) {
		tuitionTimetableList.add(tt);
	}

	public static String retrieveAllTuitionTimetable(ArrayList<TuitionTimetable> TuitionTimetableList) {
		String output = "";
		for (int i = 0; i < TuitionTimetableList.size(); i++) {
			output += String.format("%-30s %-20s %-20s %-20s %-20s\n", TuitionTimetableList.get(i).getTimetableID(),
					TuitionTimetableList.get(i).getPrice(), TuitionTimetableList.get(i).getStartDateTime(),
					TuitionTimetableList.get(i).getEndDateTime(), TuitionTimetableList.get(i).getMode());

		}
		return output;
	}

// View Tuition Timetable
	public static void viewAllTuitionTimetable(ArrayList<TuitionTimetable> TuitionTimetableList) {
		String output = String.format("%-30s %-20s %-20s %-20s %-20s\n", "TUITION TIMETABLE ID", "PRICE",
				"START DATE/TIME", "END DATE/TIME", "MODE");
		output += retrieveAllTuitionTimetable(TuitionTimetableList);
		System.out.println(output);
	}

// Delete Tuition Timetable
	public static void deleteTuitionTimetable(ArrayList<TuitionTimetable> TuitionTimetableList) {
		C206_CaseStudy.viewAllTuitionTimetable(TuitionTimetableList);
		String timetableID = Helper.readString("Enter timetable ID > ");
		Boolean isDeleted = doDeleteTimetable(TuitionTimetableList, timetableID);

		if (isDeleted == false) {
			System.out.println("Invalid tuition timetable ID");
		} else {
			System.out.println("Tuition timetable ID " + timetableID + " deleted");
		}

	}

	public static boolean doDeleteTimetable(ArrayList<TuitionTimetable> TuitionTimetableList, String timetableID) {
		boolean isDeleted = false;
		for (int i = 0; i < TuitionTimetableList.size(); i++) {
			if (timetableID.equals(TuitionTimetableList.get(i).getTimetableID())) {
				TuitionTimetableList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();

	private static void tuition() {
		// TODO Auto-generated method stub

		int option = 0;
		{

			while (option != 4) {
				ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();

				menu2();
				option = Helper.readInt("Enter an option > ");

				if (option == 1) {
					// add tuition
					C206_CaseStudy.setHeader("ADD");
					Tuition ttn = C206_CaseStudy.inputTuition();
					C206_CaseStudy.addTuition(tuitionList, ttn);

				}

				else if (option == 2) {
					// view tuition
					C206_CaseStudy.viewAllTuition(tuitionList);
				}

				else if (option == 3) {
					// delete tuition
					String table = Helper.readString("Enter the tuition timetable id that you want to delete > ");
					C206_CaseStudy.deleteTuition(tuitionList, table);
				}

				else if (option == 4) {
					System.out.println("Bye");
				}

				else {
					System.out.println("Invalid option");
				}

			}

		}

	}

	public static void menu2() {
		System.out.println("Tuition");
		System.out.println("1. Add tuition");
		System.out.println("2. view tuiton");
		System.out.println("3. delete tuition");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

//add tuition
	public static Tuition inputTuition() {
		String tuitioncode = Helper.readString("Enter tuition code > ");
		String tuitiontitle = Helper.readString("Enter title > ");
		String groupname = Helper.readString("Enter subject group name > ");
		String tuitiondescription = Helper.readString("Enter tuition description > ");
		int duration = Helper.readInt("Enter duration > ");
		Boolean prerequisite = Helper.readBoolean("Enter pre-requisite > ");

		Tuition tt = new Tuition(tuitioncode, tuitiontitle, groupname, tuitiondescription, duration, prerequisite);
		return tt;
	}

	public static void addTuition(ArrayList<Tuition> tuitionList, Tuition tt) {
		tuitionList.add(tt);
	}

	// view tuition
	// view tuition
	public static String retrieveAllTuition(ArrayList<Tuition> tuitionList) {
		String output = "";

		for (int i = 0; i < tuitionList.size(); i++) {

			output += String.format("%-20s %-20s %-20s %-20s %-20d %-20s\n", tuitionList.get(i).getTuitioncode(),
					tuitionList.get(i).getTuitiontitle(), tuitionList.get(i).getGroupname(),
					tuitionList.get(i).getTuitiondescription(), tuitionList.get(i).getTuitionduration(),
					tuitionList.get(i).isPrerequisite());
		}
		return output;
	}

	public static void viewAllTuition(ArrayList<Tuition> tuitionList) {
		C206_CaseStudy.setHeader("Tuition LIST");
		String output = String.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "TUITION CODE", "TUITION TITLE",
				"TUITION GROUP NAME", "TUITION DESCRIPTION", "TUITION DURATION", "PRE-REQUISITE");
		output += retrieveAllTuition(tuitionList);
		System.out.println(output);
	}

	private static void setHeader(String string) {

	}

	// delete tuition
	public static boolean deleteTuition(ArrayList<Tuition> tuitionList, String table) {
		boolean doesDelete = false;

		for (int i = 0; i < tuitionList.size(); i++) {
			String tuitioncode = tuitionList.get(i).getTuitioncode();
			if (tuitioncode.contentEquals(table)) {
				tuitionList.remove(tuitionList.get(i));
				System.out.println("Tuition code " + table + " deleted!");
				doesDelete = true;
			}
		}
		if (doesDelete == false) {
			System.out.println("Invalid tuition code.");
		}
		return doesDelete;

	}
	public static void StudentMain() {

		
			ArrayList<Student> studentList = new ArrayList<Student>();

			studentList.add(
					new Student("Jane", "Female", "11111111", "Jane@gmail.com", "09/11/2003", "Singapore", "Swimming"));
			studentList.add(new Student("Tom", "Male", "22222222", "Tom@gmail.com", "24/01/2006", "Singapore", "Hiking"));
			studentList.add(
					new Student("Esther", "Male", "33333333", "Esther@gmail.com", "16/08/2002", "Singapore", "Dancing"));

			int option = 0;

			while (option != 5) {

				StudentMain.menu();
				option = Helper.readInt("Enter an option > ");

				if (option == 1) {
					// View all items
					StudentMain.viewAllStudents(studentList);

				} else if (option == 2) {
					// Register students
					StudentMain.setHeader("REGISTER STUDENT");

					Student s = inputStudent();
					StudentMain.addStudent(studentList, s);
					System.out.println("Student has been successfully added!");

				} else if (option == 3) {
					// delete Student
					StudentMain.deleteStudent(studentList);
				} else if (option == 4) {
					System.out.println("Thank you for using tuition app!");
				} else {
					System.out.println("Invalid option entered!");
				}

			}
		}

		public static void menuu() {
			StudentMain.setHeader("TUITION APP");
			System.out.println("1. View All Students");
			System.out.println("2. Register Student");
			System.out.println("3. Delete Student");
			System.out.println("4. Quit");
			Helper.line(80, "-");
		}

		public static void setHeaderr(String header) {
			Helper.line(80, "-");
			System.out.println(header);
			Helper.line(80, "-");

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

		public static String retrieveAllStudents(ArrayList<Student> studentList) {
			String output = "";

			for (int i = 0; i < studentList.size(); i++) {
				output += String.format("%-10s %-10s %-15s %-23s %-23s %-26s %-10s\n", studentList.get(i).getName(),
						studentList.get(i).getGender(), studentList.get(i).getMobile(), studentList.get(i).getEmail(),
						studentList.get(i).getDOB(), studentList.get(i).getCOR(), studentList.get(i).getInterest());
			}
			return output;
		}

		public static void viewAllStudents(ArrayList<Student> studentList) {
			StudentMain.setHeader("LIST OF STUDENTS");
			String output = String.format("%-10s %-11s %-18s %-18s %-20s %-30s %-10s\n", "NAME", "GENDER", "MOBILE",
					"EMAIL", "DATE OF BIRTH", "COUNTRY OF RESIDENCE", "INTEREST");
			output += retrieveAllStudents(studentList);
			System.out.println(output);
		}

		public static Student inputStudent() {
			String name = Helper.readString("Enter name of student > ");
			String gender = Helper.readString("Enter gender of student > ");
			String mobile = Helper.readString("Enter mobile number of student > ");
			String email = Helper.readString("Enter email of student > ");
			String dob = Helper.readString("Enter date of birth of student > ");
			String cor = Helper.readString("Enter country of origin of student > ");
			String interest = Helper.readString("Enter interest of student > ");

			Student s = new Student(name, gender, mobile, email, dob, cor, interest);
			return s;

		}

		public static void addStudent(ArrayList<Student> studentList, Student cc) {

			studentList.add(cc);
		}

		public static void deleteStudent(ArrayList<Student> studentList) {
			StudentMain.viewAllStudents(studentList);
			String name = Helper.readString("Enter name of student > ");
			Boolean isDeleted = doDeleteStudent(studentList, name);

			if (isDeleted == false) {
				System.out.println("Invalid entry! Student does not exist");
			} else {
				System.out.println("Student " + name + " is deleted!");
			}

		}

		public static boolean doDeleteStudent(ArrayList<Student> studentList, String name) {
			boolean isDeleted = false;

			for (int i = 0; i < studentList.size(); i++) {
				if (name.toUpperCase().equals(studentList.get(i).getName().toUpperCase())) {
					studentList.remove(i);

					isDeleted = true;

				}
			}
			return isDeleted;
		}
	

}
