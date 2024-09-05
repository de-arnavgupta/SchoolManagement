package de.arnav.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import de.arnav.schoolmanagement.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}
