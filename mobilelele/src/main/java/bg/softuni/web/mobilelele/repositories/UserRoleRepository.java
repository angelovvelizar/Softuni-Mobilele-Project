package bg.softuni.web.mobilelele.repositories;

import bg.softuni.web.mobilelele.models.entities.UserRole;
import bg.softuni.web.mobilelele.models.entities.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByRole(Role role);

}
