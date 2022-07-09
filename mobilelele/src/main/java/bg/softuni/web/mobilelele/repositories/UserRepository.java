package bg.softuni.web.mobilelele.repositories;

import bg.softuni.web.mobilelele.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByUsername(String username);
    Optional<UserEntity> findUserByUsernameIgnoreCase(String username);
}
