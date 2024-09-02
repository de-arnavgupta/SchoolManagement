package de.arnav.schoolmanagement.web;

import de.arnav.schoolmanagement.model.Student;
import de.arnav.schoolmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public ResponseEntity<Iterable<Student>> getStudents(){
        return ResponseEntity.ok(studentService.getStudent());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(Long id, Student updatedStudent){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.updateStudent(id, updatedStudent));
    }

    @PostMapping("/student/add")
    public ResponseEntity<Student> createStudent(@RequestBody @Valid Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
