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
	
	public C206_CaseStudyTest() {
		super();
	}


	@Before
	public void setUp() throws Exception {
		re1 = new registration("RE001", 1, "taytay22@gmail.com", "31/07/22 09:00AM", 1101);
		re2 = new registration("RE002", 1, "maryyy@gmail.com", "30/07/22 03:00PM", 1102);
		
		registrationList= new ArrayList<registration>();

	}

	@After
	public void tearDown() throws Exception {
		re1 = null;
		re2 = null;
		registrationList = null;
	}

	@Test
//	public void c206_test() {
//		//fail("Not yet implemented"); 
//		assertTrue("C206_CaseStudy_SampleTest ",true);
		
	public void testAddRegistration() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid registration arraylist to add to", registrationList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		registrationMain.addRegistration(registrationList, re1);
		assertEquals("Test if that registration arraylist size is 1?", 1, registrationList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that registration is added same as 1st item of the list?", re1, registrationList.get(0));

		// Add another item. test The size of the list is 2?
		registrationMain.addRegistration(registrationList, re1);
		registrationMain.addRegistration(registrationList, re2);
		assertEquals("Test that registration arraylist size is 3?", 3, registrationList.size());
	}

	@Test
	public void testRetrieveAllRegistration() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid registration arraylist to add to", registrationList);

		// test if the list of registrations retrieved from the registrationMain is empty
		String allRegistrations= registrationMain.retrieveAllRegistration(registrationList);
		String testOutput = "";
		assertEquals("Check that ViewAllRegistrations", testOutput, allRegistrations);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		registrationMain.addRegistration(registrationList, re1);
		registrationMain.addRegistration(registrationList, re2);
		assertEquals("Test if that registration arraylist size is 2?", 2, registrationList.size());
		
		//test if the expected output string same as the list of registrations retrieved from the registrationMain
		allRegistrations= registrationMain.retrieveAllRegistration(registrationList);

		testOutput = String.format("%-20s %-20s %-20s %-20s %-30s %-30s\n", "RE001", 1, "taytay22@gmail.com", "Pending", "31/07/22 09:00AM", 1101);
		testOutput += String.format("%-20s %-20s %-20s %-20s %-30s %-30s\n", "RE002", 1, "maryyy@gmail.com", "Pending", "30/07/22 03:00PM", 1102);
		
		assertEquals("Check that retriveAllRegistrations", testOutput, allRegistrations);	
	}
	
	@Test
	public void testDeleteRegistration() {
		assertNotNull("Test if there is valid registration arraylist to delete from", registrationList);
		registrationMain.addRegistration(registrationList, re1);
		registrationMain.addRegistration(registrationList, re2);
		
		// Delete another item. The size of the list is 1?
		registrationMain.deleteRegistration(registrationList);
		assertEquals("Test that registration arraylist size is 1", 1, registrationList.size());


		// Delete another item. The size of the list is 0?
		registrationMain.deleteRegistration(registrationList);
		assertEquals("Test that registration arraylist size is 0", 0, registrationList.size());

	}

}
