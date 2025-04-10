package dabs.DABS.repository;

import dabs.DABS.model.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    Optional<Users> findByPhone(String phone);
    Optional<Users> findByEmail(String email);
}
