package net.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import net.demo.service.StudentService;
import net.demo.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students"; // Return the name of the view template
    }
    
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
    	Student student =new Student();
    	model.addAttribute("student", student);
    	return "create_student";
    }
    
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student")Student student) {
    	studentService.saveStudent(student);
		return "redirect:/students"; 	
    }
    
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id,Model model) {
    	model.addAttribute("student",studentService.getStudentId(id));
    	return "edit student";
    }
    
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,@ModelAttribute("student")Student student,Model model) {
    	
    	//get student from database by id 
    	Student existingStudent = studentService.getStudentId(id);
    	existingStudent.setFirstName(student.getFirstName());
    	existingStudent.setLastName(student.getLastName());
    	existingStudent.setEmail(student.getEmail());
    	
    	//save updated student  object
    	studentService.updateStudent(existingStudent);
    	return "redirect:/Students";
    	
    }
    //handler method to handle delete student request
    
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
    	studentService.deleteStudentById(id);
    	return "redirect:/Students";
    }
}


