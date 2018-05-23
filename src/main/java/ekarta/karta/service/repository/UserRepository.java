package ekarta.karta.service.repository;

import ekarta.karta.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
     Optional<User> findUserByEmailContainingIgnoreCase(String email);
     void deleteByEmail(String email);
}
