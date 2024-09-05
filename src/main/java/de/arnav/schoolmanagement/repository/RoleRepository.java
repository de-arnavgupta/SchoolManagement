package de.arnav.schoolmanagement.repository;

import de.arnav.schoolmanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getByName(String name);

    Optional<Role> findByName(String name);
}
