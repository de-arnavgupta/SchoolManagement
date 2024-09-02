package de.arnav.schoolmanagement.service;


import de.arnav.schoolmanagement.model.Role;
import de.arnav.schoolmanagement.model.Student;
import de.arnav.schoolmanagement.repository.RoleRepository;
import de.arnav.schoolmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private RoleRepository roleRepository;


    public StudentService(StudentRepository studentRepository, RoleRepository roleRepository) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
    }

    public Iterable<Student> getStudent() {
        return  studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student with id" + id + "not found"));
    }

    public Student getStudentByName(String name) {
        return studentRepository.getByName(name);
    }
    public Student updateStudent(Long id, Student updatedstudent) {
        Student existingStudent = getStudentById(id);
        existingStudent.setName(updatedstudent.getName());
        existingStudent.setEmail(updatedstudent.getEmail());
        existingStudent.setAddress(updatedstudent.getAddress());
        return studentRepository.save(existingStudent);
    }

    public Student createStudent(Student student) {
        Role studentRole = roleRepository.getByName("STUDENT");
        student.setRole(roleRepository.getByName("STUDENT"));
        return studentRepository.save(student);
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
