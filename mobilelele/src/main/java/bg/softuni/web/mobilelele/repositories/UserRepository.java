package bg.softuni.web.mobilelele.repositories;

import bg.softuni.web.mobilelele.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByUsernameIgnoreCase(String username);
}
