package de.arnav.schoolmanagement.repository;

import de.arnav.schoolmanagement.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff getByName(String name);
    Staff getByEmail(String email);
}
