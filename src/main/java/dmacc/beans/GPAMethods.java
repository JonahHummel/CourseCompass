/**
 * @author Mandy Wiedmier - mwiedmier2
 * CIS175 - Spring 2024
 * Apr 16, 2024
 */
package dmacc.beans;

import java.util.List;
import dmacc.beans.Course;

/**
 * 
 */
public class GPAMethods {
	private double totalGrade = 0;
	private int classCount = 0;
	private double gpaGrade = 0;
	
	/**
	 * @param courseList
	 * @return the gpaGrade
	 * A method to handle getting grade information from course list and return a 4 point GPA
	 */
	public double getGPA(List<Course> courseList) {
		for(Course course: courseList) { //Iterates through provided course list
			if(course.isCompleted() == true){ //Checks if course is completed
				this.totalGrade += course.getCurrentGrade(); //Update the grade count
				this.classCount += 1; //Update the completed course count
			}
		}
		this.setGPA(); //Calls set method
		return this.gpaGrade; //Returns the GPA
	}
	
	
	/**
	 * A method to set the GPA based on course count and total grade
	 */
	public void setGPA() {
		try {
			double hundPointGrade = this.totalGrade / (double)this.classCount; // Gets the hundred point scale
			this.gpaGrade = this.convertToFourPoint(hundPointGrade); //Calls conversion method and sets GPA
		}
		catch (ArithmeticException e) { //If errors occur set GPA to 0
			this.gpaGrade = 0;
		}
	}
	
	/**
	 * @param hundredPoint
	 * @return fourPoint
	 * A method to convert a 100 point scale grade into a 4 point grade
	 */
	public double convertToFourPoint(double hundredPoint) {
		double fourPoint = 0.0;
		
		if(hundredPoint >= 93) { // A Grade
			fourPoint = 4.0;
		}
		else if (hundredPoint < 93 && hundredPoint >= 90) { //A- Grade
			fourPoint = 3.7;
		}
		else if (hundredPoint < 90 && hundredPoint >= 87) { //B+ Grade
			fourPoint = 3.3;
		}
		else if (hundredPoint < 87 && hundredPoint >= 83) { //B Grade
			fourPoint = 3.0;
		}
		else if (hundredPoint < 83 && hundredPoint >= 80) { //B- Grade
			fourPoint = 2.7;
		}
		else if (hundredPoint < 80 && hundredPoint >= 77) { //C+ Grade
			fourPoint = 2.3;
		}
		else if (hundredPoint < 77 && hundredPoint >= 73) { //C Grade
			fourPoint = 2.0;
		}
		else if (hundredPoint < 73 && hundredPoint >= 70) { //C- Grade
			fourPoint = 1.7;
		}
		else if (hundredPoint < 70 && hundredPoint >= 67) { //D+ Grade
			fourPoint = 1.3;
		}
		else if (hundredPoint < 67 && hundredPoint >= 63) { //D Grade
			fourPoint = 1.0;
		}
		else if (hundredPoint < 63 && hundredPoint >= 60) { //D- Grade
			fourPoint = 0.7;
		}		
		else { //F Grade
			fourPoint = 0.0;
		}
		return fourPoint;
	}
}//End of file
