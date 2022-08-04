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

			} else if (option == 4) { // Bhavana

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
}
