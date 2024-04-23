package dmacc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.Repository.CourseRepository;
import dmacc.Repository.StudentRepository;
import dmacc.beans.Course;
import dmacc.beans.GPAMethods;
import dmacc.beans.Student;


/**
 * Larry Paucar - Lpaucar
 * CIS175 -Spring 2024
 * Apr 8, 2024
 */
public class WebController {

@Autowired
StudentRepository repo;

@Autowired
CourseRepository courseRepo;

//View all Courses
@GetMapping({ "/", "viewAll" })
	public String viewAllStudents(Model model) {
		if(repo.findAll().isEmpty()) { return addNewStudent(model);
	}
		model.addAttribute("students", repo.findAll());
		return "results";
	}
	
//Add new Students
@GetMapping("/inputStudent")
    public String addNewStudent(Model model) {
        Student s = new Student();
        model.addAttribute("newStudent", s);
        return "input";
	}
	
@PostMapping("/inputStudent")
    public String addNewStudent(@ModelAttribute Student s, Model model) {
         repo.save(s);
         return viewAllStudents(model);
	}
	
//Edit Students
@GetMapping("/edit/{id}")
	public String showUpdateStudent(@PathVariable("id") long id, Model model) {
		Student s = repo.findById(id).orElse(null);
		model.addAttribute("newStudent", s);
		return "input"; }
	
//Update Students
@PostMapping("/update/{id}")
	public String reviseStudent(Student s, Model model) {
		repo.save(s);
		return viewAllStudents(model); 
	
	}
	
//Delete Students
@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Student s = repo.findById(id).orElse(null); repo.delete(s);
		return viewAllStudents(model);
	}
		
		
//Methods to add and delete courses 

// Add new Course
@GetMapping("/inputCourse")
	public String addNewCourse(Model model) {
		Course c = new Course();
	    model.addAttribute("newCourse", c);
	    return "inputCourse";
	    }

@PostMapping("/inputCourse")
	public String addNewCourse(@ModelAttribute Course newCourse, Model model) {
		courseRepo.save(newCourse);
	    return "redirect:/courses/viewAll";
	    }

// Edit Course
@GetMapping("/editCourse/{id}")
	public String showUpdateCourse(@PathVariable("id") long id, Model model) {
		Course course = courseRepo.findById(id).orElse(null);
	    	if (course == null) {
	        return "redirect:/courses/viewAll";
	    }
	    	model.addAttribute("course", course);
	        return "editCourse";
	    }

@PostMapping("/updateCourse/{id}")
	public String updateCourse(@PathVariable("id") long id, @ModelAttribute Course updatedCourse, Model model) {
		Course existingCourse = courseRepo.findById(id).orElse(null);
	    	if (existingCourse != null) {
	    		existingCourse.setCourseId(updatedCourse.getCourseId());
	            existingCourse.setCourseName(updatedCourse.getCourseName());
	            existingCourse.setCreditHours(updatedCourse.getCreditHours());
	            existingCourse.setInstructor(updatedCourse.getInstructor());
	            existingCourse.setCurrentGrade(updatedCourse.getCurrentGrade());
	            existingCourse.setCompleted(updatedCourse.isCompleted());
	            courseRepo.save(existingCourse);
	        }
	        return "redirect:/courses/viewAll";
	    }

// Delete Course
@GetMapping("/deleteCourse/{id}")
	public String deleteCourse(@PathVariable("id") long id, Model model) {
		courseRepo.deleteById(id);
	    return "redirect:/courses/viewAll";
	    }

// Find Current Courses for student (to do courses)
@GetMapping("/todo-courses")
public String getToDoCourses(@PathVariable("studentId") String studentId, Model model) {
	Student student = repo.findByStudentId(studentId); //  Query Added to Student Repository -- Determines which student to search courses for
	List<Course> todoCourses = courseRepo.findByStudentAndIsCompletedFalse(student); //  Query Added to Course Repository
	GPAMethods gpaCalc = new GPAMethods();
	double gpaDouble = gpaCalc.getGPA(student.getListOfCourses());
	model.addAttribute("todoCourses", todoCourses);
	model.addAttribute("GPAView", gpaDouble);
	return "courseList";
}  

//Display form to add assignment grade for a specific course
@GetMapping("/inputAssignmentGrade/{id}")
public String showAddAssignmentForm(@PathVariable Long id, Model model) {
    Course course = courseRepo.findById(id).orElse(null);
    if (course == null) {
        return "redirect:/courses/viewAll";
    }
    model.addAttribute("course", course);
    model.addAttribute("assignmentName", "");
    model.addAttribute("grade", null);
    return "addAssignmentForm";
}

// Display course details including assignment grades
@GetMapping("/viewAll")
public String viewAllCourses(Model model) {
    model.addAttribute("courses", courseRepo.findAll());
    return "courseList";
}

// Process form submission to add assignment grade
@PostMapping("/inputAssignmentGrade/{id}")
public String addAssignmentGrade(@PathVariable Long id, @RequestParam String assignmentName,
                                 @RequestParam Double grade, Model model) {
    Course course = courseRepo.findById(id).orElse(null);
    if (course != null && assignmentName != null && grade != null) {
        course.addAssignmentGrade(assignmentName, grade);
        courseRepo.save(course);
    }
    return "/courses/viewAll";
}

// Delete assignment grade from a course
@GetMapping("/deleteAssignment/{id}/{assignmentName}")
public String deleteAssignmentGrade(@PathVariable Long id, @PathVariable String assignmentName, Model model) {
    Course course = courseRepo.findById(id).orElse(null);
    if (course != null && course.getAssignmentGrades().containsKey(assignmentName)) {
        course.removeAssignmentGrade(assignmentName);
        courseRepo.save(course);
    }
    return "/courses/viewAll";
	}

}
