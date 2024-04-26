/**
 * @author Mandy Wiedmier - mwiedmier2
 * CIS175 - Spring 2024
 * Apr 24, 2024
 */
package dmacc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import dmacc.beans.AssignmentTimeMethods;
import dmacc.beans.Course;
/**
 * 
 */
public class AssignmentTimeTests {
	//Tests for the AssignmentTimeMethods class
	
	//Constructor Test
	/**
	 * Test for a working constructor (valid Credit Hours, Weekly Points, and Assignment Points)
	 */
	@Test
	void workingConstructorTest() {
		Course testCourse = new Course("CIS175", "Java II", 3, "Louis Schanus", 98.5);
		AssignmentTimeMethods AssignmentClass = new AssignmentTimeMethods(testCourse, 10, 10);
		
		assertEquals(AssignmentClass.getWeeklyPoints(), 10);
		assertEquals(AssignmentClass.getAssignmentPoints(), 10);
		assertEquals(AssignmentClass.getCreditHours(), 3);
	}
	
	//Weekly points tests
	/**
	 * Test for valid weekly points
	 */
	@Test
	void validWeeklyPointsTest() {
		AssignmentTimeMethods AssignmentClass = new AssignmentTimeMethods();
		assertDoesNotThrow(() -> AssignmentClass.setWeeklyPoints(0));
	}
	
	/**
	 * Test for an invalid weekly points
	 */
	@Test
	void invalidWeeklyPointsTest() {
		AssignmentTimeMethods AssignmentClass = new AssignmentTimeMethods();
		assertThrows(IllegalArgumentException.class, () -> AssignmentClass.setWeeklyPoints(-1));
	}
	
	//Assignment Points Tests
	/**
	 * Test for valid assignment points
	 */
	@Test
	void validAssignmentPointsTest() {
		AssignmentTimeMethods AssignmentClass = new AssignmentTimeMethods();
		assertDoesNotThrow(() -> AssignmentClass.setAssignmentPoints(0));
	}
	
	/**
	 * Test for an invalid assignment points
	 */
	@Test
	void invalidAssignmentPointsTest() {
		AssignmentTimeMethods AssignmentClass = new AssignmentTimeMethods();
		assertThrows(IllegalArgumentException.class, () -> AssignmentClass.setAssignmentPoints(-1));
	}
	
	//Course Credit Tests
	/**
	 * Test for lowest valid credits
	 */
	@Test
	void validLowCreditsTest() {
		AssignmentTimeMethods AssignmentClass = new AssignmentTimeMethods();
		assertDoesNotThrow(() -> AssignmentClass.setCreditHours(1));
	}
	
	/**
	 * Test for highest valid credits
	 */
	@Test
	void validHighCreditsTest() {
		AssignmentTimeMethods AssignmentClass = new AssignmentTimeMethods();
		assertDoesNotThrow(() -> AssignmentClass.setCreditHours(5));
	}
	
	/**
	 * Test for too low credits
	 */
	@Test
	void tooLowCreditsTest() {
		AssignmentTimeMethods AssignmentClass = new AssignmentTimeMethods();
		assertThrows(IllegalArgumentException.class, () -> AssignmentClass.setCreditHours(0));
	}
	
	/**
	 * Test for too high credits
	 */
	@Test
	void tooHighCreditsTest() {
		AssignmentTimeMethods AssignmentClass = new AssignmentTimeMethods();
		assertThrows(IllegalArgumentException.class, () -> AssignmentClass.setCreditHours(6));
	}
	
	//Helper Method Tests
	//Study Hours Tests
	/**
	 * Test getting study hours (lowest possible)
	 */
	@Test
	void lowestStudyHoursTest() {
		assertEquals(AssignmentTimeMethods.getStudyHours(1), 2);
	}
	
	/**
	 * Test getting study hours (highest possible)
	 */
	@Test
	void highestStudyHoursTest() {
		assertEquals(AssignmentTimeMethods.getStudyHours(5), 10);
	}
	
	//Assignment Time tests
	/**
	 * Test valid assignment time
	 */
	@Test
	void validTimeTest() {
		Course testCourse = new Course("CIS175", "Java II", 3, "Louis Schanus", 98.5);
		AssignmentTimeMethods AssignmentClass = new AssignmentTimeMethods(testCourse, 25, 5);
		assertEquals(AssignmentClass.getAssignmentTime(), "1 hour(s) and 12 minute(s)");
	}
	
	/**
	 * Test zero weekly time
	 */
	@Test
	void zeroWeeklyTimeTest() {
		Course testCourse = new Course("CIS175", "Java II", 3, "Louis Schanus", 98.5);
		AssignmentTimeMethods AssignmentClass = new AssignmentTimeMethods(testCourse, 0, 10);
		assertEquals(AssignmentClass.getAssignmentTime(), "0 hours and 0 minutes");
	}
	
	/**
	 * Test zero assignment time
	 */
	@Test
	void zeroAssignmentTimeTest() {
		Course testCourse = new Course("CIS175", "Java II", 3, "Louis Schanus", 98.5);
		AssignmentTimeMethods AssignmentClass = new AssignmentTimeMethods(testCourse, 10, 0);
		assertEquals(AssignmentClass.getAssignmentTime(), "0 hour(s) and 0 minute(s)");
	}
}