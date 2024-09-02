package de.arnav.schoolmanagement.repository;

import de.arnav.schoolmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getByName(String name);
    Student getByEmail(String email);
}
