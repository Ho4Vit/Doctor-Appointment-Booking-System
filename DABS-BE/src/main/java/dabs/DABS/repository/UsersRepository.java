package dabs.DABS.repository;

import dabs.DABS.model.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
    Users save(Users users);
    Users findById(int id);
}
