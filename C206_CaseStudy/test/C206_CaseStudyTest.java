import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	// Prepare test data
	private registration re1;
	private registration re2;

	private ArrayList<registration> registrationList;
	
	private Student s1;
	private Student s2;
	private Student s3;

	private ArrayList<Student> studentList;

	private TuitionTimetable tt1;
	private TuitionTimetable tt2;
	private TuitionTimetable tt3;

	private ArrayList<TuitionTimetable> TuitionTimetableList;

	private ArrayList<Tuition> tuitionList;
	private Tuition tt4;
	private Tuition tt5;
	private Tuition tt6;
	private Tuition tt7;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		re1 = new registration("RE001", 1, "taytay22@gmail.com", "31/07/22 09:00AM", 1101);
		re2 = new registration("RE002", 1, "maryyy@gmail.com", "30/07/22 03:00PM", 1102);

		registrationList = new ArrayList<registration>();

		tt1 = new TuitionTimetable("TT001", 450, "28/10/22 09:00", "28/10/22 10:30", "Face-to-Face");
		tt2 = new TuitionTimetable("TT002", 550, "29/10/22 09:00", "29/10/22 10:30", "Homebased-Learning");
		tt3 = new TuitionTimetable("TT003", 550, "30/10/22 09:00", "30/10/22 10:30", "Face-to-Face");

		TuitionTimetableList = new ArrayList<TuitionTimetable>();

		tt4 = new Tuition("tt2100", "math", "math", "matrix", 120, true);
		tt5 = new Tuition("tt2200", "geography", "humanities", "climate change", 60, true);
		tt6 = new Tuition("tt2300", "history", "humanities", "world war 2", 120, true);
		tt7 = new Tuition("tt2400", "english", "language", "grammer", 90, true);

		tuitionList = new ArrayList<Tuition>();
	}
	
	@Before
	public void setUp1() throws Exception {
		s1 = new Student("Timmy", "Male", "44444444", "Timmy@gmail.com", "14/02/1999", "Singapore", "Cycling");
		s2 = new Student("Tammy", "Male", "55555555", "Tammy@gmail.com", "27/05/2001", "Singapore", "Diving");
		// s3 = new Student("Sammy", "Male", "66666666", "Sammy@gmail.com",
		// "06/04/2007", "Singapore", "Kayaking");

		studentList = new ArrayList<Student>();
	}


	@After
	public void tearDown() throws Exception {
		re1 = null;
		re2 = null;
		registrationList = null;
		tt1 = null;
		tt2 = null;
		tt3 = null;
		TuitionTimetableList = null;
	}

	@Test
