package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.Repository.StudentRepository;
import dmacc.beans.Student;


/**
 * Larry Paucar - Lpaucar
 * CIS175 -Spring 2024
 * Apr 8, 2024
 */
public class WebController {

@Autowired
StudentRepository repo;
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
	
}
