package net.demo.service;
import java.util.List;

import net.demo.entity.Student;
public interface StudentService {
	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentId(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);
}