//	public void c206_test() {
//		//fail("Not yet implemented"); 
//		assertTrue("C206_CaseStudy_SampleTest ",true);

	public void testAddRegistration() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid registration arraylist to add to", registrationList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addRegistration(registrationList, re1);
		assertEquals("Test if that registration arraylist size is 1?", 1, registrationList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that registration is added same as 1st item of the list?", re1, registrationList.get(0));

		// Add another item. test The size of the list is 2?
		C206_CaseStudy.addRegistration(registrationList, re1);
		C206_CaseStudy.addRegistration(registrationList, re2);
		assertEquals("Test that registration arraylist size is 3?", 3, registrationList.size());
	}

	@Test
	public void testRetrieveAllRegistration() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid registration arraylist to add to", registrationList);

		// test if the list of registrations retrieved from the registrationMain is
		// empty
		String allRegistrations = C206_CaseStudy.retrieveAllRegistration(registrationList);
		String testOutput = "";
		assertEquals("Check that ViewAllRegistrations", testOutput, allRegistrations);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addRegistration(registrationList, re1);
		C206_CaseStudy.addRegistration(registrationList, re2);
		assertEquals("Test if that registration arraylist size is 2?", 2, registrationList.size());

		// test if the expected output string same as the list of registrations
		// retrieved from the registrationMain
		allRegistrations = C206_CaseStudy.retrieveAllRegistration(registrationList);

		testOutput = String.format("%-20s %-20s %-20s %-20s %-30s %-30s\n", "RE001", 1, "taytay22@gmail.com", "Pending",
				"31/07/22 09:00AM", 1101);
		testOutput += String.format("%-20s %-20s %-20s %-20s %-30s %-30s\n", "RE002", 1, "maryyy@gmail.com", "Pending",
				"30/07/22 03:00PM", 1102);

		assertEquals("Check that retriveAllRegistrations", testOutput, allRegistrations);
	}

	@Test
	public void testDeleteRegistration() {
		assertNotNull("Test if there is valid registration arraylist to delete from", registrationList);
		C206_CaseStudy.addRegistration(registrationList, re1);
		C206_CaseStudy.addRegistration(registrationList, re2);

		// Delete another item. The size of the list is 1?
		C206_CaseStudy.deleteRegistration(registrationList);
		assertEquals("Test that registration arraylist size is 1", 1, registrationList.size());

		// Delete another item. The size of the list is 0?
		C206_CaseStudy.deleteRegistration(registrationList);
		assertEquals("Test that registration arraylist size is 0", 0, registrationList.size());

	}

	@Test
	public void testaddTuitionTimetable() {
		// fail("Not yet implemented");
		// write your code here
		// TuitionTimetable list is not null, so that can add a new TuitionTimetable
		assertNotNull("Test if there is valid tuition timetable arraylist to add to", TuitionTimetableList);

		// Given an empty list, after adding 1 TuitionTimetable, the size of the list is
		// 1
		C206_CaseStudy.addTuitionTimetable(TuitionTimetableList, tt1);
		assertEquals("Test if that TuitionTimetable arraylist size is 1?", 1, TuitionTimetableList.size());

		// The TuitionTimetable just added is as same as the first item of the list
		assertSame("Test that TuitionTimetable is added same as 1st item of the list?", tt1,
				TuitionTimetableList.get(0));

		// Add another TuitionTimetable. test The size of the list is 3?
		C206_CaseStudy.addTuitionTimetable(TuitionTimetableList, tt2);
		C206_CaseStudy.addTuitionTimetable(TuitionTimetableList, tt3);
		assertEquals("Test that TuitionTimetable arraylist size is 3?", 3, TuitionTimetableList.size());
	}

	@Test
	public void testretrieveAllTuitionTimetable() {
		// Test if TuitionTimetable list is not null but empty, so that can add a new
		// TuitionTimetable
		assertNotNull("Test if there is valid TuitionTimetable arraylist to add to", TuitionTimetableList);

		// test if the list of TuitionTimetable retrieved from the SourceCentre is empty
		String allTuitionTimetable = C206_CaseStudy.retrieveAllTuitionTimetable(TuitionTimetableList);
		String testOutput = "";
		assertEquals("Check that ViewAllTimetableList", testOutput, allTuitionTimetable);

		// Given an empty list, after adding 2 items, test if the size of the list is 3
		C206_CaseStudy.addTuitionTimetable(TuitionTimetableList, tt1);
		C206_CaseStudy.addTuitionTimetable(TuitionTimetableList, tt2);
		C206_CaseStudy.addTuitionTimetable(TuitionTimetableList, tt3);
		assertEquals("Test if that TuitionTimetable arraylist size is 3?", 3, TuitionTimetableList.size());

		// test if the expected output string same as the list of TuitionTimetable
		// retrieved from the SourceCentre
		allTuitionTimetable = C206_CaseStudy.retrieveAllTuitionTimetable(TuitionTimetableList);

		testOutput = String.format("%-30s %-20s %-20s %-20s %-20s\n", "TT001", 450.0, "28/10/22 09:00",
				"28/10/22 10:30", "Face-to-Face");
		testOutput += String.format("%-30s %-20s %-20s %-20s %-20s\n", "TT002", 550.0, "29/10/22 09:00",
				"29/10/22 10:30", "Homebased-Learning");
		testOutput += String.format("%-30s %-20s %-20s %-20s %-20s\n", "TT003", 550.0, "30/10/22 09:00",
				"30/10/22 10:30", "Face-to-Face");

		assertEquals("Check that ViewAllTimetableList", testOutput, allTuitionTimetable);

	}

	@Test
	public void testdeleteTuitionTimetable() {
		// fail("Not yet implemented");
		// write your code here
		// Can add new items
		assertNotNull("Test if there is valid tuition timetable arraylist to delete from", TuitionTimetableList);
		C206_CaseStudy.addTuitionTimetable(TuitionTimetableList, tt2);
		C206_CaseStudy.addTuitionTimetable(TuitionTimetableList, tt3);
		C206_CaseStudy.addTuitionTimetable(TuitionTimetableList, tt1);

		// Delete another item. The size of the list is 2?
		C206_CaseStudy.deleteTuitionTimetable(TuitionTimetableList);
		assertEquals("Test that TuitionTimetable arraylist size is 2?", 2, TuitionTimetableList.size());

		// Delete another item. The size of the list is 1?
		C206_CaseStudy.deleteTuitionTimetable(TuitionTimetableList);
		assertEquals("Test if that TuitionTimetable arraylist size is 1?", 1, TuitionTimetableList.size());

		// Delete another item. The size of the list is 0?
		C206_CaseStudy.deleteTuitionTimetable(TuitionTimetableList);
		assertEquals("Test if that TuitionTimetable arraylist size is 0?", 0, TuitionTimetableList.size());
	}

	// by lilianne tan
	// add tuition
	@Test
	public void testAddTuition1() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid tuition arraylist to add to", tuitionList);
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addTuition(tuitionList, tt4);
		assertEquals("Check that Tuition arraylist size is 1", 1, tuitionList.size());
		assertSame("Check that Tuition is added", tt4, tuitionList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addTuition(tuitionList, tt5);
		assertEquals("Check that Tuition arraylist size is 2", 2, tuitionList.size());
		assertSame("Check that Tuition is added", tt5, tuitionList.get(1));

	}

	// by lilianne tan
	@Test
	public void testRetrieveAllTuition() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Tuition arraylist to retrieve item", tuitionList);

		// test if the list of tuition retrieved from the SourceCentre is empty -
		// boundary
		String allTuition = C206_CaseStudy.retrieveAllTuition(tuitionList);
		String testOutput = "";
		assertEquals("Check that ViewAlltuitionlist", testOutput, allTuition);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addTuition(tuitionList, tt4);
		C206_CaseStudy.addTuition(tuitionList, tt5);
		assertEquals("Test that Tuition arraylist size is 2", 2, tuitionList.size());

		// test if the expected output string same as the list of tuition retrieved from
		// the SourceCentre
		allTuition = C206_CaseStudy.retrieveAllTuition(tuitionList);
		testOutput = String.format("%-20s %-20s %-20s %-20s %-20d %-20s\n", "tt2100", "math", "math", "matrix", 120,
				true);
		testOutput += String.format("%-20s %-20s %-20s %-20s %-20d %-20s\n", "tt2200", "geography", "humanities",
				"climate change", 60, true);

		assertEquals("Test that ViewAllTuitionlist", testOutput, allTuition);

	}

	// by lilianne tan
	// delete tuition
	@Test
	public void testdeletetuition() {
		// boundary - Test if Item list is not null but empty
		assertNotNull("Test if there is valid Tuition arraylist to delete", tuitionList);
		// Normal - tuition with id "tt2100" is deleted
		C206_CaseStudy.addTuition(tuitionList, tt4);
		Boolean isdeleted = C206_CaseStudy.deleteTuition(tuitionList, "tt2100");
		assertTrue(isdeleted);

		// Error - Test that non-existing item cannot be delete
		isdeleted = C206_CaseStudy.deleteTuition(tuitionList, "tt9999");
		assertFalse(isdeleted);
	}

	//bhavvv
	@Test
	public void testRegStudent() {
		// fail("Not yet implemented");
		assertNotNull("Test if there is a valid Student arraylist to add to", studentList);
		StudentMain.addStudent(studentList, s1);
		// test that after s1 is added the arraylist consists of s1
		assertEquals("Test if the Student arrayList size is 1?", s1, studentList.get(0));
		// test that after adding s2 size of arraylist is 2
		StudentMain.addStudent(studentList, s2);
		StudentMain.addStudent(studentList, s3);
		assertEquals("Test that Chromebook arraylist size is 3?", 3, studentList.size());
		assertSame("Test that Chromebook is added same as 3rd item of the list?", s3, studentList.get(2));
	}

	@Test
	public void testDoDeleteStudent() {
		// boundary
		assertNotNull("test if there is valid Student arraylist to delete from", studentList);
		StudentMain.addStudent(studentList, s1);
		StudentMain.addStudent(studentList, s2);
		// StudentMain.addStudent(studentList, s3);

		// delete another item. The size of list is 1?
		StudentMain.doDeleteStudent(studentList, "Timmy");
		assertEquals("Test that student arraylist size is 1", 1, studentList.size());

		// normal
		StudentMain.doDeleteStudent(studentList, "Tammy");
		assertEquals("Test that student arraylist size is 0", 0, studentList.size());

	}

	@After
	public void tearDown1() throws Exception {
		s1 = null;
		s2 = null;
		// s3 = null;
		studentList = null;
	}

}
