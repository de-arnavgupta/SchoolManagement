package de.arnav.schoolmanagement.repository;

import de.arnav.schoolmanagement.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin getByName(String name);
    Admin getByEmail(String email);
}
