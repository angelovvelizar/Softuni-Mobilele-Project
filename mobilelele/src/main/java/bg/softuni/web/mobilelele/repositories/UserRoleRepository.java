package bg.softuni.web.mobilelele.repositories;

import bg.softuni.web.mobilelele.models.entities.UserRoleEntity;
import bg.softuni.web.mobilelele.models.entities.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByRole(Role role);

}
