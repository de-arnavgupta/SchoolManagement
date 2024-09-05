package de.arnav.schoolmanagement.service;


import de.arnav.schoolmanagement.model.Student;
import de.arnav.schoolmanagement.repository.RoleRepository;
import de.arnav.schoolmanagement.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final RoleRepository roleRepository;

    public StudentService(StudentRepository studentRepository, RoleRepository roleRepository) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
    }

    public Iterable<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student with id " + id + " not found"));
    }

    public Student getStudentByName(String name) {
        return studentRepository.getByName(name);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        if (updatedStudent == null) {
            throw new NullPointerException("Updated student cannot be null");
        }
        Student existingStudent = getStudentById(id);
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setAddress(updatedStudent.getAddress());
        existingStudent.setRole(updatedStudent.getRole());
        return studentRepository.save(existingStudent);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Student with id " + id + " not found");
        }
        studentRepository.deleteById(id);
    }
}