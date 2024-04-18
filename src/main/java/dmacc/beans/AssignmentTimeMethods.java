/**
 * @author Mandy Wiedmier - mwiedmier2
 * CIS175 - Spring 2024
 * Apr 18, 2024
 */
package dmacc.beans;

import dmacc.beans.Course;
/**
 * Class for Assignment time calculation
 */
public class AssignmentTimeMethods {
	private int creditHours;
	private double weeklyPoints;
	private double assignmentPoints;
	
	/**
	 * No arg constructor to access methods 
	 */
	public AssignmentTimeMethods() {
		super();
	}

	/**
	 * @param creditClass
	 * @param weeklyPoints
	 * @param assignmentPoints
	 */
	public AssignmentTimeMethods(Course creditClass, double weeklyPoints, double assignmentPoints) {
		super();
		setCreditHours(creditClass.getCreditHours());
		setWeeklyPoints(weeklyPoints);
		setAssignmentPoints(assignmentPoints);
	}

	/**
	 * @return the creditHours
	 */
	public int getCreditHours() {
		return creditHours;
	}

	/**
	 * @param creditHours the creditHours to set
	 */
	public void setCreditHours(int creditHours) {
		if(creditHours < 1 || creditHours > 5) { //Credits can only be between 1 and 5
			throw new IllegalArgumentException("Credit hours need to be between 1 and 5.");
		}
		else {
			this.creditHours = creditHours;
		}
	}

	/**
	 * @return the weeklyPoints
	 */
	public double getWeeklyPoints() {
		return weeklyPoints;
	}

	/**
	 * @param weeklyPoints the weeklyPoints to set
	 */
	public void setWeeklyPoints(double weeklyPoints) {
		if(weeklyPoints < 0) { //Points need to be a positive number or zero
			throw new IllegalArgumentException("Weekly points need to be above zero.");
		}
		else {
			this.weeklyPoints = weeklyPoints;
		}
	}

	/**
	 * @return the assignmentPoints
	 */
	public double getAssignmentPoints() {
		return assignmentPoints;
	}

	/**
	 * @param assignmentPoints the assignmentPoints to set
	 */
	public void setAssignmentPoints(double assignmentPoints) {
		if(assignmentPoints < 0) { //Points need to be a positive number or zero
			throw new IllegalArgumentException("Assignment points need to be above zero.");
		}
		else {
			this.assignmentPoints = assignmentPoints;
		}
	}
	
	
	//Helper Methods
	/**
	 * @return the hoursAndMinutes
	 * A method to handle calculating the time it takes to complete an assignment and returns a string
	 */
	public String getAssignmentTime() {
		final int SIXTY = 60;
		final int ONE = 1;
		int studyTime = getStudyHours(this.creditHours);
		int hours;
		int minutes;
		String hoursAndMinutes = "";
		
		if(this.weeklyPoints < ONE) { //If to avoid a divide by zero error
			hoursAndMinutes = "0 hours and 0 minutes";
		}
		else {
			double projWeekPercentage = this.assignmentPoints/this.weeklyPoints; //Percentage of assignment to total points.
			double projHours = studyTime * projWeekPercentage; //Get hours for assignment by multiplying assignment percentage by weekly course study time.
			minutes = (int)(projHours * SIXTY); //Get the smallest time measurement whole number to ensure no rounding issues in later calculations.
			hours = minutes / SIXTY; //Whole number hours
			minutes = minutes % SIXTY; //Whole number minutes

			hoursAndMinutes = hours + " hour(s) and " + minutes + " minute(s)";
		}
		return hoursAndMinutes;
	}
	
	/**
	 * @return the totalStudyHours
	 * A method to handle calculating the study hours based on credit hours
	 */
	public static int getStudyHours(int creditHours) {
		final int avgStudyTimePerClassHour = 2; //DMACC classes have 2 outside hours of study for each lecture(credit) hour a week. 
		int totalStudyHours;
		
		totalStudyHours = creditHours * avgStudyTimePerClassHour; //Amount of total hours to work outside of lectures.
		return totalStudyHours;
	}
}