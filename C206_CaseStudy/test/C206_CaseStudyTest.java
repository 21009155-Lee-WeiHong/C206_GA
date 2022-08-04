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

	private TuitionTimetable tt1;
	private TuitionTimetable tt2;
	private TuitionTimetable tt3;

	private ArrayList<TuitionTimetable> TuitionTimetableList;

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

	public void testaddTuitionTimetable() {
		// fail("Not yet implemented");
		// write your code here
		// TuitionTimetable list is not null, so that can add a new TuitionTimetable
		assertNotNull("Test if there is valid tuition timetable arraylist to add to", TuitionTimetableList);

		// Given an empty list, after adding 1 TuitionTimetable, the size of the list is
		// 1
		TuitionTimetableMain.addTuitionTimetable(TuitionTimetableList, tt1);
		assertEquals("Test if that TuitionTimetable arraylist size is 1?", 1, TuitionTimetableList.size());

		// The TuitionTimetable just added is as same as the first item of the list
		assertSame("Test that TuitionTimetable is added same as 1st item of the list?", tt1,
				TuitionTimetableList.get(0));

		// Add another TuitionTimetable. test The size of the list is 3?
		TuitionTimetableMain.addTuitionTimetable(TuitionTimetableList, tt2);
		TuitionTimetableMain.addTuitionTimetable(TuitionTimetableList, tt3);
		assertEquals("Test that TuitionTimetable arraylist size is 3?", 3, TuitionTimetableList.size());
	}

	@Test
	public void testretrieveAllTuitionTimetable() {
		// Test if TuitionTimetable list is not null but empty, so that can add a new
		// TuitionTimetable
		assertNotNull("Test if there is valid TuitionTimetable arraylist to add to", TuitionTimetableList);

		// test if the list of TuitionTimetable retrieved from the SourceCentre is empty
		String allTuitionTimetable = TuitionTimetableMain.retrieveAllTuitionTimetable(TuitionTimetableList);
		String testOutput = "";
		assertEquals("Check that ViewAllTimetableList", testOutput, allTuitionTimetable);

		// Given an empty list, after adding 2 items, test if the size of the list is 3
		TuitionTimetableMain.addTuitionTimetable(TuitionTimetableList, tt1);
		TuitionTimetableMain.addTuitionTimetable(TuitionTimetableList, tt2);
		TuitionTimetableMain.addTuitionTimetable(TuitionTimetableList, tt3);
		assertEquals("Test if that TuitionTimetable arraylist size is 3?", 3, TuitionTimetableList.size());

		// test if the expected output string same as the list of TuitionTimetable
		// retrieved from the SourceCentre
		allTuitionTimetable = TuitionTimetableMain.retrieveAllTuitionTimetable(TuitionTimetableList);

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
		TuitionTimetableMain.addTuitionTimetable(TuitionTimetableList, tt2);
		TuitionTimetableMain.addTuitionTimetable(TuitionTimetableList, tt3);
		TuitionTimetableMain.addTuitionTimetable(TuitionTimetableList, tt1);

		// Delete another item. The size of the list is 2?
		TuitionTimetableMain.deleteTuitionTimetable(TuitionTimetableList);
		assertEquals("Test that TuitionTimetable arraylist size is 2?", 2, TuitionTimetableList.size());

		// Delete another item. The size of the list is 1?
		TuitionTimetableMain.deleteTuitionTimetable(TuitionTimetableList);
		assertEquals("Test if that TuitionTimetable arraylist size is 1?", 1, TuitionTimetableList.size());

		// Delete another item. The size of the list is 0?
		TuitionTimetableMain.deleteTuitionTimetable(TuitionTimetableList);
		assertEquals("Test if that TuitionTimetable arraylist size is 0?", 0, TuitionTimetableList.size());
	}

}
